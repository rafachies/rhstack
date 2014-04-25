package org.rchies.rhstack.transfer.rules;

import javax.inject.Singleton;

import org.rchies.rhstack.transfer.rules.annotation.OtherRules;

@Singleton
@OtherRules
public class OtherRulesManager extends RulesManager {

	@Override
	public String getSessionName() {
		return "otherKieSession";
	}
}
