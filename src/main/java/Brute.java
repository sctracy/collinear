import java.util.Arrays;

public class Brute {
  
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
//*/  
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    Point p,q,r,s;
    for (int i = 0; i < points.length; i++) {
      p = points[i];
      for (int j = i + 1; j < points.length; j++) {
        if (j == i) continue;
        q = points[j];
        for (int k = j + 1; k < points.length; k++) {
          if ((k == i) || (k == j)) continue;
          r = points[k];
          if (p.slopeTo(q) != p.slopeTo(r)) continue;
          for (int l = k + 1; l < points.length; l++) {
            if ((l == i) || (l == j) || (l == k)) continue;
            s = points[l];
            if (p.slopeTo(r) == p.slopeTo(s)) {
              StdOut.printf("%s -> %s -> %s -> %s\n", p, q, r, s);
              p.draw();
              q.draw();
              r.draw();
              s.draw();
              p.drawTo(s);
            }
          }          
        }        
      }      
    }
  }

}
