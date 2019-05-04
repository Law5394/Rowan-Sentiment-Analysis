package edu.rowan.rowansentimentanalysis.repository;

import java.util.List;

import edu.rowan.rowansentimentanalysis.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
