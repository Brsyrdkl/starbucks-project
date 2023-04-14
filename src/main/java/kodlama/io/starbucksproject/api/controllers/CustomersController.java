package kodlama.io.starbucksproject.api.controllers;

import kodlama.io.starbucksproject.business.abstracts.CustomerService;
import kodlama.io.starbucksproject.business.dto.request.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.response.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.response.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomersController {
    private final CustomerService service;

    @GetMapping("/getAll")
    public List<GetAllCustomersResponse> getAll(){
        return service.getAll();
    }

    @PostMapping
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request){
        return service.add(request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
