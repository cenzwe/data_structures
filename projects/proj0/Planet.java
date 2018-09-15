public class Planet {


	// current x position
	public double xxPos;

	// current y position
	public double yyPos;

	// current velocity in the x direction
	public double xxVel;

	//current velocity in the y direction
	public double yyVel;

	public double mass;

	public String imgFileName;

	final static double G = 6.67e-11;

	// constructor for Planet class
	public Planet(double xP, double yP, double xV, 
		double yV, double m, String img){

		xxPos = xP;

		yyPos = yP;

		xxVel = xV;

		yyVel = yV;

		mass = m;

		imgFileName = img;

	}

	// 2nd constructor initializes an identical Planet object
	public Planet(Planet p){

		xxPos = p.xxPos;

		yyPos = p.yyPos;

		xxVel = p.xxVel;

		yyVel = p.yyVel;

		mass = p.mass;

		imgFileName = p.imgFileName;

	}

	// calculates the distance between two planets
	public double calcDistance(Planet p){

		// distance in x direction
		double dx = p.xxPos - this.xxPos;

		// distance in y direction
		double dy = p.yyPos - this.yyPos;

		return Math.sqrt((dx * dx) + (dy * dy));

	}

	// returns a double describing the force exerted on this planet by the given planet
	public double calcForceExertedBy(Planet p){

		return (G * this.mass * p.mass) / (calcDistance(p) * calcDistance(p));

	}

	// returns force exerted on this planet in x direction
	public double calcForceExertedByX(Planet p){

		// distance in x direction
		double dx = p.xxPos - this.xxPos;

		return (calcForceExertedBy(p) * dx) / calcDistance(p);
	}

	// returns force exerted on this planet in y direction
	public double calcForceExertedByY(Planet p){

		// distance in y direction
		double dy = p.yyPos - this.yyPos;

		return (calcForceExertedBy(p) * dy) / calcDistance(p);
	}


	// returns net force exerted on this planet in x direction from all planets
	public double calcNetForceExertedByX(Planet[] allPlanets){

		// net force applied to given planet from other planets
		double totalForceX = 0;

		for (Planet p : allPlanets){

			// if planets are different add net forces
			// planets cannot act upon themselves
			if (!this.equals(p)){

				totalForceX = totalForceX + calcForceExertedByX(p);
			}
		}

		return totalForceX;

	}

	// returns net force exerted on this planet in y direction from all planets
	public double calcNetForceExertedByY(Planet[] allPlanets){

		// net force applied to given planet from other planets
		double totalForceY = 0;

		for (Planet p : allPlanets){

			// if planets are different add net forces
			// planets cannot act upon themselves
			if (!this.equals(p)){

				totalForceY = totalForceY + calcForceExertedByY(p);
			}
		}

		return totalForceY;

	}

	public void update(double dt, double fX, double fY){

		// calculate acceleration in each direction
		double aX = fX / this.mass;

		double aY = fY / this.mass;

		// calculate and update new velocities
		xxVel = xxVel + dt * aX;

		yyVel = yyVel + dt * aY;

		// calculate and update new positions
		xxPos = xxPos + dt * xxVel;

		yyPos = yyPos + dt * yyVel;

	}

	public void draw(){

		String imageFile = "./images/" + imgFileName;

		StdDraw.picture(xxPos, yyPos, imageFile);
	}








}