package httpServletRequestX.accept.contentType;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class AcceptContenTypeList extends ArrayList<AcceptContenType> {
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
