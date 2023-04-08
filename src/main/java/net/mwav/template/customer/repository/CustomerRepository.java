package net.mwav.template.customer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Optional<Customer> findByName(String name);

	Optional<Customer> findByNameOrEmail(String name, String email);

}
