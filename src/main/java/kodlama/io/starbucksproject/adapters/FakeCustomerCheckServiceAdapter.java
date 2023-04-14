package kodlama.io.starbucksproject.adapters;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.entity.Customer;

import java.util.Random;

public class FakeCustomerCheckServiceAdapter implements CustomerCheckService {
    @Override
    public void checkCustomer(Customer customer) {
        boolean isCheckSuccessful = new Random().nextBoolean();
        if (!isCheckSuccessful){
            throw new RuntimeException("Bu kişinin bilgileri doğru değil");
        }
    }
}
