package net.mwav.template.subscription.repository;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.subscription.entity.SubscriptionOrder;

public interface SubscriptionOrderRepository extends CrudRepository<SubscriptionOrder, Long> {

}
