public class While {
  public static void main (String[] args) {
      int i = 0;
      while (i < 5) {
          System.out.println(i);
          i += 1;
      }
      do {
          System.out.println(i);
          i += 2;
      }
      while (i < 100);
  }
}

