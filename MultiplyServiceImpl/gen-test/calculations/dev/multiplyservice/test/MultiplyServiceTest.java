
package calculations.dev.multiplyservice.test;

import calculations.dev.MultiplyResponse;
import calculations.dev.multiplyservice.MultiplyService;
import junit.framework.TestCase;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.sif.service.Service;
import org.ebayopensource.turmeric.runtime.sif.service.ServiceFactory;

public class MultiplyServiceTest
    extends TestCase
{

    private MultiplyService m_proxy = null;

    public MultiplyServiceTest(String testcaseName) {
        super(testcaseName);
    }

    private MultiplyService getProxy()
        throws ServiceException
    {
        if (m_proxy == null) {
            String svcAdminName = "MultiplyService";
            String envName = "production";
            String clientName = "MultiplyService_Test";
            Service service = ServiceFactory.create(svcAdminName, envName, clientName, null);
            m_proxy = service.getProxy();
        }
        return m_proxy;
    }

    public void testMultiply()
        throws Exception
    {
        MultiplyResponse result = null;
        // TODO: REPLACE PARAMETER(S) WITH ACTUAL VALUE(S)
        result = getProxy().multiply(null);
        if (result == null) {
            throw new Exception("Response is Null");
        }
        // TODO: FIX FOLLOWING ASSERT STATEMENT
        assertTrue(false);
    }

}
