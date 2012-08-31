package httpServletRequestX.accept;

import com.google.inject.Inject;

/**
 * TODO
 */
public class AcceptHeaderImpl implements AcceptHeader {

    private static final String           TYPE_ALL             = "*/*";
    private static final String           TYPE_ALL_TEXT        = "text/*";
    private static final String           TYPE_HTML            = "text/html";
    private static final String           TYPE_ALL_APPLICATION = "application/*";
    private static final String           TYPE_JSON            = "application/json";

    private String                        content;
    private final AcceptContenTypeList    contentTypes;
    private final AcceptContenTypeFactory contentTypeFactory;

    @Inject
    public AcceptHeaderImpl(AcceptContenTypeList contentTypes, AcceptContenTypeFactory contentTypeFactory) {
        this.contentTypes = contentTypes;
        this.contentTypeFactory = contentTypeFactory;
    }

    public AcceptHeader setContent(String content) {
        this.content = content;
        parseContent();
        return this;
    }

    public String getTop() {
        if (!contentTypes.isEmpty()) {
            return contentTypes.get(0).getType();
        }
        return null;
    }

    public AcceptContenTypeList getContentTypes() {
        return contentTypes;
    }

    public boolean acceptType(String type) {
        String[] typeElements = type.split("/");
        if (typeElements.length > 0) {
            return contentTypes.containsType(type) || hasWildcard(typeElements[0]) || hasWildcard();
        } else {
            return contentTypes.containsType(type) || hasWildcard();
        }
    }

    public boolean acceptHtml() {
        return contentTypes.containsType(TYPE_HTML) || hasTextWildcard() || hasWildcard();
    }

    public boolean acceptJson() {
        return contentTypes.containsType(TYPE_JSON) || hasApplicationWildcard() || hasWildcard();
    }

    private boolean hasWildcard() {
        return contentTypes.containsType(TYPE_ALL);
    }

    private boolean hasWildcard(String first) {
        return contentTypes.containsType(first + "/*");
    }

    private boolean hasTextWildcard() {
        return contentTypes.containsType(TYPE_ALL_TEXT);
    }

    private boolean hasApplicationWildcard() {
        return contentTypes.containsType(TYPE_ALL_APPLICATION);
    }

    private void parseContent() {
        this.contentTypes.clear();

        String[] contentTypes = content.split(",");
        for (String contentType : contentTypes) {
            String[] splittedContenttype = contentType.split(";");

            if (!hasParseableContentType(splittedContenttype)) {
                continue;
            }

            if (splittedContenttype.length == 2) {
                Float quality = parseQuality(splittedContenttype[1]);
                this.contentTypes.add(contentTypeFactory.get(splittedContenttype[0], quality));
            } else {
                this.contentTypes.add(contentTypeFactory.get(splittedContenttype[0]));
            }
        }

        java.util.Collections.sort(this.contentTypes);
    }

    private boolean hasParseableContentType(String[] contentTypeElements) {
        if (contentTypeElements == null || contentTypeElements.length == 0) {
            return false;
        }

        for (String contentTypeElement : contentTypeElements) {
            if (contentTypeElement.trim().equals("")) {
                return false;
            }
        }

        return true;
    }

    private Float parseQuality(String input) {
        String[] quality = input.split("=");

        if (quality[0].equals("q")) {
            return Float.valueOf(quality[1]);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AcceptHeader [content=" + content + "]";
    }
}
