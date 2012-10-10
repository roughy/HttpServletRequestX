package httpServletRequestX.accept.contentType;

import java.util.ArrayList;

/**
 * A {@link ArrayList} of {@see AcceptContenType}.
 * 
 * @author Marco Reinwarth <marcoreinwarth@gmail.com>
 */
public class AcceptContenTypeList extends ArrayList<AcceptContenType> {

    private static final long serialVersionUID = 5652253670607827546L;

    /**
     * Checks if given content type matches one item in list.
     * 
     * @param type the content type to look for
     * @return true if given content type matches
     */
    public boolean containsType(final String type) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            if (get(i).hasType(type)) {
                return true;
            }
        }
        return false;
    }

}
