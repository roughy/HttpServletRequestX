package httpServletRequestX.accept.header;

import httpServletRequestX.accept.contentType.AcceptContenTypeList;

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
