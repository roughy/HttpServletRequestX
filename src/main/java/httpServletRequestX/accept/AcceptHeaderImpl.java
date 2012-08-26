package httpServletRequestX.accept;

import httpServletRequestX.accept.contenttype.AcceptContenttypeComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.inject.Inject;

/**
 * TODO
 * 
 * @author mreinwarth
 */
public class AcceptHeaderImpl implements AcceptHeader {

    private static final String                TYPE_ALL             = "*/*";
    private static final String                TYPE_ALL_TEXT        = "text/*";
    private static final String                TYPE_HTML            = "text/html";
    private static final String                TYPE_TEXT            = "text/plain";
    private static final String                TYPE_ALL_APPLICATION = "application/*";
    private static final String                TYPE_JSON            = "application/json";

    private String                             content;
    private final List<AcceptContentype>       contentTypes         = new ArrayList<AcceptContentype>();
    private final Comparator<AcceptContentype> acceptContenttypeComparator;

    @Inject
    public AcceptHeaderImpl(AcceptContenttypeComparator acceptContenttypeComparator) {
        this.acceptContenttypeComparator = acceptContenttypeComparator;
    }

    public AcceptHeader setContent(String content) {
        this.content = content;
        parseContent();
        return this;
    }

    public boolean hasHtml() {
        return contentTypes.contains(TYPE_HTML) || hasTextWildcard() || hasWildcard();
    }

    public boolean hasJson() {
        return contentTypes.contains(TYPE_JSON) || hasApplicationWildcard() || hasWildcard();
    }

    private boolean hasWildcard() {
        return contentTypes.contains(TYPE_ALL);
    }

    private boolean hasTextWildcard() {
        return contentTypes.contains(TYPE_ALL_TEXT);
    }

    private boolean hasApplicationWildcard() {
        return contentTypes.contains(TYPE_ALL_APPLICATION);
    }

    private void parseContent() {
        String[] contentTypes = content.split(",");
        for (String contentType : contentTypes) {
            String[] splittedContenttype = contentType.split(";");
            if (splittedContenttype.length == 2) {
                Float quality = parseQuality(splittedContenttype[1]);
                this.contentTypes.add(new AcceptContentype(contentType, quality));
            } else {
                this.contentTypes.add(new AcceptContentype(contentType));
            }
        }

        java.util.Collections.sort(this.contentTypes, acceptContenttypeComparator);
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
