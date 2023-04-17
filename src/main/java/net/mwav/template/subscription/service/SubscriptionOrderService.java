package net.mwav.template.subscription.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.mwav.template.subscription.entity.SubscriptionOrder;
import net.mwav.template.subscription.repository.SubscriptionOrderRepository;

@Service
@RequiredArgsConstructor
public class SubscriptionOrderService {

	private final SubscriptionOrderRepository subscriptionOrderRepository;

	@Transactional(rollbackFor = Exception.class)
	public SubscriptionOrder createOrder(SubscriptionOrder subscriptionOrder) {
		subscriptionOrder.onCreate();
		return subscriptionOrderRepository.save(subscriptionOrder);
	}

}
