package httpServletRequestX;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import httpServletRequestX.accept.header.AcceptHeader;

import org.junit.Before;
import org.junit.Test;

import com.devbliss.doctest.DocTest;

/**
 * Tests and API documentation done within this class.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class HttpServletRequestXDocTest extends DocTest {

    private HttpServletRequestX           httpServletRequestX;
    private final HttpServletRequestDummy dummyRequest = new HttpServletRequestDummy();

    @Override
    protected String getFileName() {
        return "HttpServletRequestX API";
    }

    @Before
    public void setUp() {
        httpServletRequestX = new HttpServletRequestX(dummyRequest);
    }

    @Test
    public void testGetAccept() throws Exception {
        sayNextSection("Accept");

        AcceptHeader accept = httpServletRequestX.getAccept();
        assertEquals("application/json", accept.getTop());
        assertTrue(accept.acceptHtml());
        assertTrue(accept.acceptJson());
        assertTrue(accept.acceptType("application/json"));
    }

    @Test
    public void testGetAcceptCharset() throws Exception {
        sayNextSection("Accept Charset");
        say("Any Accept-Charset-header will be passed unparsed by calling the method getAcceptCharset().");

        say("A request with the following header:");
        sayPreformattedCode("Accept-Charset: " + dummyRequest.acceptCharset);
        assertEqualsAndSay(dummyRequest.acceptCharset, httpServletRequestX.getAcceptCharset(),
                "getAcceptCharset() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptCharset() + "\"");

        dummyRequest.acceptCharset = "any other charset";
        say("Even unconventional header like this:");
        sayPreformattedCode("Accept-Charset: " + dummyRequest.acceptCharset);
        assertEqualsAndSay(dummyRequest.acceptCharset, httpServletRequestX.getAcceptCharset(),
                "getAcceptCharset() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptCharset() + "\"");
    }

    @Test
    public void testGetAcceptEncoding() throws Exception {
        sayNextSection("Accept Encoding");
        say("Any Accept-Encoding-header will be passed unparsed by calling the method getAcceptEncoding().");

        say("A request with the following header:");
        sayPreformattedCode("Accept-Encoding: " + dummyRequest.acceptEncoding);
        assertEqualsAndSay(dummyRequest.acceptEncoding, httpServletRequestX.getAcceptEncoding(),
                "getAcceptEncoding() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptEncoding() + "\"");

        dummyRequest.acceptEncoding = "any other encoding";
        say("Even unconventional header like this:");
        sayPreformattedCode("Accept-Encoding: " + dummyRequest.acceptEncoding);
        assertEqualsAndSay(dummyRequest.acceptEncoding, httpServletRequestX.getAcceptEncoding(),
                "getAcceptEncoding() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptEncoding() + "\"");
    }

    @Test
    public void testGetAcceptLanguage() throws Exception {
        sayNextSection("Accept Language");
        say("Any Accept-Language-header will be passed unparsed by calling the method getAcceptLanguage().");

        say("A request with the following header:");
        sayPreformattedCode("Accept-Language: " + dummyRequest.acceptLanguage);
        assertEqualsAndSay(dummyRequest.acceptLanguage, httpServletRequestX.getAcceptLanguage(),
                "getAcceptLanguage() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptLanguage() + "\"");

        dummyRequest.acceptLanguage = "any other language";
        say("Even unconventional header like this:");
        sayPreformattedCode("Accept-Language: " + dummyRequest.acceptLanguage);
        assertEqualsAndSay(dummyRequest.acceptLanguage, httpServletRequestX.getAcceptLanguage(),
                "getAcceptLanguage() returns the content of header unparsed: \"" + httpServletRequestX.getAcceptLanguage() + "\"");
    }

}
