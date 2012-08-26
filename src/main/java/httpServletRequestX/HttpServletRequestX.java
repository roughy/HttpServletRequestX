package httpServletRequestX;

import httpServletRequestX.accept.AcceptHeader;
import httpServletRequestX.accept.AcceptHeaderImpl;
import httpServletRequestX.inject.GuiceModule;

import javax.servlet.http.HttpServletRequest;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * TODO
 * 
 * @author mreinwarth
 */
public abstract class HttpServletRequestX extends LogicHttpServletRequestX {

    private static Injector     injector;
    private static AcceptHeader ACCEPT_HEADER;

    static {
        injector = Guice.createInjector(new GuiceModule());
        ACCEPT_HEADER = injector.getInstance(AcceptHeaderImpl.class);
    }

    /**
     * TODO
     * 
     * @param request
     */
    public HttpServletRequestX(HttpServletRequest request) {
        super(request, ACCEPT_HEADER);
    }

}
