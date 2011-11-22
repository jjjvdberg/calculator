
package calculations.dev.powerservice.test;

import calculations.dev.PowerResponse;
import calculations.dev.powerservice.PowerService;
import junit.framework.TestCase;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.sif.service.Service;
import org.ebayopensource.turmeric.runtime.sif.service.ServiceFactory;

public class PowerServiceTest
    extends TestCase
{

    private PowerService m_proxy = null;

    public PowerServiceTest(String testcaseName) {
        super(testcaseName);
    }

    private PowerService getProxy()
        throws ServiceException
    {
        if (m_proxy == null) {
            String svcAdminName = "PowerService";
            String envName = "production";
            String clientName = "PowerService_Test";
            Service service = ServiceFactory.create(svcAdminName, envName, clientName, null);
            m_proxy = service.getProxy();
        }
        return m_proxy;
    }

    public void testPower()
        throws Exception
    {
        PowerResponse result = null;
        // TODO: REPLACE PARAMETER(S) WITH ACTUAL VALUE(S)
        result = getProxy().power(null);
        if (result == null) {
            throw new Exception("Response is Null");
        }
        // TODO: FIX FOLLOWING ASSERT STATEMENT
        assertTrue(false);
    }

}
