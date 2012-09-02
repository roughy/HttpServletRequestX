package httpServletRequestX.accept;

public class AcceptContenTypeFactory {
    public AcceptContenType get(String type) {
        return new AcceptContenType(type);
    }

    public AcceptContenType get(String type, Float quality) {
        return new AcceptContenType(type, quality);
    }

    public AcceptContenType get(String type, Float quality, int level) {
        return new AcceptContenType(type, quality, level);
    }
}
