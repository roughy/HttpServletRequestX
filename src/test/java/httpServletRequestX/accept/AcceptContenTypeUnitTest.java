package httpServletRequestX.accept;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AcceptContenTypeUnitTest {

    private static final String TYPE    = "unittest/testtype";
    private static final float  QUALITY = 0.3f;
    private static final int    LEVEL   = 3;

    private AcceptContenType    acceptContentType;

    @Before
    public void setUp() {
        acceptContentType = new AcceptContenType(TYPE, QUALITY, LEVEL);
    }

    @Test
    public void testGetType() {
        assertEquals(TYPE, acceptContentType.getType());
        assertEquals(TYPE, acceptContentType.type);
    }

    @Test
    public void testGetQuality() {
        assertTrue(QUALITY == acceptContentType.getQuality());
        assertTrue(QUALITY == acceptContentType.quality);
    }

    @Test
    public void testGetLevel() {
        assertEquals(LEVEL, acceptContentType.getLevel());
        assertEquals(LEVEL, acceptContentType.level);
    }

    @Test
    public void hasType() {
        String nonType = "nonExitingType";

        assertTrue(acceptContentType.hasType(TYPE));
        assertFalse(acceptContentType.hasType(nonType));
    }

    @Test
    public void testCompareTo() {
        AcceptContenType compareableContentType;

        compareableContentType = new AcceptContenType(TYPE, 1.0f);
        assertEquals(1, acceptContentType.compareTo(compareableContentType));

        compareableContentType = new AcceptContenType(TYPE, 0.1f);
        assertEquals(-1, acceptContentType.compareTo(compareableContentType));

        compareableContentType = new AcceptContenType(TYPE, QUALITY);
        assertEquals(0, acceptContentType.compareTo(compareableContentType));
    }
}
