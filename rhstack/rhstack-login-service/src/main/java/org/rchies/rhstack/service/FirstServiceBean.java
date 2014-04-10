package org.rchies.rhstack.service;

import org.switchyard.component.bean.Service;

@Service(FirstService.class)
public class FirstServiceBean implements FirstService {

	@Override
	public void call(Credential credential) {
		System.out.println("FIRST CALL");
	}

}
