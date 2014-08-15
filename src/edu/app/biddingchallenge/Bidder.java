package edu.app.biddingchallenge;

import java.util.ArrayList;
public interface Bidder 
{
	/**
	 * Calculate your bid based on the information
	 * @param yourMovesSoFar - An ArrayList of the bets that you have placed so far in the game
	 * @param theirMovesSoFar - An ArrayList of the bets that the other person placed in the game
	 * @param position - The current position of the bottle 
	 * @return Your bid for this round. Valid bids range from 1 up to the amount of money you have left.
	 */
	public int calculateBet(ArrayList<Integer> yourMovesSoFar, ArrayList<Integer> theirMovesSoFar, int position);
	
	/**
	 * @return Your name so you can see who wins the game!
	 */
	public String getName();
}