package activities;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plane plane = new Plane(5);
        
        plane.onboard("Kusum");
        plane.onboard("Ankita");
        plane.onboard("Yashika");
       
        System.out.println("Plane took off at: " + plane.takeOff());
        
        System.out.println("People onboared the plane: " + plane.getPassengers());
        
        plane.land();
        
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());

	}

}
