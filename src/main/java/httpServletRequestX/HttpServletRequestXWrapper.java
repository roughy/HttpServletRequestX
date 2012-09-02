package httpServletRequestX;

import httpServletRequestX.accept.header.AcceptHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * This library wraps the {@see HttpServletRequest} and provides a set of convinience functions to handle with the Accept Content type options.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class HttpServletRequestXWrapper extends HttpServletRequestWrapper {

    private final AcceptHeader acceptHeader;

    /**
     * Constructor
     * 
     * @param request
     *            the {@see HttpServletRequest} object that has to be wrapped
     * @param acceptHeader
     *            the {@see AcceptHeader} object used for the content parsing
     */
    public HttpServletRequestXWrapper(HttpServletRequest request, AcceptHeader acceptHeader) {
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
