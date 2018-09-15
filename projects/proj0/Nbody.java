public class NBody{

	public static double readRadius(String file){

		In in = new In(file);

		int numPlanets = in.readInt();

		double radius = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String file){

		Planet[] planetArray = new Planet[5];

		In in = new In(file);

		int numPlanets = in.readInt();

		double radius = in.readDouble();

		for(int i = 0; i < 5; i++){

			Planet p = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), 
			in.readDouble(), in.readDouble(), in.readString());

			planetArray[i] = p;
		}

		return planetArray;

	}

	public static void main(String[] args) {


		double T = Double.parseDouble(args[0]);

		double dt = Double.parseDouble(args[1]);

		String filename = args[2];

		double radius = readRadius(filename);

		Planet[] allPlanets = readPlanets(filename);

		// set the scale of the picture
		StdDraw.setScale(-radius, radius);

		StdDraw.clear();

		StdDraw.picture(0, 0, "./images/starfield.jpg");

		for(Planet p : allPlanets){

			p.draw();
		}

		StdDraw.enableDoubleBuffering();

		double time = 0;

		while(time < T){

			double[] xForces = new double[5];

			double[] yForces = new double[5];

			for(int i = 0; i < 5; i++){

				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);

				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}

			for(int i = 0; i < 5; i++){

				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");

			for(Planet p : allPlanets){

			p.draw();

			}

			StdDraw.show();

			StdDraw.pause(10);

			time = time + dt;
		}

	}

}





















