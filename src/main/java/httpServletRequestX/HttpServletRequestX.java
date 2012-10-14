package httpServletRequestX;

import httpServletRequestX.accept.header.AcceptHeader;
import httpServletRequestX.accept.header.AcceptHeaderImpl;
import httpServletRequestX.inject.GuiceModule;

import javax.servlet.http.HttpServletRequest;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This library wraps the {@link HttpServletRequest} and provides a set of convenience functions to handle the accept
 * content type options.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class HttpServletRequestX extends HttpServletRequestXWrapper {

    private static Injector     injector;
    private static AcceptHeader ACCEPT_HEADER;

    /**
     * Guice injection preparations
     */
    static {
        injector = Guice.createInjector(new GuiceModule());
        ACCEPT_HEADER = injector.getInstance(AcceptHeaderImpl.class);
    }

    /**
     * Base constructor that consumes the {@link HttpServletRequest} object
     * 
     * @param request the {@link HttpServletRequest} object that has to be wrapped
     */
    public HttpServletRequestX(final HttpServletRequest request) {
        super(request, ACCEPT_HEADER);
    }

}
