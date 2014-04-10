package org.rchies.rhstack.service;

import org.switchyard.component.bean.Service;

@Service(SecondService.class)
public class SecondServiceBean implements SecondService {

	@Override
	public void secondCall(Credential credential) {
		System.out.println("SECOND CALL");
	}

}
