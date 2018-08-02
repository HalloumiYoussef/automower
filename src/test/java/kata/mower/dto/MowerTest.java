package kata.mower.dto;

import kata.mower.enums.EnumOrient;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by YHI on 12/06/2018.
 */
public class MowerTest {

    @Test
    public void applyInstructionsCase1() {
        Position initialPosition =  new Position(1, 2, EnumOrient.N);
        Mower mower = new Mower(initialPosition,
                Arrays.asList("G", "A", "G", "A","G", "A", "G", "A", "A"));
        Position finalPosition = mower.applyInstructions();
        assertEquals(1, finalPosition.getX());
        assertEquals(3, finalPosition.getY());
        assertEquals(EnumOrient.N, finalPosition.getOrientation());
    }

    @Test
    public void applyInstructionsCase2() {
        Position initialPosition =  new Position(3, 3, EnumOrient.E);
        Mower mower = new Mower(initialPosition,
                Arrays.asList("A", "A", "D", "A","A", "D", "A", "D", "D", "A"));
        Position finalPosition = mower.applyInstructions();
        assertEquals(5, finalPosition.getX());
        assertEquals(1, finalPosition.getY());
        assertEquals(EnumOrient.E, finalPosition.getOrientation());
    }

}