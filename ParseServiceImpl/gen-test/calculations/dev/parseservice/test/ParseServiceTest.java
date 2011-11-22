
package calculations.dev.parseservice.test;

import calculations.dev.ParseResponse;
import calculations.dev.parseservice.ParseService;
import junit.framework.TestCase;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.sif.service.Service;
import org.ebayopensource.turmeric.runtime.sif.service.ServiceFactory;

public class ParseServiceTest
    extends TestCase
{

    private ParseService m_proxy = null;

    public ParseServiceTest(String testcaseName) {
        super(testcaseName);
    }

    private ParseService getProxy()
        throws ServiceException
    {
        if (m_proxy == null) {
            String svcAdminName = "ParseService";
            String envName = "production";
            String clientName = "ParseService_Test";
            Service service = ServiceFactory.create(svcAdminName, envName, clientName, null);
            m_proxy = service.getProxy();
        }
        return m_proxy;
    }

    public void testParse()
        throws Exception
    {
        ParseResponse result = null;
        // TODO: REPLACE PARAMETER(S) WITH ACTUAL VALUE(S)
        result = getProxy().parse(null);
        if (result == null) {
            throw new Exception("Response is Null");
        }
        // TODO: FIX FOLLOWING ASSERT STATEMENT
        assertTrue(false);
    }

}
