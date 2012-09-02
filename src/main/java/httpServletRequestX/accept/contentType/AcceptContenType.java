package httpServletRequestX.accept.contentType;

public class AcceptContenType implements Comparable<AcceptContenType> {
    public final String type;
    public final float  quality;
    public final int    level;

    public AcceptContenType(String type) {
        this(type, 1.0f, 0);
    }

    public AcceptContenType(String type, float quality) {
        this(type, quality, 0);
    }

    public AcceptContenType(String type, float quality, int level) {
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the quality
     */
    public float getQuality() {
        return quality;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    public boolean hasType(String type) {
        return this.type.equals(type);
    }

    public int compareTo(AcceptContenType other) {
        if (other.quality > quality) {
            return 1;
        }
        if (other.quality < quality) {
            return -1;
        }
        return 0;
    }
}