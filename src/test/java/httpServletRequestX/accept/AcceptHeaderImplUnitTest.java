package httpServletRequestX.accept;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AcceptHeaderImplUnitTest {

    private AcceptHeader acceptHeader;

    @Before
    public void setUp() {
        acceptHeader = new AcceptHeaderImpl(new AcceptContenTypeList(), new AcceptContenTypeFactory());
    }

    @Test
    public void testHasHtml() {
        acceptHeader.setContent("text/html");
        assertTrue(acceptHeader.acceptHtml());

        acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.acceptHtml());
    }

    @Test
    public void testHasJson() {
        acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.acceptJson());

        acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.acceptJson());
    }

    @Test
    public void testHasTypes() {
        acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.acceptJson());
        assertFalse(acceptHeader.acceptHtml());

        acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.acceptJson());
        assertTrue(acceptHeader.acceptHtml());
    }

    @Test
    public void testHasWildcard() {
        acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.acceptJson());
        assertFalse(acceptHeader.acceptHtml());

        acceptHeader.setContent("*/*");
        assertTrue(acceptHeader.acceptJson());
        assertTrue(acceptHeader.acceptHtml());
    }

    @Test
    public void testHasTextWildcard() {
        acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.acceptJson());
        assertFalse(acceptHeader.acceptHtml());

        acceptHeader.setContent("text/*");
        assertTrue(acceptHeader.acceptHtml());
        assertFalse(acceptHeader.acceptJson());

        acceptHeader.setContent("text/*,application/json;q=1.0");
        assertTrue(acceptHeader.acceptHtml());
        assertTrue(acceptHeader.acceptJson());
    }

    @Test
    public void testHasApplicationWildcard() {
        acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.acceptJson());
        assertFalse(acceptHeader.acceptHtml());

        acceptHeader.setContent("application/*");
        assertTrue(acceptHeader.acceptJson());
        assertFalse(acceptHeader.acceptHtml());
    }

    @Test
    public void testQualitySortingWithGetTop() {
        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,application/json");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("application/json;q=1.0,text/*;q=1.0,text/html;q=0.7");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("application/json,text/*;q=1.0,text/html;q=0.7");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("text/*;q=0.7,text/html;q=0.7,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("text/*;q=0.7,text/html;q=0.7,application/json;q=1");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent("text/*;q=0.7,text/html;q=0.7,application/json;q=.9");
        assertEquals("application/json", acceptHeader.getTop());
    }

    @Test
    public void testQualitySortingWithWrongSyntax() {
        acceptHeader.setContent(",text/*;q=0.3,text/html;q=0.7,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent(",text/*;q=0.3,text/html;q=0.7,,,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent(",text/*;q=0.3,text/html;q=0.7,;,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent(";text/*;q=0.3,text/html;q=0.7,;,application/json;q=1.0");
        assertEquals("application/json", acceptHeader.getTop());

        acceptHeader.setContent(";text/*;q=0.3,text/html;q=0.7,;,application/json;");
        assertEquals("application/json", acceptHeader.getTop());
    }

    @Test
    public void testTheUnknown() {
        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,roughy/foobar;q=1,application/json;q=1.0");
        assertTrue(acceptHeader.acceptType("roughy/foobar"));

        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,roughy/foobar;q=1,application/json;q=1.0");
        assertEquals("roughy/foobar", acceptHeader.getTop());

        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,*/*,application/json;q=1.0");
        assertTrue(acceptHeader.acceptType("roughy/foobar"));

        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,roughy/*;q=1,application/json;q=1.0");
        assertTrue(acceptHeader.acceptType("roughy/foobar"));
    }

    @Test
    public void testTheUnknownWithWrongSyntax() {
        acceptHeader.setContent("text/*;q=0.3,text/html;q=0.7,roughy/*;q=1,application/json;q=1.0");
        assertTrue(acceptHeader.acceptType("roughy/"));
        assertFalse(acceptHeader.acceptType("/"));
        assertFalse(acceptHeader.acceptType("/foobar"));
    }
}
