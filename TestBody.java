/**
 *  Tests the Body constructor.
 */
public class TestBody {

    /**
     *  Tests the pairwise force between 2 bodies equals to each other.
     */
    public static void main(String[] args) {
        checkTestBody();
    }

    /**
     *  Checks whether or not two pairforce exert to each other are equal and prints the pairforce.
     *
     *
     *  @param  force1      first body net force
     *  @param  force2      second body net force
     *  @param  label       Label for the 'test' case
     */
    private static void checkEquals(double force1, double force2, String label) {
        if (force1==force2) {
            System.out.println("PASS: " + label
                    + ": Force1:" + force1 + ", Force2:" + force2);
        } else {
            System.out.println("FAIL: " + label
                    + ": Force1:" + force1 + ", Force2:" + force2);
        }
    }

    /**
     *  Checks pairwise force between 2 bodies equals to each other.
     *
     */
    private static void checkTestBody() {
        System.out.println("Checking pairwise force between 2 bodies equals to each other...");

        double xxPos = -1.0,
               yyPos = 2.0,
               xxVel = -3.0,
               yyVel = 4.0,
               mass = 5.0;
        String imgFileName = "jupiter.gif";
        Body b = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

        double xxPos1 = 6.0,
               yyPos1 = -7.0,
               xxVel1 = 8.0,
               yyVel1 = -9.0,
               mass1 = 10.0;
        String imgFileName1 = "sun.gif";
        Body a = new Body(xxPos1, yyPos1, xxVel1, yyVel1, mass1, imgFileName1);

        checkEquals(b.calcForceExertedBy(a), a.calcForceExertedBy(b),"calcForceExertedBy()");
        checkEquals(a.calcForceExertedBy(b), a.calcForceExertedBy(b),"calcForceExertedBy()");
    }
}
