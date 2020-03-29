public class NBody{
  public static double readRadius(String filename){
    In in = new In(filename);
    int planets = in.readInt();
    return in.readDouble();
  }

  public static Body[] readBodies(String filename){
    In in = new In(filename);
    int planets = in.readInt();
    double universeRadius = in.readDouble();
    Body[] bodies = new Body[planets];
    for(int i=0; i<planets; i++){
      bodies[i] = new Body(in.readDouble(),in.readDouble(),
                           in.readDouble(),in.readDouble(),
                           in.readDouble(),
                           in.readString());
    }
    return bodies;
  }

  public static void drawUniverse(double universeRadius){
    /** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

    /** Sets both the x-scale and y-scale to the (same) specified range. */
    //public static void setScale(double min, double max)
    StdDraw.setScale(-universeRadius, universeRadius);

    /* Stamps starfield as background */
    StdDraw.picture(0, 75, "./images/starfield.jpg");

    //show the canvas
    StdDraw.show();
  }

  public static void animation(double T, double dt, Body[] bodies){
    StdDraw.enableDoubleBuffering();
    double counter = 0;

    while(counter<=T){
      double[] xForces = new double[bodies.length];
      double[] yForces = new double[bodies.length];

      for(int i=0; i<xForces.length; i++){
        xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
      }

      for(int i=0; i<yForces.length; i++){
        yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
      }

      for(int i=0; i<bodies.length; i++){
        bodies[i].update(dt,xForces[i],yForces[i]);
      }
      // StdDraw.picture(0, 75, "./images/starfield.jpg");
      for(Body body:bodies){
        body.draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      counter+=dt;
    }
  }

  public static void main(String[] args){
    if (args.length < 3) {
			System.out.println("Please supply T, dt and filename as a command line argument.");
			System.exit(0);
		}
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double universeR = readRadius(filename);
    drawUniverse(universeR);

    Body[] bodies = readBodies(filename);
    for(Body body:bodies){
      body.draw();
    }

    animation(T,dt,bodies);
    }
}
