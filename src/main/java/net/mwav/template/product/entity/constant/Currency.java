package net.mwav.template.product.entity.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Currency {

	KRW("KRW"),
	EUR("EUR"),
	USD("USD"),
	JPY("JPY");

	private final String currency;

}
