package net.mwav.template.billing.repository;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.billing.entity.Billing;

public interface BillingRepository extends CrudRepository<Billing, Long> {

}
