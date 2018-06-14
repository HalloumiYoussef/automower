package kata.mower.config;

import kata.mower.dto.Mower;
import kata.mower.dto.Position;
import kata.mower.enums.EnumMove;
import kata.mower.enums.EnumOrient;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static kata.mower.util.EnumOrientUtil.isValidOrientation;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * Created by YHI on 12/06/2018.
 */
public class AppMower {

    public static final String SEPARATOR_COORDINATE = " ";
    public static final String MOWER_ORIENTATION_IS_INVALID = "Mower Orientation is invalid: ";
    public static final String MOWER_COORDINATE_X_IS_INVALID = "Mower Coordinate X is invalid: ";
    public static final String MOWER_COORDINATE_Y_IS_INVALID = "Mower Coordinate Y is invalid: ";
    public static final String INPUT_FILE = "input.txt";
    public static final String FILE_NOT_FOUND = "File not found: ";
    public static final String MOWERS_DATA_ARE_INVALID = "Mowers data are invalid: a line is missing !";
    public static final String UPPER_RIGHT_DATA_INVALID = "Upper Right data are invalid";
    public static int upperRightX = 5;
    public static int upperRightY = 5;
    public static List<Mower> mowersList = new ArrayList<>();

    public static void loadInput() {
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(INPUT_FILE);
        if(isNull(inputStream)){
            throw new IllegalArgumentException(FILE_NOT_FOUND+INPUT_FILE);
        }
        final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputStream));
        final String upperRightLine = bufferedreader.lines().findFirst().get();
        setUpperRightData(upperRightLine);
        final List<String> mowersLines = bufferedreader.lines().collect(toList());
        mowersList = constructMowersList(mowersLines);
    }

    public static List<String> prepareInstructionsList(String instructions) {
        return instructions.chars()
                        .mapToObj(c -> Character.toString((char)c))
                        .filter(i -> isValidInstruction(i))
                        .collect(Collectors.toList());
    }

    public static boolean isValidInstruction(String i) {
        for (EnumMove em : EnumMove.values()) {
            if (em.name().equals(i)) {
                return true;
            }
        }
        return false;
    }

    private static void setUpperRightData(String upperRightLine) {
        int[] intArray = getUpperRightAsIntArray(upperRightLine);
        AppMower.upperRightX = intArray[0];
        AppMower.upperRightY = intArray[1];
    }

    private static int[] getUpperRightAsIntArray(String upperRightLine) {
        String[] items = StringUtils.split(upperRightLine, SEPARATOR_COORDINATE);
        if(items.length != 2){
            throw new IllegalArgumentException(UPPER_RIGHT_DATA_INVALID);
        }
        return parseLineToIntArray(items);
    }

    private static int[] parseLineToIntArray(String[] items) {
        int[] intItems = new int[2];
        intItems[0] = parseItem(items, 0);
        intItems[1] = parseItem(items, 1);
        return intItems;
    }

    private static int parseItem(String[] items, int i) {
        if(isNumeric(items[i])){
            return Integer.parseInt(items[i]);
        }else {
            throw new IllegalArgumentException(UPPER_RIGHT_DATA_INVALID);
        }
    }

    private static List<Mower> constructMowersList(List<String> mowersLines) {
        validateLinesCount(mowersLines);
        final List<Mower> mowersList = new ArrayList<>();
        for (int i = 0; i<mowersLines.size(); i++){
            final Position position = preparePosition(mowersLines.get(i));
            mowersList.add(new Mower(position, prepareInstructionsList(mowersLines.get(++i))));
        }
        return mowersList;
    }

    private static void validateLinesCount(List<String> mowersLines) {
        if(0 != mowersLines.size()%2){
            throw new IllegalArgumentException(MOWERS_DATA_ARE_INVALID);
        }
    }

    private static Position preparePosition(String coordinatesLine) {
        final String[] coordinates = split(coordinatesLine, SEPARATOR_COORDINATE);
        int coordinateX = getValidX(coordinates[0]);
        int coordinateY = getValidY(coordinates[1]);
        EnumOrient orientation = getValidOrientation(coordinates[2]);
        return new Position(coordinateX, coordinateY, orientation);
    }

    private static EnumOrient getValidOrientation(String orientation) {
        if(isValidOrientation(orientation)){
            return EnumOrient.valueOf(orientation);
        }else{
            throw new IllegalArgumentException(MOWER_ORIENTATION_IS_INVALID +orientation);
        }
    }

    private static int getValidX(String coordinateX) {
        if(!isNumeric(coordinateX) || parseInt(coordinateX)> AppMower.upperRightX || parseInt(coordinateX)<0){
            throw new IllegalArgumentException(MOWER_COORDINATE_X_IS_INVALID+coordinateX);
        }
        return parseInt(coordinateX);
    }

    private static int getValidY(String coordinateY) {
        if(!isNumeric(coordinateY) || parseInt(coordinateY)> AppMower.upperRightY || parseInt(coordinateY)<0){
            throw new IllegalArgumentException(MOWER_COORDINATE_Y_IS_INVALID+coordinateY);
        }
        return parseInt(coordinateY);
    }

}
