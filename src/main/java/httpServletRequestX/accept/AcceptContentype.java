package httpServletRequestX.accept;

public class AcceptContenType implements Comparable<AcceptContenType> {
    public final String type;
    public final Float  quality;
    public final int    level;

    public AcceptContenType(String type) {
        this(type, null, 0);
    }

    public AcceptContenType(String type, Float quality) {
        this(type, quality, 0);
    }

    public AcceptContenType(String type, Float quality, int level) {
        this.type = type.trim();
        this.quality = quality != null ? quality : 1.0f;
        this.level = level;
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
