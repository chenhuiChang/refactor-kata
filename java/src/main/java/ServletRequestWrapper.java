public class ServletRequestWrapper implements ServletRequestInterface {
    private final ServletRequest servletRequest;

    public ServletRequestWrapper(ServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public String[] getParameterValues(String pageStateName) {
        return servletRequest.getParameterValues(pageStateName);
    }
}
