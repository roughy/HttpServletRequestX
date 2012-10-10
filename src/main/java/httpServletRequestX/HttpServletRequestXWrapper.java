package httpServletRequestX;

import httpServletRequestX.accept.header.AcceptHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * This library wraps the {@see HttpServletRequest} and provides a set of convinience functions to handle the accept
 * content type options.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class HttpServletRequestXWrapper extends HttpServletRequestWrapper {

    private final AcceptHeader acceptHeader;

    /**
     * Constructor
     * 
     * @param request the {@see HttpServletRequest} object that has to be wrapped
     * @param acceptHeader the {@see AcceptHeader} object used for the content parsing
     */
    public HttpServletRequestXWrapper(final HttpServletRequest request, final AcceptHeader acceptHeader) {
        super(request);

        this.acceptHeader = acceptHeader;
    }

    /**
     * Convenience getter function for the accept header (e.g. "ACCEPT: text/html"). Parses the content string and
     * builds the {@see AcceptHeader}
     * 
     * @return the {@see AcceptHeader} parsed out of the request header string (e.g. "ACCEPT: text/html")
     */
    public AcceptHeader getAccept() {
        return acceptHeader.setContent(getHeader("accept"));
    }

    /**
     * Convenience getter function for the accept charset header (e.g. "ACCEPT-CHARSET: utf-8")
     * 
     * @return an unparsed string from the related request header (e.g. "utf-8")
     */
    public String getAcceptCharset() {
        return getHeader("accept-charset");
    }

    /**
     * Convenience getter function for the accept encoding header (e.g. "ACCEPT-ENCODING: utf-8")
     * 
     * @return an unparsed string from the related request header (e.g. "utf-8")
     */
    public String getAcceptEncoding() {
        return getHeader("accept-encoding");
    }

    /**
     * Convenience getter function for the accept language header (e.g. "ACCEPT-LANGUAGE: en.uk")
     * 
     * @return an unparsed string from the related request header (e.g. "en.uk")
     */
    public String getAcceptLanguage() {
        return getHeader("accept-language");
    }

}
