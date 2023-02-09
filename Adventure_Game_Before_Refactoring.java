package Adventure_Game;
import java.util.Scanner;
import java.util.Random;

public class Adventure_Game_Before_Refactoring {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String[] items = {"sword", "shield", "health potion"};
        String[] monsters = {"orc", "goblin", "dragon"};
        int maxHealth = 20;
        int playerHealth = maxHealth;
        
        while (true) {
            int monsterHealth = r.nextInt(10) + 11;
            String monster = monsters[r.nextInt(3)];
            System.out.println("A " + monster + " appeared!");
            System.out.println("Your turn! You have " + playerHealth + " health.");
            System.out.println("The " + monster + " has " + monsterHealth + " health.");
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use item");
            System.out.println("3. Flee");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(sc.nextLine());
            
            if (choice == 1) {
                int damage = r.nextInt(6) + 1;
                System.out.println("You attack the " + monster + " for " + damage + " damage!");
                monsterHealth -= damage ;
                if (monsterHealth <= 0) {
                    System.out.println("You defeated the " + monster + "!");
                    break;
                }
                damage = r.nextInt(6) + 1;
                System.out.println("The " + monster + " attacks you for " + damage + " damage!");
                playerHealth -= damage;
                if (playerHealth <= 0) {
                    System.out.println("You were defeated by the " + monster + ".");
                    break;
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
                break;
            }
        }
    }
}

