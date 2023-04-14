package kodlama.io.starbucksproject.configuration.mernis;

import kodlama.io.starbucksproject.mernis.DCIKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MernisConfig {

    @Bean
    public DCIKPSPublicSoap getMernis(){
        return new DCIKPSPublicSoap();
    }
}
