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
          n++;
        }
        
        if (((n >= 0) && (p.slopeTo(points[j]) != sl)) || (n < 0) || (j == N - 1)) {
        
          if (n >= 2) {
            Arrays.sort(points, i + 1, j);
            pmin = p;
            pmax = p;
            //StdOut.print(p);
            for (int k = 0; k <= n; k++) {
              if (k == 0) {
                if (points[start + k].compareTo(pmin) < 0) pmin = points[start + k];
              }  
              //else if (points[start + k].compareTo(pmin) > 0) StdOut.print(p);
              else if (k == n) {
                if (points[start + k].compareTo(pmax) > 0) pmax = points[start + k];
              }  
              //if (points[start + k].compareTo(pmin) > 0)
              
              StdOut.print(" -> ");
              StdOut.print(points[start + k]);
              points[start + k].draw();
            }
            StdOut.println();
            pmin.drawTo(pmax);
            //n = 0;
            if (j < N - 1) {
              Arrays.sort(points, j + 1, N, p.SLOPE_ORDER);
            }
          }          
          n = 0;
          start = j;
          sl = p.slopeTo(points[j]);
        }
      }                 
    }   
  }

}
