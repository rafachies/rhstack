package org.rchies.rhstack.client;

import javax.annotation.PostConstruct;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class RestClient<T extends RestClientInterface> {

	private static final String REST_ENDPOINT = "http://localhost:8380";

	@PostConstruct
	public void postConstruct() {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
	}
	
	public T getProxy(Class<T> clientClass) {
		return (T) ProxyFactory.create(clientClass, REST_ENDPOINT);
	}
	
}
