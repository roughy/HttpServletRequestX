package httpServletRequestX.accept.contentType;

import httpServletRequestX.accept.contentType.AcceptContenType;

/**
 * Unit test case for {@See AcceptContenTypeFactory}
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com
 */
public class AcceptContenTypeFactory {
    public AcceptContenType get(String type) {
        return new AcceptContenType(type);
    }

    public AcceptContenType get(String type, float quality) {
        return new AcceptContenType(type, quality);
    }

    public AcceptContenType get(String type, float quality, int level) {
        return new AcceptContenType(type, quality, level);
    }
}
