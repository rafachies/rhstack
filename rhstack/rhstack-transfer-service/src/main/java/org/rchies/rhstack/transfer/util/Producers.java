package org.rchies.rhstack.transfer.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producers {

	@Produces
	@ApplicationScoped
	private Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass().getName());
	}
	
}
