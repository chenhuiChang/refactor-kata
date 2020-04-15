import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class POSDisplayer {

    private String pageStateName;
    private DetailFrame detailDisplay;
    private Map marketBindings;
    private int[] displayDirection = new int[4];

    public POSDisplayer() {
        marketBindings = new HashMap<String,String>();
        pageStateName = "stage1";

    }

    public void process(ServletRequestInterface request) {
        String [] values
                = request.getParameterValues(pageStateName);
        setMarketBindings(values);

        setDisplayText(getDetailText() + " " + getProjectionText());
        setDisplayRegion(0,0,detailDisplay.getFrameLength(),detailDisplay.getFrameWidth());
    }

    private void setMarketBindings(String[] values) {
        if (values != null && values.length > 0) {
            marketBindings.put(pageStateName + getDateStamp(), values[0]);
        }
    }

    private void setDisplayText(String description) {
        detailDisplay = new DetailFrame();
        detailDisplay.setDescription(description);
        detailDisplay.show();
    }

    protected void setDisplayRegion(int aX, int aY, int bX, int bY) {
        displayDirection[0] = aX;
        displayDirection[1] = aY;
        displayDirection[2] = bX;
        displayDirection[3] = bY;
    }

    public int[] getMenuRegion() {
        return displayDirection;
    }

    private String getDetailText() {
        return "detail text";
    }

    private String getProjectionText() {
        return "projection info";
    }

    private String getDateStamp() {
        return new Date().toString();
    }
}
