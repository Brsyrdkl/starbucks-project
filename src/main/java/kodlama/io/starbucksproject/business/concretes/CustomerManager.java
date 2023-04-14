package kodlama.io.starbucksproject.business.concretes;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.business.abstracts.CustomerService;
import kodlama.io.starbucksproject.business.dto.request.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.response.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.response.GetAllCustomersResponse;
import kodlama.io.starbucksproject.entity.Customer;
import kodlama.io.starbucksproject.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerCheckService checkService;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();
        return response;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        Customer customer = mapper.map(request, Customer.class);
        checkIfCustomerAlreadyExists(customer.getNationalityIdentity());
        customer.setId(0);
        checkService.checkCustomer(customer);
        repository.save(customer);
        CreateCustomerResponse response = mapper.map(request, CreateCustomerResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        checkIfCustomerExists(id);
        repository.deleteById(id);
    }

    private void checkIfCustomerExists(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("There is no customer");
        }
    }
    private void checkIfCustomerAlreadyExists(String nationalityId) {
        for (Customer customer : repository.findAll()){
            if(customer.getNationalityIdentity().equals(nationalityId))
                throw new RuntimeException("There is already a customer");
        }
    }

}
