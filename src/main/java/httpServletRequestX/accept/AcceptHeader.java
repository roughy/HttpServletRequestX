package httpServletRequestX.accept;

/**
 * TODO
 */
public interface AcceptHeader {

    boolean acceptHtml();

    boolean acceptJson();

    AcceptHeader setContent(String content);

    String getTop();

    AcceptContenTypeList getContentTypes();

    boolean acceptType(String type);

}
