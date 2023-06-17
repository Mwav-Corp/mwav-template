package net.mwav.template.security.handler;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.mwav.template.customer.entity.Customer;
import net.mwav.template.customer.repository.CustomerRepository;
import net.mwav.template.security.dto.CustomerDetails;

@RequiredArgsConstructor
@Service
public class BasicDetailService implements UserDetailsService {

	private final CustomerRepository customerRepository;

	@Override
	public CustomerDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// This method overrides UserDetailsService.loadUserByUsername, so it must throw UsernameNotFoundException.
		// When a customer is not registered and if you use Optional.orElseThrow(Supplier<? extends RuntimeException>) to throw exception,
		// it throws UsernameNotFoundException related to RuntimeException.
		// RuntimeException is not throwable in this method(because it only throws UsernameNotFoundException) and it is immutable, maven compile fails.
		Customer customer = customerRepository.findByName(name).orElse(null);

		if (customer == null) {
			throw new UsernameNotFoundException("아이디 혹은 비밀번호를 확인해주세요.");
		}

		return CustomerDetails.from(customer);
	}

}
