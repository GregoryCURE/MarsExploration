
/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */

// Concrete class extending Position abstract class
// 2 cartesian coordinates

public class TwoDimensionsPosition extends Position {
 
    private int x;
    private int y;
    
    TwoDimensionsPosition(){
        this.x = 0;
        this.y = 0;
    }
    
    TwoDimensionsPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    TwoDimensionsPosition(TwoDimensionsPosition position){
        this.x = position.x;
        this.y = position.y;
    }
    
    public int getX(){
        
        return this.x;
    }
    
    public void setX(int x){
        
        this.x = x;
    }
    
    public int getY(){
        
        return this.y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    @Override
    public String toDisplay(){
        
        return this.x + " " + this.y;
    }
}
