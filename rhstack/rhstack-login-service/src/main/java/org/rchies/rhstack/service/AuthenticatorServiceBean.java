package org.rchies.rhstack.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(AuthenticatorService.class)
public class AuthenticatorServiceBean implements AuthenticatorService {

	@Inject
	private Logger logger;
	
	public Credential login(Credential credential) {
		System.out.println(credential.getUsername());
		logger.info("Authenticating {1} with password {2}", credential.getUsername(), credential.getPassword());
		if (credentialNotProvided(credential)) {
			credential.setAuthenticated(false);
			return credential;
		}
		if (credential.getUsername().equals(credential.getPassword())) {
			credential.setAuthenticated(true);
		}
		return credential;
	}

	private boolean credentialNotProvided(Credential credential) {
		return credential.getUsername() == null || credential.getPassword() == null;
	}
}
