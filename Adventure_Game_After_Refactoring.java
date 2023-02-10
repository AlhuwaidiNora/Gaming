package Adventure_Game;
import java.util.Random;
import java.util.Scanner;
public class Adventure_Game_After_Refactoring {

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
            System.out.printf("A %s appeared! Your turn! You have %d health. The %s has %d health. What would you like to do?\n1. Attack\n2. Use item\n3. Flee\nEnter your choice: ", monster, playerHealth, monster, monsterHealth);
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
               System.out.printf("Which item would you like to use?\n1. sword\n2. shield\n3. health potion\nEnter your choice: ");
                int itemChoice = Integer.parseInt(sc.nextLine());
                System.out.println("You used the " + items[itemChoice - 1] + ".");
            } else if (choice == 3) {
                System.out.println("You fled from the " + monster + ".");
                break;
            }
        }
    }
}
