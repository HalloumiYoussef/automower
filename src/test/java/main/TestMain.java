package main;

import kata.mower.config.AppMower;
import kata.mower.dto.Position;

/**
 * Created by a613276 on 12/06/2018.
 */
public class TestMain {

    public static void main(String[] args) {
        AppMower.loadInput();
        AppMower.mowersList.stream().forEach(mower -> displayPosition(mower.applyInstructions()));
    }

    private static void displayPosition(Position position) {
        System.out.println(position.toString());
    }
}
