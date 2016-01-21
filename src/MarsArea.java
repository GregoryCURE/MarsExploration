
/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */

import java.util.*;

// This class can be considered as facultative but brings some abstraction
// for possible evolutions of the codeline

public abstract class MarsArea {
   
    public static ArrayList<Character> cardinalPoints = new ArrayList<>(Arrays.asList('N','E','S','W'));
    
    public abstract boolean isPositionValid(Position currentPosition);
    public abstract void computeNewPosition(Position currentPosition, char direction);   
}
