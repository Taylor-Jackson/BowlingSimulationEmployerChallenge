package scripts;

import java.util.Scanner;

/**
 * @author Taylor Jackson
 * 
 * This class holds the main method 
 * for calculating bowling scores
 * from a game of bowling.
 */
public class Main {

	public static void main(String[] args) {
		FrameStorage store = new FrameStorage(); // Class variable to call methods
		Scanner input = new Scanner(System.in); // Read input
		
		// Input number of players into temp
		System.out.println("Enter number of players (2-4)");
		int temp = input.nextInt();
		
		// Player strings
		String player1 = "";
		String player2 = "";
		String player3 = "";
		String player4 = "";
		
		// Input names into string variables, if applicable
		if(temp >= 2) {
			System.out.print("Enter name for Player 1 ");
			player1 = input.next();
			System.out.println();
			System.out.print("Enter name for Player 2 ");
			player2 = input.next();
			System.out.println();
			
			if (temp >= 3) {
				System.out.print("Enter name for Player 3 ");
				player3 = input.next();
				System.out.println();
				
				if (temp == 4) {
					System.out.print("Enter name for Player 4 ");
					player4 = input.next();
					System.out.println();
				}
			}
		}
		
		// Main loop for reading data from players
		for (int i = 0; i < 9; i++) {
			
			int holder = 0; // Placement in ArrayList, determines if another bowl is needed
			
			// Player 1's turn
			System.out.print("Enter " + player1 + "'s next bowl ");
			holder = store.oneStorage(input.nextInt());
			// If index is not even, input another bowl
			if (holder % 2 != 0) {
				System.out.print("Enter " + player1 + "'s next bowl ");
				holder = store.oneStorage(input.nextInt());
			}
			store.printFrame(store.oneCard); // Print Player 1's card
			System.out.println();
			System.out.println(store.calculateCard(store.oneCard)); // Print Player 1's score
			
			// Player 2's turn
			System.out.print("Enter " + player2 + "'s next bowl ");
			holder = store.twoStorage(input.nextInt());
			// If index is not even, input another bowl
			if (holder % 2 != 0) {
				System.out.print("Enter " + player2 + "'s next bowl ");
				holder = store.twoStorage(input.nextInt());
			}
			store.printFrame(store.twoCard); // Print Player 2's card
			System.out.println();
			System.out.println(store.calculateCard(store.twoCard)); // Print Player 2's score
			
			// Player 3's turn, if existing
			if (player3 != "") {
				System.out.print("Enter " + player3 + "'s next bowl ");
				holder = store.threeStorage(input.nextInt());
				// If index is not even, input another bowl
				if (holder % 2 != 0) {
					System.out.print("Enter " + player3 + "'s next bowl ");
					holder = store.threeStorage(input.nextInt());
				}
				store.printFrame(store.threeCard); // Print Player 3's card
				System.out.println();
				System.out.println(store.calculateCard(store.threeCard)); // Print Player 3's score

			}
			
			// Player 4's turn, if existing
			if (player4 != "") {
				System.out.print("Enter " + player4 + "'s next bowl ");
				holder = store.fourStorage(input.nextInt());
				// If index is not even, input another bowl
				if (holder % 2 != 0) {
					System.out.print("Enter " + player4 + "'s next bowl ");
					holder = store.fourStorage(input.nextInt());
				}
				store.printFrame(store.fourCard); // Print Player 4's card
				System.out.println();
				System.out.println(store.calculateCard(store.fourCard)); // Print Player 4's score
			}
		}
		// Final frame has to be handled differently
		
		// Player 1's final frame
		System.out.print("Final frame! Enter " + player1 + "'s next bowl ");
		store.oneStorage(input.nextInt());
		System.out.print("Enter " + player1 + "'s next bowl ");
		store.oneStorage(input.nextInt());
		if (store.oneCard.get(18) + store.oneCard.get(19) >= 10) { // If strike or spare was achieved, bowl again
			System.out.print("Enter " + player1 + "'s final bowl ");
			temp = store.oneStorage(input.nextInt());
		}
		store.printFrame(store.oneCard); // Player 1's final card
		System.out.println();
		System.out.print("Final score is " + store.calculateCard(store.oneCard)); // Player 1's final score
		System.out.println();
		
		// Player 2's final frame
		System.out.print("Final frame! Enter " + player2 + "'s next bowl ");
		store.twoStorage(input.nextInt());
		System.out.print("Enter " + player2 + "'s next bowl ");
		store.twoStorage(input.nextInt());
		if (store.twoCard.get(18) + store.twoCard.get(19) >= 10) { // If strike or spare was achieved, bowl again
			System.out.print("Enter " + player2 + "'s final bowl ");
			temp = store.twoStorage(input.nextInt());
		}
		store.printFrame(store.twoCard); // Player 2's final card
		System.out.println();
		System.out.print("Final score is " + store.calculateCard(store.twoCard)); // Player 2's final score
		System.out.println();
		
		// Player 3's final frame, if existing
		if (player3 != "") {
			System.out.print("Final frame! Enter " + player3 + "'s next bowl ");
			store.threeStorage(input.nextInt());
			System.out.print("Enter " + player3 + "'s next bowl ");
			store.threeStorage(input.nextInt());
			if (store.threeCard.get(18) + store.threeCard.get(19) >= 10) { // If strike or spare was achieved, bowl again
				System.out.print("Enter " + player3 + "'s final bowl ");
				temp = store.threeStorage(input.nextInt());
			}
			store.printFrame(store.threeCard); // Player 3's final card
			System.out.println();
			System.out.print("Final score is " + store.calculateCard(store.threeCard)); // Player 3's final score
			System.out.println();
		}
		
		// Player 4's final frame, if existing
		if (player4 != "") {
			System.out.print("Final frame! Enter " + player4 + "'s next bowl ");
			store.fourStorage(input.nextInt());
			System.out.print("Enter " + player4 + "'s next bowl ");
			store.fourStorage(input.nextInt());
			if (store.fourCard.get(18) + store.fourCard.get(19) >= 10) { // If strike or spare was achieved, bowl again
				System.out.print("Enter " + player4 + "'s final bowl ");
				temp = store.fourStorage(input.nextInt());
			}
			store.printFrame(store.fourCard); // Player 4's final card
			System.out.println();
			System.out.print("Final score is " + store.calculateCard(store.fourCard)); // Player 4's final score
			System.out.println();
		}
		
		// Calculate and print the winning Player's name
		int winner = store.calculateWinner();
		
		if (winner == 1) {
			System.out.println(player1 + " wins!");
		}
		else if (winner == 2) {
			System.out.println(player2 + " wins!");
		}
		else if (winner == 3) {
			System.out.println(player3 + " wins!");
		}
		else {
			System.out.println(player4 + " wins!");
		}
	}
}
