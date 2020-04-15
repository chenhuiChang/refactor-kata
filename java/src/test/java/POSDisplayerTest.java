import org.junit.jupiter.api.Test;

import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class POSDisplayerTest {

    @Test
    public void test_hidden_method_transform() {
        POSDisplayer fakePOSDisplayer = new FakePOSDisplayer();
        fakePOSDisplayer.setDisplayRegion(1, 2, 3, 4);
        int[] menuRegion = fakePOSDisplayer.getMenuRegion();
        assertEquals(1, menuRegion[0]);
        assertEquals(2, menuRegion[1]);
        assertEquals(3, menuRegion[2]);
        assertEquals(4, menuRegion[3]);
    }

    void assume_production_code_before_and_after() {
        // before
        // POSDisplayer posDisplayer = new POSDisplayer();
        // ServletRequest servletRequestImpl = ServletRequestFactory::generate(); //very complicated impl
        // posDisplayer.process(servletRequestImpl);

        // after
        // POSDisplayer posDisplayer = new POSDisplayer();
        // ServletRequest servletRequestImpl = ServletRequestFactory::generate(); //very complicated impl
        // ServletRequestInterface servletRequestWrapper = new ServletRequestWrapper(servletRequestImpl); // wrap it
        // posDisplayer.process(servletRequestWrapper);
    }

    @Test
    void adapt_parameter_method() {
        FakePOSDisplayer fakePOSDisplayer = new FakePOSDisplayer();
        fakePOSDisplayer.process(new FakeServletRequest());
        // what to test? any assertion?
    }

    class FakePOSDisplayer extends POSDisplayer {
        @Override
        protected void setDisplayRegion(int aX, int aY, int bX, int bY) {
            super.setDisplayRegion(aX, aY, bX, bY);
        }
    }

    class FakeServletRequest implements ServletRequestInterface {
        public String[] getParameterValues(String pageStateName) {
            return new String[0];
        }
    }
}
