package kodlama.io.starbucksproject.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String dateOfBirthYear;
    private String nationalityIdentity;
}
