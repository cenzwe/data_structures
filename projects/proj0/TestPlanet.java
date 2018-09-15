public class TestPlanet{

	public static void main(String[] args) {

		Planet jupiter = new Planet(23, 43, 54, 67, 89, "dang");

		Planet aries = new Planet(34, 43, 23, 43, 54, "chit");

		System.out.println(jupiter.calcForceExertedBy(aries));

		System.out.println(aries.calcForceExertedBy(jupiter));
		
	}


}