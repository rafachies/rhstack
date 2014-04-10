package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.rchies.rhstack.transfer.entity.Account;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(EnrichComponent.class)
public class EnrichComponentBean implements EnrichComponent {

	@PersistenceContext(unitName = "rhstackUnit")
	private EntityManager entityManager;
	
	@Inject
	private Logger logger;
	
	@Override
	public TransferRequest enrich(TransferRequest transferRequest) {
		logger.info("EnricherService called for transfer " + transferRequest);
		Account debitAccount = (Account) entityManager.createQuery("select acc from Account acc where acc.accountId = '" + transferRequest.getDebitAccountId() + "'").getSingleResult();
		Account creditAccount = (Account) entityManager.createQuery("select acc from Account acc where acc.accountId = '" + transferRequest.getCreditAccountId()+ "'").getSingleResult();
		transferRequest.setDebitAccount(debitAccount);
		transferRequest.setCreditAccount(creditAccount);
		return transferRequest;
	}

}
