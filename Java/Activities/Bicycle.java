package activities;

public class Bicycle implements BicycleParts,BicycleOperations {
	
	int gears;
	int speed;
	
	Bicycle(int gears, int speed) {
		this.gears=gears;
		this.speed = speed;
	}

	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		speed -= decrement;	
		System.out.println(speed);
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		speed += increment;
		System.out.println(speed);
		
	}
	
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
	}

}
