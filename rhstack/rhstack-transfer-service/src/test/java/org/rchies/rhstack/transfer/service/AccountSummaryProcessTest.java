package org.rchies.rhstack.transfer.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rchies.rhstack.transfer.dto.AccountSummaryRequest;
import org.switchyard.Scope;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.MockHandler;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;
import org.switchyard.test.mixins.PropertyMixIn;
import org.switchyard.transform.config.model.TransformSwitchYardScanner;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(
		config = SwitchYardTestCaseConfig.SWITCHYARD_XML,
		scanners = TransformSwitchYardScanner.class,
		mixins = {HTTPMixIn.class, PropertyMixIn.class, CDIMixIn.class }
		)
public class AccountSummaryProcessTest {

	private static final String CORRELATION_KEY_URN = "{urn:switchyard-component-bpm:bpm:1.0}correlationKey";
	private static final String CORRELATION_KEY = "correlationKey";
	
	private SwitchYardTestKit testKit;

	private HTTPMixIn httpMixIn;

	@ServiceOperation("AccountSummaryProcess")
	private Invoker service;

	@Test
	@Ignore
	public void testCorrelationKey() throws Exception {
		MockHandler summarySenderMock = testKit.replaceService("SummarySenderComponent");
		service.property(CORRELATION_KEY_URN, "AABBCC", Scope.EXCHANGE).operation("askSummary").sendInOut(new AccountSummaryRequest()).getContext();
		service.property(CORRELATION_KEY_URN, "AABBCC", Scope.EXCHANGE).operation("approveSummary").sendInOnly(null);
		summarySenderMock.setWaitTimeout(400);
		summarySenderMock.waitForOKMessage();
		Assert.assertTrue(true);
	}

	@Test
	public void testWithBinding() throws Exception {
		MockHandler summarySenderMock = testKit.replaceService("SummarySenderComponent");
		httpMixIn.setDumpMessages(true);

		HttpPost postMethod = new HttpPost("http://localhost:8080/rest/summary");
		postMethod.setHeader("Content-Type", "application/json");
		postMethod.setHeader(CORRELATION_KEY, "AABBCC");
		postMethod.setEntity( new StringEntity("{\"months\":\"3\",\"accountId\": \"4444X\"}"));
		httpMixIn.execute(postMethod);
		
		httpMixIn.initialize();
		HttpGet getMethod = new HttpGet("http://localhost:8080/rest/summary/approve");
		getMethod.setHeader(CORRELATION_KEY, "AABBCC");
		httpMixIn.execute(getMethod);

		summarySenderMock.setWaitTimeout(400);
		summarySenderMock.waitForOKMessage();
		Assert.assertTrue(true);
	}

}
