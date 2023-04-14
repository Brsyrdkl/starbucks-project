package kodlama.io.starbucksproject.business.abstracts;

import kodlama.io.starbucksproject.business.dto.request.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.response.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.response.GetAllCustomersResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomersResponse> getAll();
    CreateCustomerResponse add(CreateCustomerRequest request);

    void delete(int id);
}
