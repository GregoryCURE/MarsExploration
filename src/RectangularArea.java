
/**
 * @author Grégory CURE
 * Date: 20/01/2016
 */

// Concrete class extending MarsArea abstract class
// 2 dimensional space with cartesian coordinates

public class RectangularArea extends MarsArea {
    
    private int xDimension;
    private int yDimension;
    
    RectangularArea(){
       
        this.xDimension = 0;
        this.yDimension = 0;
    }
    
    RectangularArea(int xDim, int yDim){
        
        this.xDimension = xDim;
        this.yDimension = yDim;
    }
    
    public void setXDimension(int xDim){
        
        this.xDimension = xDim;
    }
    
    public void setYDimension(int yDim){
        
        this.yDimension = yDim;
    }
    
    // The below method declared in the class MarsArea is implemented
    @Override
    public boolean isPositionValid(Position currentPosition){
        
        // We know we are working with a two dimensional position => cast
        TwoDimensionsPosition position = (TwoDimensionsPosition) currentPosition;
        
        int xPosition = position.getX();
        int yPosition = position.getY();
        
        return (xPosition >= 0 && xPosition <= xDimension && yPosition >= 0 && yPosition <= yDimension);
    }
    
    // The below method declared in the class MarsArea is implemented
    @Override
    public void computeNewPosition(Position position, char direction){
       
        // We know we are working with a two dimensional position => cast
        TwoDimensionsPosition currentPosition = (TwoDimensionsPosition) position;
        TwoDimensionsPosition newPosition = new TwoDimensionsPosition(currentPosition);
        
        switch(direction){
            case 'N':
                newPosition.setY(newPosition.getY() + 1);
                break;
            case 'E':
                newPosition.setX(newPosition.getX() + 1);
                break;
            case 'S':
                newPosition.setY(newPosition.getY() - 1);
                break;
            case 'W':
                newPosition.setX(newPosition.getX() - 1);
                break;
            default:
                System.out.println("Unknown direction !");
        }
        
        // The new position is not out of the map, we update the current position of the rover
        if(isPositionValid(newPosition)){
            
            currentPosition.setX(newPosition.getX());
            currentPosition.setY(newPosition.getY());
        }
    }
}
