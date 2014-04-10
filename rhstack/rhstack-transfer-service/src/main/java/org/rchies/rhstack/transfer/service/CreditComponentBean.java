package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.rchies.rhstack.transfer.entity.Account;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(CreditComponent.class)
public class CreditComponentBean implements CreditComponent {

	@PersistenceContext(unitName = "rhstackUnit")
	private EntityManager entityManager;
	
	@Inject
	private Logger logger;
	
	@Override
	public void credit(TransferRequest transferRequest) {
		logger.info("CreditService called for account: " + transferRequest.getCreditAccount());
		Query query = entityManager.createQuery("select obj from Account obj where accountid = :accountId");
		query.setParameter("accountId", transferRequest.getCreditAccountId());
		Account account = (Account) query.getSingleResult();
		account.credit(transferRequest.getValue());
		entityManager.persist(account);
		
	}

}
