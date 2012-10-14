package httpServletRequestX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Dummy request implementation of {@link HttpServletRequest} interface. Lots of implemented functions are without any
 * functionality. Only those ones needed for testing purposes.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class HttpServletRequestDummy implements HttpServletRequest {

    public String       accept         = "text/*;q=0.5,application/json,text/html,application/*;q=0.1";
    public String       acceptCharset  = "UTF-8";
    public String       acceptEncoding = "UTF-8";
    public String       acceptLanguage = "de-de";
    public final String others         = "...";

    public String getTop() {
        return "application/json";
    }

    /**
     * Only returns values if parameter name is one of the values [accept | accept-charset | accept-encoding |
     * accept-language]. Returned values are always the values of the related public fields.
     */
    public String getHeader(String name) {
        name = name.toLowerCase();
        if (name.equals("accept")) {
            return accept;
        }
        if (name.equals("accept-charset")) {
            return acceptCharset;
        }
        if (name.equals("accept-encoding")) {
            return acceptEncoding;
        }
        if (name.equals("accept-language")) {
            return acceptLanguage;
        }

        return null;
    }

    public Object getAttribute(final String name) {
        return null;
    }

    public Enumeration<?> getAttributeNames() {
        return null;
    }

    public String getCharacterEncoding() {
        return null;
    }

    public void setCharacterEncoding(final String env) throws UnsupportedEncodingException {

    }

    public int getContentLength() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    public String getParameter(final String name) {
        return null;
    }

    public Enumeration<?> getParameterNames() {
        return null;
    }

    public String[] getParameterValues(final String name) {
        return null;
    }

    public Map<?, ?> getParameterMap() {
        return null;
    }

    public String getProtocol() {
        return null;
    }

    public String getScheme() {
        return null;
    }

    public String getServerName() {
        return null;
    }

    public int getServerPort() {
        return 0;
    }

    public BufferedReader getReader() throws IOException {
        return null;
    }

    public String getRemoteAddr() {
        return null;
    }

    public String getRemoteHost() {
        return null;
    }

    public void setAttribute(final String name, final Object o) {

    }

    public void removeAttribute(final String name) {

    }

    public Locale getLocale() {
        return null;
    }

    public Enumeration<?> getLocales() {
        return null;
    }

    public boolean isSecure() {
        return false;
    }

    public RequestDispatcher getRequestDispatcher(final String path) {
        return null;
    }

    public String getRealPath(final String path) {
        return null;
    }

    public int getRemotePort() {
        return 0;
    }

    public String getLocalName() {
        return null;
    }

    public String getLocalAddr() {
        return null;
    }

    public int getLocalPort() {
        return 0;
    }

    public String getAuthType() {
        return null;
    }

    public Cookie[] getCookies() {
        return null;
    }

    public long getDateHeader(final String name) {
        return 0;
    }

    public Enumeration<?> getHeaders(final String name) {
        return null;
    }

    public Enumeration<?> getHeaderNames() {
        return null;
    }

    public int getIntHeader(final String name) {
        return 0;
    }

    public String getMethod() {
        return null;
    }

    public String getPathInfo() {
        return null;
    }

    public String getPathTranslated() {
        return null;
    }

    public String getContextPath() {
        return null;
    }

    public String getQueryString() {
        return null;
    }

    public String getRemoteUser() {
        return null;
    }

    public boolean isUserInRole(final String role) {
        return false;
    }

    public Principal getUserPrincipal() {
        return null;
    }

    public String getRequestedSessionId() {
        return null;
    }

    public String getRequestURI() {
        return null;
    }

    public StringBuffer getRequestURL() {
        return null;
    }

    public String getServletPath() {
        return null;
    }

    public HttpSession getSession(final boolean create) {
        return null;
    }

    public HttpSession getSession() {
        return null;
    }

    public boolean isRequestedSessionIdValid() {
        return false;
    }

    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

}
