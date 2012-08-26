package httpServletRequestX.accept;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import httpServletRequestX.accept.contenttype.AcceptContenttypeComparator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AcceptHeaderImplUnitTest {

    @Mock
    private AcceptContenttypeComparator acceptContenttypeComparator;

    private AcceptHeader                acceptHeader;

    @Before
    public void setUp() {
        acceptHeader = new AcceptHeaderImpl(acceptContenttypeComparator);
    }

    @Test
    public void testHasHtml() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("text/html");
        assertTrue(acceptHeader.hasHtml());

        acceptHeader = this.acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.hasHtml());
    }

    @Test
    public void testHasJson() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.hasJson());

        acceptHeader = this.acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.hasJson());
    }

    @Test
    public void testHasTypes() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.hasJson());
        assertFalse(acceptHeader.hasHtml());

        acceptHeader = this.acceptHeader.setContent("text/html,application/json,*/*");
        assertTrue(acceptHeader.hasJson());
        assertTrue(acceptHeader.hasHtml());
    }

    @Test
    public void testHasWildcard() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.hasJson());
        assertFalse(acceptHeader.hasHtml());

        acceptHeader = this.acceptHeader.setContent("*/*");
        assertTrue(acceptHeader.hasJson());
        assertTrue(acceptHeader.hasHtml());
    }

    @Test
    public void testHasTextWildcard() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.hasJson());
        assertFalse(acceptHeader.hasHtml());

        acceptHeader = this.acceptHeader.setContent("text/*");
        assertTrue(acceptHeader.hasHtml());
        assertFalse(acceptHeader.hasJson());

        acceptHeader = this.acceptHeader.setContent("application/json,text/*");
        assertTrue(acceptHeader.hasHtml());
        assertTrue(acceptHeader.hasJson());
    }

    @Test
    public void testHasApplicationWildcard() {
        AcceptHeader acceptHeader;

        acceptHeader = this.acceptHeader.setContent("application/json");
        assertTrue(acceptHeader.hasJson());
        assertFalse(acceptHeader.hasHtml());

        acceptHeader = this.acceptHeader.setContent("application/*");
        assertTrue(acceptHeader.hasJson());
        assertFalse(acceptHeader.hasHtml());
    }
}
