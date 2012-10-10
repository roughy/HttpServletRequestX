package httpServletRequestX.accept.header;

import httpServletRequestX.accept.contentType.AcceptContenTypeList;

/**
 * This interface describes all convenience functions useful for an accept header.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public interface AcceptHeader {

    /**
     * Check if client accepts html response content type
     * 
     * @return true if yes
     */
    boolean acceptHtml();

    /**
     * Check if client accepts json response content type
     * 
     * @return true if yes
     */
    boolean acceptJson();

    /**
     * Set the content of the request header and parse it.
     * 
     * @param content to be set
     * @return this
     */
    AcceptHeader setContent(String content);

    /**
     * Returns the content type with the highest priority
     * 
     * @return string representation of the content type
     */
    String getTop();

    /**
     * Return the list of all found content types
     * 
     * @return list of {@see AcceptContenType}
     */
    AcceptContenTypeList getContentTypes();

    /**
     * Check if client accepts given content type
     * 
     * @param type content type to check
     * @return true if yes
     */
    boolean acceptType(String type);

}
