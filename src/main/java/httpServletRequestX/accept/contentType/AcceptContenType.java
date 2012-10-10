package httpServletRequestX.accept.contentType;

import java.util.Comparator;

/**
 * Accept header content type implementation to the HTTP 1.1 specification. Sorting the priority of all content-types is
 * based on the quality flag. An missing quality flag will be automatically set to the highest priority. TODO: level
 * flag is currently ignored. {@link http://www.http.specification.de/}
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptContenType implements Comparable<AcceptContenType> {
    public final String type;
    public final float  quality;
    public final int    level;

    /**
     * Constructor
     * 
     * @param type the content type
     */
    public AcceptContenType(final String type) {
        this(type, 1.0f, 0);
    }

    /**
     * Constructor
     * 
     * @param type the content type
     * @param quality the quality of the content type
     */
    public AcceptContenType(final String type, final float quality) {
        this(type, quality, 0);
    }

    /**
     * Constructor
     * 
     * @param type the content type
     * @param quality the quality of the content type
     * @param level the level of the content type TODO: currently ignored
     */
    public AcceptContenType(final String type, final float quality, final int level) {
        if (type == null) {
            throw new IllegalArgumentException("Field \"type\" is empty!");
        }

        this.type = type.trim();
        if (this.type.equals("")) {
            throw new IllegalArgumentException("Field \"type\" is empty!");
        }

        this.quality = quality;
        this.level = level;
    }

    /**
     * Returns the content type string.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the content type quality.
     * 
     * @return the quality
     */
    public float getQuality() {
        return quality;
    }

    /**
     * Returns the content type level.
     * 
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Checks if given content type matches.
     * 
     * @return true if given content type matches
     */
    public boolean hasType(final String type) {
        return this.type.equals(type);
    }

    /**
     * Content type {@link Comparator} based on the quality
     * 
     * @return
     */
    public int compareTo(final AcceptContenType other) {
        if (other.quality > quality) {
            return 1;
        }
        if (other.quality < quality) {
            return -1;
        }
        return 0;
    }
}
