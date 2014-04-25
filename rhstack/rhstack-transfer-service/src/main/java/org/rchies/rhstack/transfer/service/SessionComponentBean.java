package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(SessionComponent.class)
public class SessionComponentBean implements SessionComponent {

	@Inject
	private Logger logger;
	
	@Override
	public TransferRequest checkCredential(TransferRequest transferRequest) {
		String datagridAddress = System.getProperty("datagrid.address");
		Integer datagridPort = Integer.valueOf(System.getProperty("datagrid.port"));
		logger.info("SessionComponent called for user: " + transferRequest.getUsername());
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().host(datagridAddress).port(datagridPort);
		RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
		RemoteCache<String, String> cache = cacheManager.getCache("loginCache");
		if (sessionHasExpired(transferRequest, cache)) {
			transferRequest.setApproved(false);
			transferRequest.setRejectionReason("Session expired. Please, login and try again");
		}
		return transferRequest;
		
	}

	private boolean sessionHasExpired(TransferRequest transferRequest, RemoteCache<String, String> cache) {
		return !cache.containsKey(transferRequest.getUsername());
	}

}
