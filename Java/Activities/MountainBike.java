package activities;

public class MountainBike extends Bicycle{
	
	int seatHeight;

	MountainBike(int gears, int speed,int seatHeight) {
		super(gears, speed);
		this.seatHeight = seatHeight;
	}
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	@Override
	public String bicycleDesc() {
		
	    return(super.bicycleDesc() + "\nSeat Height is " + seatHeight);
	}

}
