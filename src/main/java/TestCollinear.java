
public class TestCollinear {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Point p1 = new Point(2,1);
    Point p2 = new Point(4,2);
    Point p3 = new Point(4,1);
    Point p4 = new Point(2,3);
    StdOut.printf("%s to %s %f\n", p1, p2, p1.slopeTo(p2));
    StdOut.printf("%s to %s %f\n", p1, p3, p1.slopeTo(p3));
    StdOut.printf("%s to %s %f\n", p1, p4, p1.slopeTo(p4));  
  }

}
