package ro.itschool.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.bookstore.entity.Customer;
import ro.itschool.bookstore.entity.CustomerAbstract;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
        Optional<Customer> findByUsername(String username);
}
