import java.lang.Math;

public class Body{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  public static final double G = 6.67e-11;

  public Body(double xP, double yP, double xV, double yV, double m, String img){
    xxPos=xP;
    yyPos=yP;
    xxVel=xV;
    yyVel=yV;
    mass=m;
    imgFileName=img;
  }

  public Body(Body b){
    this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
  }

  public double calcDistance(Body b){
    double dxx = b.xxPos - this.xxPos;
    double yxx = b.yyPos - this.yyPos;
    return Math.sqrt(dxx*dxx+yxx*yxx);
  }

  public double calcForceExertedBy(Body b){
    double distance = calcDistance(b);
    return (G*this.mass*b.mass)/(distance*distance);
  }

  public double calcForceExertedByX(Body b){
    double F = calcForceExertedBy(b);
    double distance = calcDistance(b);
    double dxx = b.xxPos - this.xxPos;
    return (F*dxx)/distance;
  }

  public double calcForceExertedByY(Body b){
    double F = calcForceExertedBy(b);
    double distance = calcDistance(b);
    double dyy = b.yyPos - this.yyPos;
    return (F*dyy)/distance;
  }

  public double calcNetForceExertedByX(Body [] bodys){
    double sum = 0;
    if(bodys==null) return sum;
    for(Body body : bodys){
      if(!this.equals(body)){
        sum+=calcForceExertedByX(body);
      }
    }
    return sum;
  }

  public double calcNetForceExertedByY(Body [] bodys){
    double sum = 0;
    if(bodys==null) return sum;
    for(Body body : bodys){
      if(!this.equals(body)){
        sum+=calcForceExertedByY(body);
      }
    }
    return sum;
  }

  public void update(double dt, double fX, double fY){
    double xxAccelerate = fX/mass;
    double yyAccelerate = fY/mass;
    xxVel = xxVel+dt*xxAccelerate;
    yyVel = yyVel+dt*yyAccelerate;
    xxPos = xxPos+dt*xxVel;
    yyPos = yyPos+dt*yyVel;
  }

  public void draw(){
    /** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

    /* Stamps body on the canvas */
    StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);

    //show the canvas
    StdDraw.show();
  }

}
