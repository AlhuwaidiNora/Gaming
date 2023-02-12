# Gaming
-- Smelly Style: own version-- 

import java.util.Random;

import java.util.Scanner;

public class Adventure_Game {

   public static void main(String[] args) {
 
   
      int playerHealth = 20;
      
      Scanner sc = new Scanner(System.in);
      
      Random r = new Random();
      
      String[] items = {"sword", "shield", "health potion"};
      
      String[] monsters = {"orc", "goblin", "dragon"};
      
      while (true) {
      
         int monsterHealth = 11 + r.nextInt(10);
	 
         String monster = monsters[r.nextInt(3)];
	 
         System.out.println("A " + monster + " appeared! Your turn! You have " + playerHealth + " health. The " + monster + " has " + monsterHealth + " health. What would you like to do?");
	 
         System.out.println("1. Attack");
	 
         System.out.println("2. Use item");
	 
         System.out.println("3. Flee");
	 
         System.out.print("Enter your choice: ");
	 
         int choice = Integer.parseInt(sc.nextLine());
	 
         if (choice == 1) {
	 
            int damage = 1 + r.nextInt(6);
	    
            System.out.println("You attack the " + monster + " for " + damage + " damage!");
	    
            monsterHealth -= damage;
	    
            if (monsterHealth <= 0) {
	    
               System.out.println("You defeated the " + monster + "!");
	       
               return;
            }
	    
            damage = 1 + r.nextInt(6);
	    
            System.out.println("The " + monster + " attacks you for " + damage + " damage!");
	    
            playerHealth -= damage;
	    
            if (playerHealth <= 0) {
	    
               System.out.println("You were defeated by the " + monster + ".");
	       
               return;
            }
         } else if (choice == 2) {
            System.out.println("Which item would you like to use?");
            System.out.println("1. sword");
            System.out.println("2. shield");
            System.out.println("3. health potion");
            System.out.print("Enter your choice: ");
            int itemChoice = Integer.parseInt(sc.nextLine());
            System.out.println("You used the " + items[itemChoice - 1] + ".");
         } else if (choice == 3) {
            System.out.println("You fled from the " + monster + ".");
            return;
         }
      }
   }
}






/* -- The use of System.out.println for each output, rather than using formatted strings
The use of a switch statement for the user's choice
Magic numbers (such as 11 + r.nextInt(10))
Hardcoded array indices (such as r.nextInt(3))
Lack of meaningful variable names
Inefficient use of if statements */ --



//Refactored Style: own version

package Adventure_Game;

import java.util.Random;

import java.util.Scanner;

public class AdventureGame {

    private static final String[] ITEMS = {"sword", "shield", "health potion"};
    
    private static final String[] MONSTERS = {"orc", "goblin", "dragon"};
    
    private static final int MAX_HEALTH = 20;
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static final Random RANDOM = new Random();
    

    public static void main(String[] args) {
        int playerHealth = MAX_HEALTH;
        while (true) {
            int monsterHealth = RANDOM.nextInt(10) + 11;
            String monster = MONSTERS[RANDOM.nextInt(3)];
            System.out.printf("A %s appeared! Your turn! You have %d health. The %s has %d health.\n", 
                              monster, playerHealth, monster, monsterHealth);
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use item");
            System.out.println("3. Flee");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(SCANNER.nextLine());
            switch (choice) {
                case 1:
                    int damage = RANDOM.nextInt(6) + 1;
                    System.out.printf("You attack the %s for %d damage!\n", monster, damage);
                    monsterHealth -= damage;
                    if (monsterHealth <= 0) {
                        System.out.printf("You defeated the %s!", monster);
                        return;
                    }
                    damage = RANDOM.nextInt(6) + 1;
                    System.out.printf("The %s attacks you for %d damage!\n", monster, damage);
                    playerHealth -= damage;
                    if (playerHealth <= 0) {
                        System.out.printf("You were defeated by the %s.\n", monster);
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Which item would you like to use?");
                    System.out.println("1. sword");
                    System.out.println("2. shield");
                    System.out.println("3. health potion");
                    System.out.print("Enter your choice: ");
                    int itemChoice = Integer.parseInt(SCANNER.nextLine());
                    System.out.printf("You used the %s.", ITEMS[itemChoice - 1]);
                    break;
                case 3:
                    System.out.printf("You fled from the %s.\n", monster);
                    return;
            }
        }
    }
}
