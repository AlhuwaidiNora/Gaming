import java.util.Random;
import java.util.Scanner;
public class AdventureGame {
    // Constants for game items and monsters
    private static final String[] ITEMS = {"sword", "shield", "health potion"};
    private static final String[] MONSTERS = {"orc", "goblin", "dragon"};
    private static final int MAX_HEALTH = 20;
    // Scanner and Random objects for user input and random number generation
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        int playerHealth = MAX_HEALTH;        // Initialize the player's health to the maximum
        while (true) {
            int monsterHealth = RANDOM.nextInt(10) + 11;   // Generate a random monster with random health
            String monster = MONSTERS[RANDOM.nextInt(3)]; // Print out the monster's information and prompt the player for their choice
            System.out.printf("A %s appeared! Your turn! You have %d health. The %s has %d health. What would you like to do?\n1. Attack\n2. Use item\n3. Flee\nEnter your choice: ", monster, playerHealth, monster, monsterHealth);
            int choice = Integer.parseInt(SCANNER.nextLine()); // Perform the appropriate action based on the player's choice
            switch (choice) {
                case 1: // Player chooses to attack the monster
                    int damage = RANDOM.nextInt(6) + 1;
                    System.out.printf("You attack the %s for %d damage!\n", monster, damage);
                    monsterHealth -= damage; // Check if the monster has been defeated
                    if (monsterHealth <= 0) {
                        System.out.printf("You defeated the %s!", monster);
                        return; // End the game if the monster has been defeated} 
                    damage = RANDOM.nextInt(6) + 1;  // Monster attacks the player in return
                    System.out.printf("The %s attacks you for %d damage!\n", monster, damage);
                    playerHealth -= damage;  // Check if the player has been defeated        
                    if (playerHealth <= 0) {
                        System.out.printf("You were defeated by the %s.\n", monster);
                        return; // End the game if the player has been defeated }
                    break;
                case 2: // Player chooses to use an item
                    System.out.printf("Which item would you like to use?\n1. sword\n2. shield\n3. health potion\nEnter your choice: ");
                    int itemChoice = Integer.parseInt(SCANNER.nextLine());
                    System.out.printf("You used the %s.", ITEMS[itemChoice - 1]); // Print out the item that the player has used
                    break;
                case 3: // Player chooses to flee from the monster
                    System.out.printf("You fled from the %s.\n", monster);
                    return; // End the game if the player has fled  }}}}
