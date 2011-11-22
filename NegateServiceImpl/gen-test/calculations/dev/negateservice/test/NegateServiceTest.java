
package calculations.dev.negateservice.test;

import calculations.dev.NegateResponse;
import calculations.dev.negateservice.NegateService;
import junit.framework.TestCase;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.sif.service.Service;
import org.ebayopensource.turmeric.runtime.sif.service.ServiceFactory;

public class NegateServiceTest
    extends TestCase
{

    private NegateService m_proxy = null;

    public NegateServiceTest(String testcaseName) {
        super(testcaseName);
    }

    private NegateService getProxy()
        throws ServiceException
    {
        if (m_proxy == null) {
            String svcAdminName = "NegateService";
            String envName = "production";
            String clientName = "NegateService_Test";
            Service service = ServiceFactory.create(svcAdminName, envName, clientName, null);
            m_proxy = service.getProxy();
        }
        return m_proxy;
    }

    public void testNegate()
        throws Exception
    {
        NegateResponse result = null;
        // TODO: REPLACE PARAMETER(S) WITH ACTUAL VALUE(S)
        result = getProxy().negate(null);
        if (result == null) {
            throw new Exception("Response is Null");
        }
        // TODO: FIX FOLLOWING ASSERT STATEMENT
        assertTrue(false);
    }

}
