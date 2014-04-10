package org.rchies.rhstack.transfer.util;

import org.switchyard.Context;
import org.switchyard.component.resteasy.composer.RESTEasyBindingData;
import org.switchyard.component.resteasy.composer.RESTEasyContextMapper;

public class ProcessInstanceIdMapper extends RESTEasyContextMapper{

	private static final String PROCESS_INSTANCE_ID_KEY = "{urn:switchyard-component-bpm:bpm:1.0}processInstanceId";

	@Override
	public void mapTo(Context context, RESTEasyBindingData target) throws Exception {
		super.mapTo(context, target);
		Long piid = context.getPropertyValue(PROCESS_INSTANCE_ID_KEY);
		System.out.println("PIID: " + piid);
		if (piid != null) {
			target.addHeader("processInstanceId", piid.toString());
		}
	}
	
}
