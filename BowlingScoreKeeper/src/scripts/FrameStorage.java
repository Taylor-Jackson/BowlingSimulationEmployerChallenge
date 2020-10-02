package scripts;

import java.util.*;

/**
 * @author Taylor Jackson
 * 
 * This class houses the storage 
 * of the score cards and the operations
 * that can be executed on those cards.
 */
public class FrameStorage {
	
	// ArrayList for storing the bowling values
	public ArrayList<Integer> oneCard = new ArrayList<Integer>();
	public ArrayList<Integer> twoCard = new ArrayList<Integer>();
	public ArrayList<Integer> threeCard = new ArrayList<Integer>();
	public ArrayList<Integer> fourCard = new ArrayList<Integer>();
	
	/**
	 * Stores the input value into
	 * player 1's card. Adds an extra
	 * zero to account for a strike. Does
	 * not add extra zeroes for strikes if
	 * in the final frame.
	 * 
	 * @param temp - bowl to store
	 * @return - size of ArrayList, checks for strike in main
	 */
	public int oneStorage(int temp) {
		if (temp == 10) {
			oneCard.add(temp);
			if (oneCard.size() < 18) {
				oneCard.add(0);
			}
		}
		else {
			oneCard.add(temp);
		}
		return oneCard.size();
	}
	
	/**
	 * Stores the input value into
	 * player 2's card. Adds an extra
	 * zero to account for a strike. Does
	 * not add extra zeroes for strikes if
	 * in the final frame.
	 * 
	 * @param temp - bowl to store
	 * @return - size of ArrayList, checks for strike in main
	 */
	public int twoStorage(int temp) {
		if (temp == 10) {
			twoCard.add(temp);
			if (twoCard.size() < 18) {
				twoCard.add(0);
			}
		}
		else {
			twoCard.add(temp);
		}
		return twoCard.size();
	}
	
	/**
	 * Stores the input value into
	 * player 3's card. Adds an extra
	 * zero to account for a strike. Does
	 * not add extra zeroes for strikes if
	 * in the final frame.
	 * 
	 * @param temp - bowl to store
	 * @return - size of ArrayList, checks for strike in main
	 */
	public int threeStorage(int temp) {
		if (temp == 10) {
			threeCard.add(temp);
			if (threeCard.size() < 18) {
				threeCard.add(0);
			}
		}
		else {
			threeCard.add(temp);
		}
		return threeCard.size();
	}
	
	/**
	 * Stores the input value into
	 * player 4's card. Adds an extra
	 * zero to account for a strike. Does
	 * not add extra zeroes for strikes if
	 * in the final frame.
	 * 
	 * @param temp - bowl to store
	 * @return - size of ArrayList, checks for strike in main
	 */
	public int fourStorage(int temp) {
		if (temp == 10) {
			fourCard.add(temp);
			if (fourCard.size() < 18) {
				fourCard.add(0);
			}
		}
		else {
			fourCard.add(temp);
		}
		return fourCard.size();
	}
	
	/**
	 * Prints the desired ArrayList in
	 * a more readable format.
	 * 
	 * @param card - Card to format and print
	 */
	public void printFrame(ArrayList<Integer> card) {
		if (card.size() <= 18) { // Prints partial card
			for (int i = 0; i < card.size() / 2; i += 1) {
				System.out.print(card.get(i * 2) + " " + card.get(i * 2 + 1) + " | "); 
			}
		}
		else {
			for (int i = 0; i < 18; i += 2) { // Prints full card
				System.out.print(card.get(i) + " " + card.get(i + 1) + " | "); 
			}
			System.out.print(card.get(18) + " " + card.get(19) + " " + card.get(20));
		}
	}
	
	/**
	 * This method calculates a card's total
	 * score using the calculateStrike and 
	 * calculateSpare methods.
	 * 
	 * @param list - Card to calculate
	 * @return - the total score of the card
	 */
	public int calculateCard(ArrayList<Integer> list) {
		
		int score = 0; // total score
		
		for (int i = 0; i < 17; i += 2) { // Loop through regular frames
			
			if (i == list.size()) { // Allows method to stop if card is not full
				return score;
			}
			
			// This try-catch eliminates crashes caused by trying an index
			// that doesn't exist and treats it as finding a zero
			try {
				if (list.get(i) == 10 && i % 2 == 0) { // If a strike was bowled
					if (list.get(i + 2) == 10 && list.size() != 16) { // If one bonus is a strike and not in final frame
						score += calculateStrike(list.get(i + 2), list.get(i + 4));
					}
					else { // Regular strike calculation
						score += calculateStrike(list.get(i + 2), list.get(i + 3));
					}
				}
				else if (list.get(i) == 10) { // If spare was bowled after gutter ball
					score += calculateSpare(list.get(i + 1));
				}
				
				else if (list.get(i) + list.get(i + 1) == 10) { // If spare was bowled
					score += calculateSpare(list.get(i + 2));
				}	
				
				else { // If frame is open
					score += (list.get(i) + list.get(i + 1));
				}
			} catch (IndexOutOfBoundsException e) {}
		}
		
		if (list.size() > 18) { // Calculates final frame separately, adds all bowls together
			list.add(0); // Add extra zero in case third bowl isn't applicable
			score += (list.get(18) + list.get(19) + list.get(20));
		}
		
		return score;
	}
	
	/**
	 * This method calculates the
	 * bonus for a spare.
	 * 
	 * @param bonus - bowl to add as bonus
	 * @return - total pins awarded for frame
	 */
	public int calculateSpare(int bonus) {
		return 10 + bonus;
	}
	
	/**
	 * This method calculates the 
	 * bonus for a strike.
	 * 
	 * @param bonusOne - first bonus bowl to add
	 * @param bonusTwo - second bonus bowl to add
	 * @return - total pins awarded for frame
	 */
	public int calculateStrike(int bonusOne, int bonusTwo) {
		return 10 + bonusOne + bonusTwo;
	}
	
	/**
	 * This method calculates the winning
	 * score and returns the number 
	 * of which player won
	 * 
	 * @return - the player who won
	 */
	public int calculateWinner() {
		int one = calculateCard(oneCard);
		int two = calculateCard(twoCard);
		int three = calculateCard(threeCard);
		int four = calculateCard(fourCard);
		
		int highest = 0;
		
		highest = Math.max(one, two);
		highest = Math.max(highest, three);
		highest = Math.max(highest, four);
		
		if (highest == one) {
			return 1;
		}
		else if (highest == two) {
			return 2;
		}
		else if (highest == three) {
			return 3;
		}
		else {
			return 4;
		}
	}
}
