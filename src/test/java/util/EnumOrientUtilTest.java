package util;

import kata.mower.enums.EnumOrient;
import kata.mower.util.EnumOrientUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by YHI on 12/06/2018.
 */
public class EnumOrientUtilTest {

    @Test
    public void turnToRightFromN() {
        assertEquals(EnumOrient.E, EnumOrientUtil.turnToRight(EnumOrient.N));
    }

    @Test
    public void turnToRightFromE() {
        assertEquals(EnumOrient.S, EnumOrientUtil.turnToRight(EnumOrient.E));
    }

    @Test
    public void turnToRightFromS() {
        assertEquals(EnumOrient.W, EnumOrientUtil.turnToRight(EnumOrient.S));
    }

    @Test
    public void turnToRightFromW() {
        assertEquals(EnumOrient.N, EnumOrientUtil.turnToRight(EnumOrient.W));
    }

    @Test
    public void turnToLeftFromN() {
        assertEquals(EnumOrient.W, EnumOrientUtil.turnToLeft(EnumOrient.N));
    }

    @Test
    public void turnToLeftFromW() {
        assertEquals(EnumOrient.S, EnumOrientUtil.turnToLeft(EnumOrient.W));
    }

    @Test
    public void turnToLeftFromS() {
        assertEquals(EnumOrient.E, EnumOrientUtil.turnToLeft(EnumOrient.S));
    }

    @Test
    public void turnToLeftFromE() {
        assertEquals(EnumOrient.N, EnumOrientUtil.turnToLeft(EnumOrient.E));
    }

}