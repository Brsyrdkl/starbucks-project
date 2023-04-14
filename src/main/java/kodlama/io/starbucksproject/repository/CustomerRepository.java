package kodlama.io.starbucksproject.repository;

import kodlama.io.starbucksproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
