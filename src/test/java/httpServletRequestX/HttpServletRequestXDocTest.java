package httpServletRequestX;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import httpServletRequestX.accept.header.AcceptHeader;

import org.junit.Before;
import org.junit.Test;

import com.devbliss.doctest.DocTest;

public class HttpServletRequestXDocTest extends DocTest {

    private HttpServletRequestX           httpServletRequestX;
    private final HttpServletRequestDummy dummyRequest = new HttpServletRequestDummy();

    @Before
    public void setUp() {
        httpServletRequestX = new HttpServletRequestX(dummyRequest);
    }

    @Test
    public void testDummyRequestPreCondition() throws Exception {
        sayNextSection("How to use");
        say("Incoming request of type HttpServletRequest:");
        sayObject(dummyRequest);

        assertTrue(httpServletRequestX.getAccept() instanceof AcceptHeader);
        assertEquals(dummyRequest.acceptCharset, httpServletRequestX.getAcceptCharset());
        assertEquals(dummyRequest.acceptEncoding, httpServletRequestX.getAcceptEncoding());
        assertEquals(dummyRequest.acceptLanguage, httpServletRequestX.getAcceptLanguage());

        say("How to invoke!");
        sayPreformattedCode("import de.roughy.util.http.httpServletRequestX.HttpServletRequestX;\n  [...]\n"
                + "  public void handleRequest(HttpServletRequest request) {\n"
                + "    HttpServletRequestX httpServletRequestX = new HttpServletRequestX(request);\n"
                + "    AcceptHeader acceptHeader = httpServletRequestX.getAccept();\n" + "    \n" + "    if (acceptHeader.acceptHtml()) {\n"
                + "      renderHtml();\n" + "    } else if (acceptHeader.acceptJson()) {\n" + "      renderJson();\n" + "    }\n" + "  }\n  [...]\n");
    }

    @Test
    public void testGetAcceptCharset() throws Exception {
        sayNextSection("Accept Charset");
        say("Any Accept-Charset-header will be passed unparsed by calling the method getAcceptCharset().");

        sayPreformattedCode("Accept-Charset: " + dummyRequest.acceptCharset);
        assertEqualsAndSay(dummyRequest.acceptCharset, httpServletRequestX.getAcceptCharset());

        dummyRequest.acceptCharset = "any other charset";
        sayPreformattedCode("Accept-Charset: " + dummyRequest.acceptCharset);
        assertEqualsAndSay(dummyRequest.acceptCharset, httpServletRequestX.getAcceptCharset());
    }

    @Test
    public void testGetAcceptEncoding() throws Exception {
        sayNextSection("Accept Encoding");
        say("Any Accept-Encoding-header will be passed unparsed by calling the method getAcceptEncoding().");

        sayPreformattedCode("Accept-Encoding: " + dummyRequest.acceptEncoding);
        assertEqualsAndSay(dummyRequest.acceptEncoding, httpServletRequestX.getAcceptEncoding());

        dummyRequest.acceptEncoding = "any other encoding";
        sayPreformattedCode("Accept-Encoding: " + dummyRequest.acceptEncoding);
        assertEqualsAndSay(dummyRequest.acceptEncoding, httpServletRequestX.getAcceptEncoding());
    }

    @Test
    public void testGetAcceptLanguage() throws Exception {
        sayNextSection("Accept Language");
        say("Any Accept-Language-header will be passed unparsed by calling the method getAcceptLanguage().");

        sayPreformattedCode("Accept-Language: " + dummyRequest.acceptLanguage);
        assertEqualsAndSay(dummyRequest.acceptLanguage, httpServletRequestX.getAcceptLanguage());

        dummyRequest.acceptLanguage = "any other language";
        sayPreformattedCode("Accept-Language: " + dummyRequest.acceptLanguage);
        assertEqualsAndSay(dummyRequest.acceptLanguage, httpServletRequestX.getAcceptLanguage());
    }
}
