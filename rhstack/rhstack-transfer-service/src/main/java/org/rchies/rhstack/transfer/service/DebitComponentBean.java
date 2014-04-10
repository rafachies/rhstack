package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.rchies.rhstack.transfer.entity.Account;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(DebitComponent.class)
public class DebitComponentBean implements DebitComponent {

	@PersistenceContext(unitName = "rhstackUnit")
	private EntityManager entityManager;
	
	@Inject
	private Logger logger;
	
	@Override
	public void debit(TransferRequest transferRequest) {
		logger.info("DebitService called for account: " + transferRequest.getDebitAccount());
		Query query = entityManager.createQuery("select obj from Account obj where accountid = :accountId");
		query.setParameter("accountId", transferRequest.getDebitAccountId());
		Account account = (Account) query.getSingleResult();
		account.debit(transferRequest.getValue());
		entityManager.persist(account);
	}

}
