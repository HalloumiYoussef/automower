package kata.mower.dto;

import kata.mower.config.AppMower;
import kata.mower.enums.EnumMove;
import kata.mower.enums.EnumOrient;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YHI on 12/06/2018.
 */
public class PositionTest {

    @Test
    public void processInstructionAOnBottomLeftWithOrientN() {
        Position position = new Position(0,0, EnumOrient.N);
        position.processInstruction(EnumMove.A);
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(EnumOrient.N, position.getOrientation());
    }

    @Test
    public void processInstructionAOnBottomLeftWithOrientW() {
        Position position = new Position(0,0, EnumOrient.W);
        position.processInstruction(EnumMove.A);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(EnumOrient.W, position.getOrientation());
    }

    @Test
    public void processInstructionAOnBottomLeftWithOrientS() {
        Position position = new Position(0,0, EnumOrient.S);
        position.processInstruction(EnumMove.A);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(EnumOrient.S, position.getOrientation());
    }

    @Test
    public void processInstructionAOnUpperRightWithOrientN() {
        Position position = new Position(AppMower.upperRightX, AppMower.upperRightY, EnumOrient.N);
        position.processInstruction(EnumMove.A);
        assertEquals(AppMower.upperRightX, position.getX());
        assertEquals(AppMower.upperRightY, position.getY());
        assertEquals(EnumOrient.N, position.getOrientation());
    }

    @Test
    public void processInstructionAOnUpperRightWithOrientE() {
        Position position = new Position(AppMower.upperRightX, AppMower.upperRightY, EnumOrient.E);
        position.processInstruction(EnumMove.A);
        assertEquals(AppMower.upperRightX, position.getX());
        assertEquals(AppMower.upperRightY, position.getY());
        assertEquals(EnumOrient.E, position.getOrientation());
    }

    @Test
    public void processInstructionAOnUpperRightWithOrientW() {
        Position position = new Position(AppMower.upperRightX, AppMower.upperRightY, EnumOrient.W);
        position.processInstruction(EnumMove.A);
        assertEquals(AppMower.upperRightX-1, position.getX());
        assertEquals(AppMower.upperRightY, position.getY());
        assertEquals(EnumOrient.W, position.getOrientation());
    }

    @Test
    public void processMultipleInstructions() {
        Position position = new Position(0, 1, EnumOrient.N);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.D);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.G);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.A);
        position.processInstruction(EnumMove.D);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
        assertEquals(EnumOrient.E, position.getOrientation());
    }

    @Test
    public void processInstructionTurnLeft() {
        Position position = new Position(AppMower.upperRightX, AppMower.upperRightY, EnumOrient.W);
        position.processInstruction(EnumMove.G);
        assertEquals(AppMower.upperRightX, position.getX());
        assertEquals(AppMower.upperRightY, position.getY());
        assertEquals(EnumOrient.S, position.getOrientation());
    }

    @Test
    public void processInstructionTurnRight() {
        Position position = new Position(AppMower.upperRightX, AppMower.upperRightY, EnumOrient.W);
        position.processInstruction(EnumMove.D);
        assertEquals(AppMower.upperRightX, position.getX());
        assertEquals(AppMower.upperRightY, position.getY());
        assertEquals(EnumOrient.N, position.getOrientation());
    }
}