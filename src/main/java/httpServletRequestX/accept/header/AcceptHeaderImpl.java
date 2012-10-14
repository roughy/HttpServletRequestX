package httpServletRequestX.accept.header;

import httpServletRequestX.accept.contentType.AcceptContenTypeFactory;
import httpServletRequestX.accept.contentType.AcceptContenTypeList;

import com.google.inject.Inject;

/**
 * Bunch of convenience functions useful for an accept header.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptHeaderImpl implements AcceptHeader {

    private static final String           TYPE_ALL             = "*/*";
    private static final String           TYPE_ALL_TEXT        = "text/*";
    private static final String           TYPE_HTML            = "text/html";
    private static final String           TYPE_ALL_APPLICATION = "application/*";
    private static final String           TYPE_JSON            = "application/json";

    private String                        content;
    private final AcceptContenTypeList    contentTypeList;
    private final AcceptContenTypeFactory contentTypeFactory;

    @Inject
    public AcceptHeaderImpl(final AcceptContenTypeList contentTypeList, final AcceptContenTypeFactory contentTypeFactory) {
        this.contentTypeList = contentTypeList;
        this.contentTypeFactory = contentTypeFactory;
    }

    public AcceptHeader setContent(final String content) {
        this.content = content;
        parseContent();
        return this;
    }

    public String getTop() {
        if (!contentTypeList.isEmpty()) {
            return contentTypeList.get(0).getType();
        }
        return null;
    }

    public AcceptContenTypeList getContentTypes() {
        return contentTypeList;
    }

    public boolean acceptType(final String type) {
        final String[] typeElements = type.split("/");
        if (typeElements.length > 0) {
            return contentTypeList.containsType(type) || hasWildcard(typeElements[0]) || hasWildcard();
        } else {
            return contentTypeList.containsType(type) || hasWildcard();
        }
    }

    public boolean acceptHtml() {
        return contentTypeList.containsType(TYPE_HTML) || hasTextWildcard() || hasWildcard();
    }

    public boolean acceptJson() {
        return contentTypeList.containsType(TYPE_JSON) || hasApplicationWildcard() || hasWildcard();
    }

    private boolean hasWildcard() {
        return contentTypeList.containsType(TYPE_ALL);
    }

    private boolean hasWildcard(final String first) {
        return contentTypeList.containsType(first + "/*");
    }

    private boolean hasTextWildcard() {
        return contentTypeList.containsType(TYPE_ALL_TEXT);
    }

    private boolean hasApplicationWildcard() {
        return contentTypeList.containsType(TYPE_ALL_APPLICATION);
    }

    private void parseContent() {
        contentTypeList.clear();

        final String[] contentTypes = content.split(",");
        for (final String contentType : contentTypes) {
            final String[] splittedContenttype = contentType.split(";");

            if (!hasParseableContentType(splittedContenttype)) {
                continue;
            }

            if (splittedContenttype.length == 2) {
                final Float quality = parseQuality(splittedContenttype[1]);
                contentTypeList.add(contentTypeFactory.get(splittedContenttype[0], quality));
            } else {
                contentTypeList.add(contentTypeFactory.get(splittedContenttype[0]));
            }
        }

        java.util.Collections.sort(contentTypeList);
    }

    private boolean hasParseableContentType(final String[] contentTypeElements) {
        if (contentTypeElements == null || contentTypeElements.length == 0) {
            return false;
        }

        for (final String contentTypeElement : contentTypeElements) {
            if (contentTypeElement.trim().equals("")) {
                return false;
            }
        }

        return true;
    }

    private Float parseQuality(final String input) {
        final String[] quality = input.split("=");

        if (quality[0].equals("q")) {
            return Float.valueOf(quality[1]);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @link java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AcceptHeader [content=" + content + "]";
    }
}
