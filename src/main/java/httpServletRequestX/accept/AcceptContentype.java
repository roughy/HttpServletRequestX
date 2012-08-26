package httpServletRequestX.accept;

public class AcceptContentype {
    public final String name;
    public final Float  quality;
    public final int    level;

    public AcceptContentype(String name) {
        this(name, null, 0);
    }

    public AcceptContentype(String name, Float quality) {
        this(name, quality, 0);
    }

    public AcceptContentype(String name, Float quality, int level) {
        this.name = name.trim();
        this.quality = quality != null ? quality : 1.0f;
        this.level = level;
    }
}
