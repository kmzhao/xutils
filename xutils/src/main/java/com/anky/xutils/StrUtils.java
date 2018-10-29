package com.anky.xutils;

import java.util.Collection;

/**
 * @author: Anky
 * @time: 2018
 * @desc:
 */

public class StrUtils {
    private StrUtils() {
        throw new UnsupportedOperationException("sorry,can't init");
    }

    public static boolean NULL(Object obj) {
        // || typeof (obj) == "undefined"
        if (obj == null ||  "".equals(obj) || "null".equals(obj)) {
            return true;
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).size() <= 0)
                return true;
        }
        return false;
    }

    public static boolean NOTNULL(Object obj) {

        if (obj == null || "".equals(obj) || "null".equals(obj)) {
            return false;
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).size() <= 0)
                return false;
        }
        return true;
    }


}
