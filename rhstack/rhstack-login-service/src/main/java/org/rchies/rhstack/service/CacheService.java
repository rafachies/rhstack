package org.rchies.rhstack.service;

public interface CacheService {

	public Credential login(Credential credential);
	public Credential logout(Credential credential);
}
