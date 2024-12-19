package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final PasswordEncoder passwordEncoder;

    public Customer register( Customer customer ) {
        Optional<Customer> optionalCustomer = customerRepository.findByUsernameEqualsAllIgnoreCase(customer.getUsername());
        if (optionalCustomer.isPresent()) {
            return customer;
        }
        customer.setPassword(passwordEncoder.encode( customer.getPassword() ));
        customerRepository.save(customer);
        return customer;
    }

}
