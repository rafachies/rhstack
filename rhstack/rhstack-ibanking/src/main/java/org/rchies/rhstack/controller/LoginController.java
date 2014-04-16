package org.rchies.rhstack.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.rchies.rhstack.client.LoginClient;
import org.rchies.rhstack.client.RestClient;
import org.rchies.rhstack.model.Credential;
import org.rchies.rhstack.model.CredentialDTO;

@Named
public class LoginController {

	@Inject 
	private Credential credential;

	@Inject
	private RestClient<LoginClient> restClient;

	@Inject
	private FacesContext facesContext;


	public String login() {
		LoginClient loginClient = restClient.getProxy(LoginClient.class);
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		CredentialDTO dto = new CredentialDTO();
		dto.setUsername(credential.getUsername());
		dto.setPassword(credential.getPassword());
		dto = loginClient.login(dto);
		if (dto.isAuthenticated() ) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Credentials authenticated with success", "Success");
			facesContext.addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid login/username, try again.", "Error");
			facesContext.addMessage(null, message);
		}
		return "home";
	}

	public String logout() {
		LoginClient loginClient = restClient.getProxy(LoginClient.class);
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		CredentialDTO dto = new CredentialDTO();
		dto.setUsername(credential.getUsername());
		loginClient.logout(dto);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout has completed successfuly", "Success");
		facesContext.addMessage(null, message);
		facesContext.getExternalContext().invalidateSession();
		return "home";
	}
}
