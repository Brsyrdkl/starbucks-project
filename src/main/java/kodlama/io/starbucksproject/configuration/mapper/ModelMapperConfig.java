package kodlama.io.starbucksproject.configuration.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
//    @Bean
//    public void initializeModelMapperStrategy() {
//        getModelMapper().getConfiguration().setAmbiguityIgnored(true);
//        getModelMapper().getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT);
//    }
}
