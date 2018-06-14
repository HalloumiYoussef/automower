package kata.mower.util;

import kata.mower.enums.EnumOrient;

/**
 * Created by YHI on 11/06/2018.
 */
public class EnumOrientUtil {

    public static EnumOrient turnToRight(EnumOrient o){
        return EnumOrient.values()[(o.ordinal()+1)%4];
    }

    public static EnumOrient turnToLeft(EnumOrient o){
        return EnumOrient.values()[(o.ordinal()+3)%4];
    }

    public static boolean isValidOrientation(String i) {
        for (EnumOrient eo : EnumOrient.values()) {
            if (eo.name().equals(i)) {
                return true;
            }
        }
        return false;
    }
}
