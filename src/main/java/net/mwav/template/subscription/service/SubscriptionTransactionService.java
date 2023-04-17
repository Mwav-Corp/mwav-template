package net.mwav.template.subscription.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.mwav.template.subscription.entity.SubscriptionTransaction;
import net.mwav.template.subscription.repository.SubscriptionTransactionRepository;

@Service
@RequiredArgsConstructor
public class SubscriptionTransactionService {

	private final SubscriptionTransactionRepository subscriptionTransactionRepository;

	@Transactional(rollbackFor = Exception.class)
	public SubscriptionTransaction createTransaction(SubscriptionTransaction subscriptionTransaction) {
		return subscriptionTransactionRepository.save(subscriptionTransaction);
	}

}
