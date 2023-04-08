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
		Customer customer = customerRepository.findByName(name).orElseThrow(() -> {
			throw new UsernameNotFoundException("아이디 혹은 비밀번호를 확인해주세요.");
		});
		
		return CustomerDetails.from(customer);
	}

}
