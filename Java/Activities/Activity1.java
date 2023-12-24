package activities;

public class Activity1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.make=2014;
		car.color="Black";
		car.transmission="Manual";
		
		car.displayCharacterstics();
		car.accelerate();
		car.brake();
	}

}
