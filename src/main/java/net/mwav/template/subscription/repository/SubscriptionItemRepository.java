package net.mwav.template.subscription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mwav.template.subscription.entity.Subscription;
import net.mwav.template.subscription.entity.SubscriptionItem;

public interface SubscriptionItemRepository extends JpaRepository<SubscriptionItem, Long> {
	
	List<SubscriptionItem> findAllBySubscription(Subscription subscription);
	
}
