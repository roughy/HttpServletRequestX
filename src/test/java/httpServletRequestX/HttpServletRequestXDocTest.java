package httpServletRequestX;

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
    public void testGetAcceptGetTop() throws Exception {
        sayNextSection("Accept - getTop()");
        say("A accept header will be parsed when using HttpServletRequestX library. The created object of type AcceptHeader gives you the "
                + "convenience function \"getTop()\" that returns the accept content type with the highest quality value. If more than one "
                + "content type have the highest quality value, than the first one will be returned.");

        say("A request with the following header:");
        sayPreformattedCode("Accept: " + dummyRequest.accept);

        AcceptHeader accept = httpServletRequestX.getAccept();
        assertEqualsAndSay(dummyRequest.getTop(), accept.getTop(), "getTop() returns the content type : \"" + accept.getTop() + "\"");
    }

    @Test
    public void testGetAcceptHtml() throws Exception {
        sayNextSection("Accept - acceptHtml()");
        say("The object of type AcceptHeader gives you also the convenience function \"acceptHtml()\" that validates if the client accepts "
                + "the content type \"text/html\".");

        say("A request with the following header:");
        sayPreformattedCode("Accept: " + dummyRequest.accept);

        AcceptHeader accept = httpServletRequestX.getAccept();
        assertTrueAndSay(accept.acceptHtml(), "The response of acceptHtml() is " + accept.acceptHtml() + " in this case.");
    }

    @Test
    public void testGetAcceptJson() throws Exception {
        sayNextSection("Accept - acceptJson()");
        say("The object of type AcceptHeader gives you also the convenience function \"acceptJson()\" that validates if the client accepts "
                + "the content type \"application/json\".");

        say("A request with the following header:");
        sayPreformattedCode("Accept: " + dummyRequest.accept);

        AcceptHeader accept = httpServletRequestX.getAccept();
        assertTrueAndSay(accept.acceptJson(), "The response of acceptJson() is " + accept.acceptJson() + " in this case.");

        assertTrue(accept.acceptType("application/json"));
    }

    @Test
    public void testGetAcceptType() throws Exception {
        sayNextSection("Accept - acceptType()");
        say("The object of type AcceptHeader gives you also the convenience function \"acceptType(String contentType)\" that validates if the client "
                + "accepts the given content type.");

        say("A request with the following header:");
        sayPreformattedCode("Accept: " + dummyRequest.accept);

        AcceptHeader accept = httpServletRequestX.getAccept();
        assertTrueAndSay(accept.acceptType("application/json"),
                "The response of acceptType(\"application/json\") is " + accept.acceptType("application/json") + " in this case.");
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
