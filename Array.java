public class Array{
    public static void main (String[] args) {
        String[] cars = {"BMW","Volvo","3","Tesla"};
        for (String i : cars){
            System.out.println(i);
        }
        System.out.println(cars[1]);
        System.out.println(cars.length);
        int[][] two_d = {{1,2,5},{2,4,8},{71,9}};
        System.out.println(two_d[0][2]);   //should print 5
        // print out all the elements by for loop
        for (int[] i : two_d) {
            for (int j : i) {
                System.out.println(j);
            }
        }
        // other way to print everything
        for (int i = 0; i < two_d.length; i += 1) {
            for (int j = 0; j < two_d[i].length; j += 1) {
                System.out.println(two_d[i][j]);
            }
        }
    }
}
