
/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */

import java.util.ArrayList;
import java.io.*;

public class LaunchMarsExploration {
    
    public static void main(String [] args) throws IOException{
        
       RectangularArea map = new RectangularArea();
       ArrayList<Rover> rovers = new ArrayList<>();

       initialize(map, rovers);
       executeRoversInstructions(rovers);
       displayRoversPositions(rovers);
    }
    
    public static void initialize(RectangularArea map, ArrayList<Rover> rovers) throws IOException{
    
        try
        {     
            FileReader inputsFile = new FileReader("inputs/exploration_inputs.txt");
            BufferedReader reader = new BufferedReader(inputsFile);
            String line;
            
            // 1: initialization of the map dimensions
            if(null != (line = reader.readLine()))
            {
                String[] subString = line.split("\\s+");
                
                map.setXDimension(Integer.parseInt(subString[0]));
                map.setYDimension(Integer.parseInt(subString[1]));
                
                // 2: loop to initialize rovers  
                while(null != (line = reader.readLine()))
                {
                    Rover rover = new Rover();
                    
                    subString = line.split("\\s+");
                    rover.setPosition(new TwoDimensionsPosition(Integer.parseInt(subString[0]), Integer.parseInt(subString[1])));
                    rover.setDirection(subString[2].charAt(0));
                    
                    if(null != (line = reader.readLine())){
                        
                        rover.setInstructions(line);
                    }
                    // 3: make the rover aware of its environment by setting the map
                    rover.setMarsArea(map);
                    rovers.add(rover);
                }
            }
            inputsFile.close();
        }
        catch(IOException exception)
        {
            System.out.println("inputs/outptus error :" + exception);
        }
        
    }
    
    public static void executeRoversInstructions(ArrayList<Rover> rovers){
        
        // each rover will sequentially execute its own instructions 
        for(Rover rover : rovers){
            
            rover.executeInstructions();
        }
    }
    
    public static void displayRoversPositions(ArrayList<Rover> rovers){
        
        // each rover will sequentially display its own position and direction
        for(Rover rover : rovers){
            
            rover.displayPositionAndDirection();
        }
    }
}
