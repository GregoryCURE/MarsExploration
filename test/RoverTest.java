
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */
public class RoverTest {
    
    public RoverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPosition method, of class Rover.
     */
    @org.junit.Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Rover instance = new Rover();
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class Rover.
     */
    @org.junit.Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = new TwoDimensionsPosition(1,1);
        Rover instance = new Rover();
        instance.setPosition(position);
        assertEquals(instance.getPosition(), position);
    }

    /**
     * Test of getDirection method, of class Rover.
     */
    @org.junit.Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Rover instance = new Rover();
        char expResult = 'N';
        char result = instance.getDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDirection method, of class Rover.
     */
    @org.junit.Test
    public void testSetDirection() {
        System.out.println("setDirection");
        char direction = 'S';
        Rover instance = new Rover();
        instance.setDirection(direction);
        assertEquals(instance.getDirection(), direction);
    }

    /**
     * Test of getInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testGetInstructions() {
        System.out.println("getInstructions");
        Rover instance = new Rover();
        String expResult = "";
        String result = instance.getInstructions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testSetInstructions() {
        System.out.println("setInstructions");
        String instructions = "LLRR";
        Rover instance = new Rover();
        instance.setInstructions(instructions);
        assertEquals(instance.getInstructions(), instructions);
    }

    /**
     * Test of getMarsArea method, of class Rover.
     */
    @org.junit.Test
    public void testGetMarsArea() {
        System.out.println("getMarsArea");
        Rover instance = new Rover();
        MarsArea expResult = null;
        MarsArea result = instance.getMarsArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMarsArea method, of class Rover.
     */
    @org.junit.Test
    public void testSetMarsArea() {
        System.out.println("setMarsArea");
        MarsArea map = new RectangularArea(1,1);
        Rover instance = new Rover();
        instance.setMarsArea(map);
        assertEquals(instance.getMarsArea(), map);
    }

    /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase0() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('E');
        instance.setInstructions("RR");
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'E');
    }
    
     /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase1() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('E');
        instance.setInstructions("RR");
        instance.setPosition(new TwoDimensionsPosition(0,0));
        instance.setMarsArea(new RectangularArea(2,2));
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'W');
    }
    
     /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase2() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('N');
        instance.setInstructions("LMLMLMLMM");
        instance.setPosition(new TwoDimensionsPosition(1,2));
        instance.setMarsArea(new RectangularArea(5,5));
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'N');
        TwoDimensionsPosition finalPosition = (TwoDimensionsPosition) instance.getPosition();
        assertEquals(1, finalPosition.getX());
        assertEquals(3, finalPosition.getY());
    }
    
     /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase3() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('E');
        instance.setInstructions("MMRMMRMRRM");
        instance.setPosition(new TwoDimensionsPosition(3,3));
        instance.setMarsArea(new RectangularArea(5,5));
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'E');
        TwoDimensionsPosition finalPosition = (TwoDimensionsPosition) instance.getPosition();
        assertEquals(5, finalPosition.getX());
        assertEquals(1, finalPosition.getY());
    }
    
     /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase4() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('E');
        instance.setInstructions("MMRMMRMRRM");
        instance.setPosition(new TwoDimensionsPosition(3,3));
        instance.setMarsArea(new RectangularArea(3,3));
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'E');
        TwoDimensionsPosition finalPosition = (TwoDimensionsPosition) instance.getPosition();
        assertEquals(3, finalPosition.getX());
        assertEquals(1, finalPosition.getY());
    }
    
     /**
     * Test of executeInstructions method, of class Rover.
     */
    @org.junit.Test
    public void testExecuteInstructionsCase5() {
        System.out.println("executeInstructions");
        Rover instance = new Rover();
        instance.setDirection('S');
        instance.setInstructions("RRRRMM");
        instance.setPosition(new TwoDimensionsPosition(2,2));
        instance.setMarsArea(new RectangularArea(7,7));
        instance.executeInstructions();
        assertEquals(instance.getDirection(), 'S');
        TwoDimensionsPosition finalPosition = (TwoDimensionsPosition) instance.getPosition();
        assertEquals(2, finalPosition.getX());
        assertEquals(0, finalPosition.getY());
    }
}
