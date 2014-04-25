package org.rchies.rhstack.transfer.rules;

import javax.inject.Singleton;

import org.rchies.rhstack.transfer.rules.annotation.TransferRules;

@Singleton
@TransferRules
public class TransferRulesManager extends RulesManager {

	@Override
	public String getSessionName() {
		return "rhstackKieSession";
	}
}
