package org.rchies.rhstack.payment.component;

import javax.inject.Inject;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.rchies.rhstack.payment.dto.PaymentRequest;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(SessionComponent.class)
public class SessionComponentBean implements SessionComponent {

	@Inject
	private Logger logger;
	
	@Override
	public PaymentRequest check(PaymentRequest paymentRequest) {
		logger.info("SesssionCheckerService.check called for user: " + paymentRequest.getUsername());
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().host("localhost").port(11322);
		RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
		RemoteCache<String, String> cache = cacheManager.getCache("loginCache");
		if (sessionHasExpired(paymentRequest, cache)) {
			paymentRequest.setApproved(false);
			paymentRequest.setRejectionReason("Session expired. Please, login and try again");
			logger.info("Session expired for user {}. Please, login and try again", paymentRequest.getUsername());
		}
		return paymentRequest;
	}

	private boolean sessionHasExpired(PaymentRequest paymentRequest, RemoteCache<String, String> cache) {
		return !cache.containsKey(paymentRequest.getUsername());
	}

}
