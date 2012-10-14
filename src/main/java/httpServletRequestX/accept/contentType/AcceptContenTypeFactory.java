package httpServletRequestX.accept.contentType;

/**
 * {@link AcceptContenType} factory. Mainly used to be able to mock {@link AcceptContenType} creation for testing
 * purposes.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptContenTypeFactory {

    /**
     * Builds an {@link AcceptContenType} object.
     * 
     * @param type the content type
     * @return created {@link AcceptContenType} object
     */
    public AcceptContenType get(final String type) {
        return new AcceptContenType(type);
    }

    /**
     * Builds an {@link AcceptContenType} object.
     * 
     * @param type the content type
     * @param quality the quality of the content type
     * @return created {@link AcceptContenType} object
     */
    public AcceptContenType get(final String type, final float quality) {
        return new AcceptContenType(type, quality);
    }

    /**
     * Builds an {@link AcceptContenType} object.
     * 
     * @param type the content type
     * @param quality the quality of the content type
     * @param level the level of the content type TODO: currently ignored
     * @return created {@link AcceptContenType} object
     */
    public AcceptContenType get(final String type, final float quality, final int level) {
        return new AcceptContenType(type, quality, level);
    }

}
