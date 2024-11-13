package ro.itschool.bookstore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.itschool.bookstore.entity.Customer;
import ro.itschool.bookstore.repository.CustomerRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

//    public Customer addNewCustomer(Customer customer) {
//        log.info("Saving customer: {}", customer.getUsername());
//        return customerRepository.save(customer);
//    }

    public Customer addNewCustomer (Customer customer) {
        log.info("Register customer: {}", customer.getUsername());
        String encodedPassword = new BCryptPasswordEncoder().encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        return customerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByUsername(username)
                .map(customer -> (UserDetails) customer) // Return Student if found, cast to UserDetails
                                .orElseThrow(() -> new UsernameNotFoundException("User not found with " +
                                        "username: " + username));
    }
}
