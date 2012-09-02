package httpServletRequestX.accept.contentType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AcceptContenTypeFactoryTest {

    private AcceptContenTypeFactory acceptContenTypeFactory;

    @Before
    public void setUp() {
        acceptContenTypeFactory = new AcceptContenTypeFactory();
    }

    @Test
    public void testGetWithType() {
        String contentType = "contenttype/test";
        float defaultQuality = 1.0f;
        int defaultLevel = 0;

        AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType);
        assertEquals(contentType, acceptContentType.type);
        assertTrue(defaultQuality == acceptContentType.quality);
        assertEquals(defaultLevel, acceptContentType.level);
    }

    @Test
    public void testGetWithTypeAndQuality() {
        String contentType = "contenttype/test";
        float testQuality = 0.3f;
        int defaultLevel = 0;

        AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType, testQuality);
        assertEquals(contentType, acceptContentType.type);
        assertTrue(testQuality == acceptContentType.quality);
        assertEquals(defaultLevel, acceptContentType.level);
    }

    @Test
    public void get() {
        String contentType = "contenttype/test";
        float testQuality = 0.3f;
        int testLevel = 2;

        AcceptContenType acceptContentType = acceptContenTypeFactory.get(contentType, testQuality, testLevel);
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
