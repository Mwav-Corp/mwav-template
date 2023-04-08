package net.mwav.template.authentication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.authentication.entity.CustomerToken;

public interface CustomerTokenRepository extends CrudRepository<CustomerToken, Long> {

	Optional<CustomerToken> findByCustomerIdAndRefreshToken(Long customerId, String refreshToken);

}
