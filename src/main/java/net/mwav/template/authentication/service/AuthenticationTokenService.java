package net.mwav.template.authentication.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.mwav.template.authentication.entity.CustomerToken;
import net.mwav.template.authentication.jwt.JwtTokenProvider;
import net.mwav.template.authentication.repository.CustomerTokenRepository;
import net.mwav.template.customer.entity.Customer;
import net.mwav.template.security.dto.Authority;
import net.mwav.template.security.service.SecurityService;

@Service
@RequiredArgsConstructor
public class AuthenticationTokenService {

	private final JwtTokenProvider jwtTokenProvider;

	private final SecurityService securityService;

	private final CustomerTokenRepository customerTokenRepository;

	@Transactional(rollbackFor = Exception.class)
	public CustomerToken createToken(String name, String password) throws Exception {
		// authenticate
		Authentication authentication = securityService.authenticate(name, password);

		// create jwt token
		String subject = authentication.getName();
		Collection<?> authorities = authentication.getAuthorities();

		String accessToken = jwtTokenProvider.createAccessToken(subject, authorities);
		String refreshtoken = jwtTokenProvider.createRefreshToken(subject);

		Customer customer = Customer.builder().id(Long.valueOf(subject)).build();
		CustomerToken customerToken = CustomerToken.builder()
			.customer(customer)
			.accessToken(accessToken)
			.refreshToken(refreshtoken)
			.build();

		customerToken = createToken(customerToken);

		// return token
		return customerToken;
	}

	@Transactional(rollbackFor = Exception.class)
	public CustomerToken createToken(CustomerToken customerToken) {
		return customerTokenRepository.save(customerToken);
	}

	@Transactional(rollbackFor = Exception.class)
	public CustomerToken reissue(String refreshToken) {
		String subject = jwtTokenProvider.getSubject(refreshToken);
		CustomerToken customerToken = customerTokenRepository
			.findByCustomerIdAndRefreshToken(Long.valueOf(subject), refreshToken)
			.orElseThrow(EntityNotFoundException::new);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new Authority("ROLE_USER"));

		customerToken.setAccessToken(jwtTokenProvider.createAccessToken(subject, authorities));
		customerToken.setRefreshToken(jwtTokenProvider.createRefreshToken(subject));

		return customerToken;
	}
}
