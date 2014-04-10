package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(SummarySenderComponent.class)
public class SummarySenderComponentBean implements SummarySenderComponent {

	@Inject
	private Logger logger;
	
	@Override
	public void send() {
		logger.info("Sending summary ...");
	}

}
