package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.model.Customer;
import edu.rowan.rowansentimentanalysis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public void saveJesse() {
        customerRepository.save(new Customer("Jesse", "Malinosky"));
    }
}
