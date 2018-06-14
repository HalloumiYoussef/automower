package kata.mower.dto;

import kata.mower.config.AppMower;
import kata.mower.enums.EnumMove;
import kata.mower.enums.EnumOrient;
import kata.mower.util.EnumOrientUtil;

/**
 * Created by YHI on 11/06/2018.
 */
public class Position {

    private int x;
    private int y;
    private EnumOrient orientation;

    public Position() {
        //Default
    }

    public Position(int x, int y, EnumOrient orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public EnumOrient getOrientation() {
        return orientation;
    }

    public void setOrientation(EnumOrient orientation) {
        this.orientation = orientation;
    }

    public void processInstruction(EnumMove move) {
        if(EnumMove.A.equals(move)){
            moveForward();
        }

        if(EnumMove.D.equals(move)){
            this.orientation = EnumOrientUtil.turnToRight(this.orientation);
        }

        if(EnumMove.G.equals(move)){
            this.orientation = EnumOrientUtil.turnToLeft(this.orientation);
        }

    }

    private void moveForward() {
        if(EnumOrient.N.equals(this.orientation)){
            incrementY();

        }else if(EnumOrient.S.equals(this.orientation)){
            decrementY();

        }else if(EnumOrient.E.equals(this.orientation)){
            incrementX();

        }else if(EnumOrient.W.equals(this.orientation)){
            decrementX();
        }
    }

    private void incrementY() {
        if(y < AppMower.upperRightY) {
            this.y++;
        }
    }

    private void decrementY() {
        if(y > 0) {
            this.y--;
        }
    }

    private void decrementX() {
        if(x > 0) {
            this.x--;
        }
    }

    private void incrementX() {
        if(x < AppMower.upperRightX) {
            this.x++;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(x);
        sb.append(" ").append(y);
        sb.append(" ").append(orientation);
        return sb.toString();
    }
}
