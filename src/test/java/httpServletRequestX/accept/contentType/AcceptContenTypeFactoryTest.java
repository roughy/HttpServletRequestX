package httpServletRequestX.accept.contentType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@see AcceptContenTypeFactory}
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptContenTypeFactoryTest {

    private AcceptContenTypeFactory acceptContenTypeFactory;

    @Before
    public void setUp() {
        acceptContenTypeFactory = new AcceptContenTypeFactory();
    }

    @Test
    public void testGetWithType() {
        final String contentType = "contenttype/test";
        final float defaultQuality = 1.0f;
        final int defaultLevel = 0;

        final AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType);
        assertEquals(contentType, acceptContentType.type);
        assertTrue(defaultQuality == acceptContentType.quality);
        assertEquals(defaultLevel, acceptContentType.level);
    }

    @Test
    public void testGetWithTypeAndQuality() {
        final String contentType = "contenttype/test";
        final float testQuality = 0.3f;
        final int defaultLevel = 0;

        final AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType, testQuality);
        assertEquals(contentType, acceptContentType.type);
        assertTrue(testQuality == acceptContentType.quality);
        assertEquals(defaultLevel, acceptContentType.level);
    }

    @Test
    public void get() {
        final String contentType = "contenttype/test";
        final float testQuality = 0.3f;
        final int testLevel = 2;

        final AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType, testQuality, testLevel);
        assertEquals(contentType, acceptContentType.type);
        assertTrue(testQuality == acceptContentType.quality);
        assertEquals(testLevel, acceptContentType.level);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithNullType1() {
        acceptContenTypeFactory.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithNullType2() {
        acceptContenTypeFactory.get(null, 1.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithNullType3() {
        acceptContenTypeFactory.get(null, 1.0f, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithEmptyType1() {
        acceptContenTypeFactory.get("  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithEmptyType2() {
        acceptContenTypeFactory.get("  ", 1.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionWithEmptyType3() {
        acceptContenTypeFactory.get("  ", 1.0f, 1);
    }

}
