package net.mwav.template.subscription.repository;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.subscription.entity.SubscriptionTransaction;

public interface SubscriptionTransactionRepository extends CrudRepository<SubscriptionTransaction, Long> {
    
}
