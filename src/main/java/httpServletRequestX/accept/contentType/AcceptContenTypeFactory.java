package httpServletRequestX.accept.contentType;

/**
 * Unit test case for {@See AcceptContenTypeFactory}
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com
 */
public class AcceptContenTypeFactory {
    public AcceptContenType get(final String type) {
        return new AcceptContenType(type);
    }

    public AcceptContenType get(final String type, final float quality) {
        return new AcceptContenType(type, quality);
    }

    public AcceptContenType get(final String type, final float quality, final int level) {
        return new AcceptContenType(type, quality, level);
    }
}
