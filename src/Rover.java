
/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */

public class Rover {
    
    // different attributes defining a rover
    private Position position;
    private char direction;
    private String instructions;
    private MarsArea map;
    
    Rover(){
        
        this.position = null;
        this.direction = 'N';
        this.instructions = ""; 
        this.map = null;
    }
    
    Rover(Position position, char direction, String instructions, MarsArea map){
        
        this.position = position;
        this.direction = direction;
        this.instructions = instructions;
        this.map = map;
    }
    
    Rover(Position position){
        
        this.position = position;
    }
    
    public Position getPosition(){
        
        return this.position;
    }
    
    public void setPosition(Position position){
        
        this.position = position;
    }
    
    public char getDirection(){
        
        return this.direction;
    }
    
    public void setDirection(char direction){
        
        this.direction = direction;
    }
    
    public String getInstructions(){
        
        return this.instructions;
    }
    public void setInstructions(String instructions){
        
        this.instructions = instructions;
    }
    
    public MarsArea getMarsArea(){
        
        return this.map;
    }
    
    public void setMarsArea(MarsArea map){
        
        this.map = map;
    }
    
    private boolean isReady(){
      
        // a rover is ready when its position is defined and the map is known
        return (null != this.position) && (null != this.map);
    }
    
    public void displayPositionAndDirection(){
        
        if(isReady())
            System.out.println(this.position.toDisplay() + " " + this.direction);
        else
            System.out.println("position unknown !");
    }
    
    private void turnLeft(){
        
        int currentIndex = MarsArea.cardinalPoints.indexOf(this.direction);
        
        if(currentIndex > 0)
            this.direction = MarsArea.cardinalPoints.get(currentIndex - 1);
        else
            this.direction = MarsArea.cardinalPoints.get(MarsArea.cardinalPoints.size() - 1);
    }
    
    private void turnRight(){
        
        int currentIndex = MarsArea.cardinalPoints.indexOf(this.direction);
      
        if(currentIndex < MarsArea.cardinalPoints.size() - 1)
            this.direction = MarsArea.cardinalPoints.get(currentIndex + 1);
        else
            this.direction = MarsArea.cardinalPoints.get(0);
    }
    
    private void moveForward(){
       
        this.map.computeNewPosition(this.position, this.direction);
    }
    
    public void executeInstructions(){
      
        if(this.isReady() && !this.instructions.isEmpty()){
            
            char[] sequence = this.instructions.toCharArray();
            
            for(char letter : sequence){
                
                switch(letter){
                        case 'L':
                            turnLeft();
                            break;
                        case 'R':
                            turnRight();
                            break;
                        case 'M':
                            moveForward();
                            break;
                        default:
                            System.out.println("unknown instruction !");
                }
            }
        }  
    }         
}
