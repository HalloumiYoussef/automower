package kata.mower.dto;

import kata.mower.enums.EnumMove;
import java.util.List;


/**
 * Created by YHI on 11/06/2018.
 */
public class Mower {

    private Position currentPosition;
    private List<String> instructions;

    public Mower() {
        //Default
    }

    public Mower(Position currentPosition, List<String> instructions) {
        this.currentPosition = currentPosition;
        this.instructions = instructions;
    }

    public Position applyInstructions(){
        instructions.forEach(i -> this.currentPosition.processInstruction(EnumMove.valueOf(i)));
        return this.currentPosition;
    }
}
