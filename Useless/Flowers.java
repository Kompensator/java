import java.util.Scanner;

public class Flowers {
  public static void main (String[] args){
    Scanner reader = new Scanner(System.in);
    double flowerPetals;
    boolean love;

    System.out.println("Hey!\nHow many petals are left on your flower?");
    flowerPetals = reader.nextDouble();

    if (flowerPetals % 2.0 == 0.0){
     love = true;
    }
     else {
     love = false; }

    if (love == true){
      System.out.println("He loves you");}
      else {
      System.out.println("He loves you not");}
    
    reader.close();
  }
}
