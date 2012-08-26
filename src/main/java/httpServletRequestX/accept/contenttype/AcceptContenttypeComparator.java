package httpServletRequestX.accept.contenttype;

import httpServletRequestX.accept.AcceptContentype;

import java.util.Comparator;

/**
 * @author mreinwarth
 */
public class AcceptContenttypeComparator implements Comparator<AcceptContentype> {

    public int compare(AcceptContentype arg0, AcceptContentype arg1) {
        if (arg0.quality < arg1.quality) {
            return -1;
        }
        if (arg0.quality > arg0.quality) {
            return 1;
        }

        return 0;
    }

}
