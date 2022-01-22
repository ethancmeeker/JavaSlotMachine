import java.util.ArrayList;
import javax.swing.JOptionPane; // JOption Panes
import java.util.Random;
import java.util.*;


public class Slot { 
  private static String spin(ArrayList<String> list) {// This method picks a random value from a list in order to get a random spin for the slot machine. It can't be void so it can return a String

    Random rd = new Random(); // Create random
    String roll = list.get(rd.nextInt(list.size()));
    return roll; // Return what is rolls
  }
  public static void main(String[] args) {
    int money = 2208; // BYU-I Tuition
    ArrayList<String> symbols= new ArrayList<String>(
      Arrays.asList("Lemon", "Seven", "Orange", "Bomb",
                    "Cherry", "Bell", "Bar", "Diamond",
                    "Watermelon", "Grape", "Shamrock", "Gold Bar", "Bomb", "Bar", "Bar", "Banana", "Dragon Fruit", "Heart"));
    ArrayList<String> fruits = new ArrayList<String>(Arrays.asList("Lemon", "Orange", "Grape", "Watermelon", "Cherry", "Banana", "Dragon Fruit"));
    ArrayList<String> lucky = new ArrayList<String>(Arrays.asList("Bell", "Diamond", "Shamrock", "Heart"));
    System.out.println(symbols);
    JOptionPane.showMessageDialog(null, "Welcome to the casino were you can more than double\nyour tuition money. Imagine living at a higher class\napartment complex. Care to try are slot machines, they\nare so much fun.", "why hello there", JOptionPane.PLAIN_MESSAGE); // The "why hello there" has to be there or java gets mad
    while(money > 49) { // While loop checks if you have enough money to play. If not, you are no longer in the loop.
      int result = JOptionPane.showConfirmDialog(null, "Pull the lever\nOnly costs $50 to play\nYou are currently at $" + money);
      switch (result) { // The switch will let java figure out what button I pressed to determine it's next option
        case JOptionPane.YES_OPTION: // Checks if the yes button is pushed to start the game
        System.out.println("Yes");
        money -= 50;
        int pot = 0;
        int sevens = 0;
        String message = "";
        String slot1 = spin(symbols); // Calls the spin method to get something random from the image choices
        String slot2 = spin(symbols);
        String slot3 = spin(symbols);
        ArrayList<String> spin = new ArrayList<String>(Arrays.asList(slot1, slot2, slot3));
        for (String i : spin) { // For loop that goes through the spin list
          if (fruits.contains(i)) { // Looks for strings in the spin list from the fruit list
            pot += 5;
          }
          if (lucky.contains(i)) { // Looks for strings in the spin list from the lucky list 
            pot += 15;
          }
          if (i == "Seven") { // Checks if the spin contains a seven
            if (sevens < 1) {sevens += 7;} // The seven multiples itself by the other sevens, if there is just one, it is worth 7, if there are two, they are worth 49
            else {sevens *= 7;}
          }
          if (i == "Gold Bar") {
            pot += 20;
            message = "GOLD PANNER"; // This prints a message out if certain criteria is met
          }
        }
        System.out.println(pot);
        pot += sevens; // This adds the value that was made by the sevens from the spin list to the pot. If I just put it in the pot directly, it would multiply the whole pot by 7 and not just the other sevens.
        if (slot1 == slot2 && slot1 == slot3 && sevens < 1) { // Checks if all 3 slots are the same
          pot *= 6;
          message = "3 OF A KIND";
        }
        if (spin.contains("Bomb")) { // If there is a bomb anywhere in the lineup, the pot is automatically 0 no matter what.
          pot = 0;
          message = "KABOOM";
        }
        if (slot1 == "Bar" && slot2 == "Bar" && slot3 == "Bar") { // Meeting the bar 
          pot = 50;
          message = "MET THE BAR";
        }
        if (fruits.contains(slot1) && slot1 != slot2 && slot1 != slot3) { 
          if (fruits.contains(slot2) && slot2 != slot3) {
            if (fruits.contains(slot3)) { // This whole thing checks if all the fruits in the lineup are different from one another to get a new pot value
              pot = 175;
              message = "FRUIT BASKET";
            }
          }
        }
        if (lucky.contains(slot1) && slot1 != slot2 && slot1 != slot3) {
          if (lucky.contains(slot2) && slot2 != slot3) {
            if (lucky.contains(slot3)) { // Same as the fruit basket if statements except with the lucky symbols.
              pot = 175;
              message = "FORTUNE FAVORS THE LUCKY";
            }
          }
        }
        if (spin.contains("Bell") && spin.contains("Banana") && spin.contains("Lemon")) { // If all the symbols would be the color yellow and different (only 3 yellow symbols) it gives the pot a new value
          pot = 350;
          message = "YELLOW FELLOW";
        }
        if (spin.contains("Cherry") && spin.contains("Dragon Fruit") && spin.contains("Heart")) { // Same as the Yellow Fellow if statement
          pot = 350;
          message = "RUNNING RED";
        }
        JOptionPane.showMessageDialog(null, slot1 + " | " + slot2 + " | " + slot3 + "\n" + pot + "\n" + message + "\nLet's go for another spin", "SO MUCH FUN", 
        JOptionPane.PLAIN_MESSAGE);
        money += pot;
        break; // This break breaks the current spin loop and puts you back to the part where the program asks you if you want to spin
        case JOptionPane.NO_OPTION: // Checks if you selected no when asking if you wanted to spin
        System.out.println("No");
        int result2 = JOptionPane.showConfirmDialog(null, "Awwwwwww really, you sure");
        switch (result2) {
          case JOptionPane.YES_OPTION:
          System.out.println("Yes");
          int result3 = JOptionPane.showConfirmDialog(null, "You absolutly sure????");
          switch (result3) {
            case JOptionPane.YES_OPTION:
            System.out.println("Yes");
            int result4 = JOptionPane.showConfirmDialog(null, "Wait I'll give you an extra $50 bucks to stay. That's\na free roll, care to take your chances");
            switch (result4) {
              case JOptionPane.NO_OPTION:
              System.out.println("No");
              money += 100;
              break;
              case JOptionPane.YES_OPTION:
              System.out.println("Yes");
              int result5 = JOptionPane.showConfirmDialog(null, "Last chance, come on what's one little more spin going to do");
              switch (result5) {
                case JOptionPane.YES_OPTION:
                System.exit(0);
                
            
    }}
}}}}
    JOptionPane.showMessageDialog(null, "Awwww, no more money left. Get out and come\nback when you're a little hmmmm richer", "awww so sad", JOptionPane.PLAIN_MESSAGE); // Once you have less then the required amount to play, the while loop stops and puts you here.
    }}