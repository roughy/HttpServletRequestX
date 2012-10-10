package httpServletRequestX.accept.contentType;

/**
 * {@see AcceptContenType} factory. Mainly used to be able to mock {@see AcceptContenType} creation for testing
 * purposes.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptContenTypeFactory {

    /**
     * Builds an {@see AcceptContenType} object.
     * 
     * @param type the content type
     * @return created {@see AcceptContenType} object
     */
    public AcceptContenType get(final String type) {
        return new AcceptContenType(type);
    }

    /**
     * Builds an {@see AcceptContenType} object.
     * 
     * @param type the content type
     * @param quality the quality of the content type
     * @return created {@see AcceptContenType} object
     */
    public AcceptContenType get(final String type, final float quality) {
        return new AcceptContenType(type, quality);
    }

    /**
     * Builds an {@see AcceptContenType} object.
     * 
     * @param type the content type
     * @param quality the quality of the content type
     * @param level the level of the content type TODO: currently ignored
     * @return created {@see AcceptContenType} object
     */
    public AcceptContenType get(final String type, final float quality, final int level) {
        return new AcceptContenType(type, quality, level);
    }

}
