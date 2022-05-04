/*
 * StandAloneApp.java
 */

//package jp.co.benefitone.common.sample.standalone;

import java.util.Hashtable;
import java.util.Iterator;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.sample.business.CustomerFindServiceRemote;
import jp.co.benefitone.common.sample.business.CustomerFindServiceRemoteHome;
import jp.co.benefitone.common.sample.business.FindCustomerCriteria;
import jp.co.benefitone.common.sample.business.FindCustomerResult;
import jp.co.benefitone.common.sample.model.CustomerVO;

/**
 * CustomerFindService EJB Client Test.
 */
public class StandAloneApp {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        Hashtable env = new Hashtable();
//        env.put("providerUrl", "iiop://192.168.1.10:3700");
//        InitialContext context = new InitialContext(env);
        InitialContext context = new InitialContext();
        Object obj = context.lookup("ejb/CustomerFindService");
        
        CustomerFindServiceRemoteHome home =
                (CustomerFindServiceRemoteHome)
                PortableRemoteObject.narrow(obj,
                CustomerFindServiceRemoteHome.class);
        
        CustomerFindServiceRemote service = home.create();
        
        FindCustomerResult result =
                service.findCustomer(new FindCustomerCriteria(),
                new BusinessSession());
        
        for (Iterator it = result.getResult().iterator(); it.hasNext();) {
            CustomerVO customer = (CustomerVO)it.next();
            System.out.println(customer);
        }
    }
    
}
