package org.rchies.rhstack.vendor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="VendorPayment", name="VendorPayment", targetNamespace="http://org.rchies.rhstack/")
public class VendorPaymentWS {

	@WebMethod(action="payment")
	@WebResult(name = "code")
	public String payment(@WebParam(name = "paymentRequest") VendorPaymentRequest vendorPaymentRequest) {
		System.out.println(vendorPaymentRequest);
		return "AXV78OY";
	}
}
 	