package org.rchies.rhstack.transfer.util;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.switchyard.Context;
import org.switchyard.Scope;
import org.switchyard.component.resteasy.composer.RESTEasyBindingData;
import org.switchyard.component.resteasy.composer.RESTEasyContextMapper;

public class ProcessInstanceIdMapper extends RESTEasyContextMapper{

	private static final String CORRELATION_KEY_URN = "{urn:switchyard-component-bpm:bpm:1.0}correlationKey";
	private static final String CORRELATIONKEY_KEY = "CORRELATIONKEY";

	@Override
	public void mapFrom(RESTEasyBindingData source, Context context) throws Exception {
		Set<Entry<String, List<String>>> keys = source.getHeaders().entrySet();
		for (Entry<String, List<String>> entry : keys) {
			if(CORRELATIONKEY_KEY.equals(entry.getKey().toUpperCase())) {
				context.setProperty(CORRELATION_KEY_URN, entry.getValue().get(0), Scope.EXCHANGE);
			}
		}
	}
	
	@Override
	public void mapTo(Context context, RESTEasyBindingData target) throws Exception {
		super.mapTo(context, target);
		target.addHeader("Access-Control-Allow-Origin", "*");
        target.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	}
	
}
