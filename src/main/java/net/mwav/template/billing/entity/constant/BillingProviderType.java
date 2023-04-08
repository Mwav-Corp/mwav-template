package net.mwav.template.billing.entity.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BillingProviderType {

	TOSS("TOSS"),
	BOOTPAY("BOOTPAY");

	private final String provider;

}
