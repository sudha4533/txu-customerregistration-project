package com.txu.registrationapp.soapservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.9
 * Wed Aug 17 04:03:38 CDT 2016
 * Generated source version: 2.2.9
 * 
 */
 
@WebService(targetNamespace = "http://soap.service.registration.txu.com/", name = "UtilityPlanService")
@XmlSeeAlso({ObjectFactory.class})
public interface UtilityPlanService {

    @WebMethod
    @RequestWrapper(localName = "getServicePlans", targetNamespace = "http://soap.service.registration.txu.com/", className = "com.txu.registrationapp.soapservice.GetServicePlans")
    @ResponseWrapper(localName = "getServicePlansResponse", targetNamespace = "http://soap.service.registration.txu.com/", className = "com.txu.registrationapp.soapservice.GetServicePlansResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.txu.registrationapp.soapservice.ServicePlan> getServicePlans();
}
