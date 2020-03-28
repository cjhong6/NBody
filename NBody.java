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

}
