package kodlama.io.starbucksproject.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCustomersResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirthYear;
    private String nationalityIdentity;
}
