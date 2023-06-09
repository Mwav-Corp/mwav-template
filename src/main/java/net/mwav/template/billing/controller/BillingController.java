package net.mwav.template.billing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.mwav.template.billing.controller.dto.TossRequest;
import net.mwav.template.billing.service.BillingService;
import net.mwav.template.customer.controller.dto.SignUpResponse;
import net.mwav.template.global.model.StandardResponseBody;
import net.mwav.template.security.service.SecurityResolver;

@RestController
@RequiredArgsConstructor
public class BillingController {

	private final BillingService billingService;

	@PostMapping(value = "/api/billing/toss", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> billInToss(@RequestBody TossRequest tossRequest) throws Exception {
		SecurityResolver.authorize(tossRequest.getCustomerId());
		billingService.billInToss(tossRequest);
		StandardResponseBody<SignUpResponse> standardResponseBody = StandardResponseBody.success();

		return ResponseEntity.status(HttpStatus.CREATED).body(standardResponseBody);
	}

}
