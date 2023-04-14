package kodlama.io.starbucksproject.adapters;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.entity.Customer;
import kodlama.io.starbucksproject.mernis.DCIKPSPublicSoap;
import org.springframework.stereotype.Service;


@Service
public class EDevletCheckServiceAdapter implements CustomerCheckService {

    @Override
    public void checkCustomer(Customer customer){
        DCIKPSPublicSoap client = new DCIKPSPublicSoap();
        try{
            boolean checked = client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityIdentity()),
                    customer.getFirstName().toUpperCase(),
                    customer.getLastName().toUpperCase(),
                    Integer.parseInt(customer.getDateOfBirthYear()));

            if(checked) System.out.println("Saved to DB");
            else {
                throw new Exception("Müşteri Doğrulanamadı");
            }

        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}


