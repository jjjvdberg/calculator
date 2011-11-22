
package calculations.dev.sumservice.test;

import calculations.dev.SumResponse;
import calculations.dev.sumservice.SumService;
import junit.framework.TestCase;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.sif.service.Service;
import org.ebayopensource.turmeric.runtime.sif.service.ServiceFactory;

public class SumServiceTest
    extends TestCase
{

    private SumService m_proxy = null;

    public SumServiceTest(String testcaseName) {
        super(testcaseName);
    }

    private SumService getProxy()
        throws ServiceException
    {
        if (m_proxy == null) {
            String svcAdminName = "SumService";
            String envName = "production";
            String clientName = "SumService_Test";
            Service service = ServiceFactory.create(svcAdminName, envName, clientName, null);
            m_proxy = service.getProxy();
        }
        return m_proxy;
    }

    public void testSum()
        throws Exception
    {
        SumResponse result = null;
        // TODO: REPLACE PARAMETER(S) WITH ACTUAL VALUE(S)
        result = getProxy().sum(null);
        if (result == null) {
            throw new Exception("Response is Null");
        }
        // TODO: FIX FOLLOWING ASSERT STATEMENT
        assertTrue(false);
    }

}
