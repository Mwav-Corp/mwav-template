package net.mwav.template.subscription.repository;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.subscription.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

}
