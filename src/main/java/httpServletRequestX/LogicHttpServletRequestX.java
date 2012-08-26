package httpServletRequestX;

import httpServletRequestX.accept.AcceptHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LogicHttpServletRequestX extends HttpServletRequestWrapper {

    private final AcceptHeader acceptHeader;

    /**
     * TODO
     * 
     * @param request
     */
    public LogicHttpServletRequestX(HttpServletRequest request, AcceptHeader acceptHeader) {
        super(request);

        this.acceptHeader = acceptHeader;
    }

    /**
     * TODO
     * 
     * @return
     */
    public AcceptHeader getAccept() {
        return acceptHeader.setContent(getHeader("accept"));
    }

    /**
     * TODO
     * 
     * @return
     */
    public String getAcceptCharset() {
        return getHeader("accept-charset");
    }

    /**
     * TODO
     * 
     * @return
     */
    public String getAcceptEncoding() {
        return getHeader("accept-encoding");
    }

    /**
     * TODO
     * 
     * @return
     */
    public String getAcceptLanguage() {
        return getHeader("accept-language");
    }

}
