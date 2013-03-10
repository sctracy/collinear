import java.util.Arrays;


public class Fast {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // read in the input
    String filename = args[0];
    In in = new In(filename);
    int N = in.readInt();
    Point[] points = new Point[N];
    for (int i = 0; i < N; i++) {
      int x = in.readInt();
      int y = in.readInt();
      Point p = new Point(x, y);
      points[i] = p;
    }
        
    Arrays.sort(points);

/*    
    for (int i = 0; i < points.length; i++) {
      StdOut.println(points[i]);
    }
    StdOut.println();
//*/ 

    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
       
    Point p;
    double sl;
    for (int i = 0; i < N; i++) {
      p = points[i];
      
      Arrays.sort(points, i + 1, N, p.SLOPE_ORDER);

//*
      StdOut.println(p);
      for (int k = 0; k < N; k++) {
        StdOut.printf("%s %f\n", points[k], p.slopeTo(points[k]));
      }
      StdOut.println();
//*/
      
      int n = -1, start = -1;
      Point pmin = null, pmax = null;
      sl = 0;
      for (int j = i + 1; j < N; j++) {
        if ((n >= 0) && (p.slopeTo(points[j]) == sl)) {
          if (points[j].compareTo(pmin) < 0) pmin = points[j];
          if (points[j].compareTo(pmax) > 0) pmax = points[j];
          n++;
        }
        
        if (((n >= 0) && (p.slopeTo(points[j]) != sl)) || (n < 0) || (j == N - 1)) {
        
          if (n >= 2) {
            StdOut.print(p);
            for (int k = 0; k <= n; k++) {
              StdOut.print(" -> ");
              StdOut.print(points[start + k]);
              points[start + k].draw();
            }
            StdOut.println();
            pmin.drawTo(pmax);
            n = 0;
          }          
          n = 0;
          start = j;
          sl = p.slopeTo(points[j]);
          pmin = p;
          pmax = p;
        }
      }                 
    }   
  }

}
