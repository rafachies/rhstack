//package org.rchies.rhstack.transfer.service;
//
//import org.junit.runner.RunWith;
//import org.switchyard.component.test.mixins.cdi.CDIMixIn;
//import org.switchyard.component.test.mixins.http.HTTPMixIn;
//import org.switchyard.test.BeforeDeploy;
//import org.switchyard.test.Invoker;
//import org.switchyard.test.ServiceOperation;
//import org.switchyard.test.SwitchYardRunner;
//import org.switchyard.test.SwitchYardTestCaseConfig;
//import org.switchyard.test.SwitchYardTestKit;
//import org.switchyard.test.mixins.PropertyMixIn;
//import org.switchyard.transform.config.model.TransformSwitchYardScanner;
//
//@RunWith(SwitchYardRunner.class)
//@SwitchYardTestCaseConfig(
//		config = SwitchYardTestCaseConfig.SWITCHYARD_XML,
//		scanners = TransformSwitchYardScanner.class,
//		mixins = {HTTPMixIn.class, PropertyMixIn.class, CDIMixIn.class }
//		)
//public class AccountSummaryProcessTest {
//
//	private SwitchYardTestKit testKit;
//	private HTTPMixIn httpMixIn;
//	private PropertyMixIn propMixIn;
//
//	@ServiceOperation("AccountSummaryProcess")
//	private Invoker service;
//
//
//	@BeforeDeploy
//	public void setTestProperties() {
//		propMixIn.set("org.switchyard.component.http.standalone.port", 18080);
//	}
//
////	@Test
////	public void testApproveSummary() throws Exception {
////		MockHandler service = testKit.replaceService("AccountSummaryProcess");
////
////		HttpGet get = new HttpGet("http://localhost:18080/rest/summary/approved");
////		httpMixIn.setDumpMessages(true);
////		httpMixIn.execute(get);
////
////		service.setWaitTimeout(400);
////		service.waitForOKMessage();
////
////		Assert.assertTrue(true);
////	}
//	
//	
////	@Test
////	public void testApproveSummary() throws Exception {
////		service.operation("approveSummary").sendInOut(null);
////		Assert.assertTrue(true);
////	}
//
//}
