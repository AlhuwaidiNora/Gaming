package Adventure_Game;
import java.util.Random;
import java.util.Scanner;

public class Adventure_Game_After_Refactoring {
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
            System.out.printf("A %s appeared! Your turn! You have %d health. The %s has %d health. What would you like to do?\n1. Attack\n2. Use item\n3. Flee\nEnter your choice: ", monster, playerHealth, monster, monsterHealth);
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
                    System.out.printf("Which item would you like to use?\n1. sword\n2. shield\n3. health potion\nEnter your choice: ");
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

