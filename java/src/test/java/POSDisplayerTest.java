import org.junit.jupiter.api.Test;

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

    class FakePOSDisplayer extends POSDisplayer {
        @Override
        protected void setDisplayRegion(int aX, int aY, int bX, int bY) {
            super.setDisplayRegion(aX, aY, bX, bY);
        }
    }
}
