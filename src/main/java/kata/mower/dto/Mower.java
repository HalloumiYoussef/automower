package kata.mower.dto;

import kata.mower.enums.EnumMove;
import java.util.List;


/**
 * Created by a613276 on 11/06/2018.
 */
public class Mower {

    private Position currentPosition;
    private List<String> instructions;

    public Mower() {
        //Default
    }

    public Mower(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Mower(Position currentPosition, List<String> instructions) {
        this.currentPosition = currentPosition;
        this.instructions = instructions;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Position applyInstructions(){
        instructions.stream().forEach(i -> this.currentPosition.processInstruction(EnumMove.valueOf(i)));
        return this.currentPosition;
    }
}
