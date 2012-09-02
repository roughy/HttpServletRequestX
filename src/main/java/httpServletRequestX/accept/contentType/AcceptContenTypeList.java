package httpServletRequestX.accept.contentType;

import httpServletRequestX.accept.contentType.AcceptContenType;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class AcceptContenTypeList extends ArrayList<AcceptContenType> {
    public boolean containsType(String type) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (get(i).hasType(type)) {
                return true;
            }
        }
        return false;
    }
}
