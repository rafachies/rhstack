package org.rchies.rhstack.service;

import javax.inject.Inject;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(CacheService.class)
public class CacheServiceBean implements CacheService {

	@Inject
	private Logger logger;

	public Credential login(Credential credential) {
		String datagridHost = System.getProperty("datagrid.address");
		Integer datagridPort = Integer.valueOf(System.getProperty("datagrid.port"));
		logger.info("CacheService.login called for user: " + credential.getUsername());
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().host(datagridHost).port(datagridPort);
		RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
		RemoteCache<String, String> cache = cacheManager.getCache("loginCache");
		cache.put(credential.getUsername(), credential.getPassword());
		return credential;
	}

	@Override
	public Credential logout(Credential credential) {
		String datagridHost = System.getProperty("datagrid.address");
		Integer datagridPort = Integer.valueOf(System.getProperty("datagrid.port"));
		logger.info("CacheService.logout called for user: " + credential.getUsername());
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().host(datagridHost).port(datagridPort);
		RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
		RemoteCache<String, String> cache = cacheManager.getCache("loginCache");
		cache.remove(credential.getUsername());
		return credential;
	}

}
