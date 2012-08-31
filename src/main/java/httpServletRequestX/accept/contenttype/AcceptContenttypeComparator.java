package httpServletRequestX.accept.contenttype;

import httpServletRequestX.accept.AcceptContenType;

import java.util.Comparator;

/**
 * @author mreinwarth
 */
public class AcceptContenttypeComparator implements Comparator<AcceptContenType> {

    public int compare(AcceptContenType arg0, AcceptContenType arg1) {
        if (arg0.quality < arg1.quality) {
            return -1;
        }
        if (arg0.quality > arg0.quality) {
            return 1;
        }

        return 0;
    }

}
