
package com.txu.registrationapp.soapservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.9
 * Wed Aug 17 04:03:37 CDT 2016
 * Generated source version: 2.2.9
 * 
 */

public final class UtilityPlanService_UtilityPlanServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://soap.service.registration.txu.com/", "UtilityPlanServiceImpl");

    private UtilityPlanService_UtilityPlanServiceImplPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = UtilityPlanServiceImpl.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        UtilityPlanServiceImpl ss = new UtilityPlanServiceImpl(wsdlURL, SERVICE_NAME);
        UtilityPlanService port = ss.getUtilityPlanServiceImplPort();  
        
        {
        System.out.println("Invoking getServicePlans...");
        java.util.List<com.txu.registrationapp.soapservice.ServicePlan> _getServicePlans__return = port.getServicePlans();
        System.out.println("getServicePlans.result=" + _getServicePlans__return);


        }

        System.exit(0);
    }

}
