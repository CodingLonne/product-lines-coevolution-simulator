package coevolution.life;

import coevolution.environment.Entity;
import coevolution.environment.World;

public class MoveableEntity extends Entity {
	double lastAngle; //in radians
	
    public MoveableEntity(World world, double x, double y, double radius, double lookingAt) {
    	super(world, x, y, radius);
    	this.lastAngle = lookingAt;
    }
    
    public void moveForward(double speed) {
    	moveInDirection(this.lastAngle, speed);
    }
    
    public void moveToEntity(Entity entity, double speed) {
        moveToCoords(entity.getX(), entity.getY(), speed);
    }
    
    public void moveToCoords(double coordX, double coordY, double speed) {
        double dir = Math.atan2(coordY - this.getY(), coordX - this.getX());
        moveInDirection(dir, speed);
    }
    
    public void moveToEdge(double speed) {
    	double dir = getWorld().getDirectionToEdge(this);
    	moveInDirection(dir, speed);
    }
    
    public void moveToCenter(double speed) {
    	double dir = getWorld().getDirectionToCenter(this);
    	moveInDirection(dir, speed);
    }
    
    public void moveInDirection(double dir, double speed) {
    	this.lastAngle = dir;
    	this.setX(this.getX() + Math.cos(dir) * speed);
        this.setY(this.getY() + Math.sin(dir) * speed);
    }
}
