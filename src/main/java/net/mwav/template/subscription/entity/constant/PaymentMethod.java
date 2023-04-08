package net.mwav.template.subscription.entity.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {

	CREDIT_CARD("CREDIT_CARD");

	private final String method;

}
