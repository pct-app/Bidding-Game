package edu.app.biddingchallenge;

import java.util.ArrayList;
import java.util.Random;

public class BidLogic 
{
	/**
	 * The amount of money both people start with
	 */
	public static final int STARTING_AMOUNT = 100;
	/**
	 * The total number of positions 
	 */
	public static final int NUMBER_OF_POSITIONS = 11;
	/**
	 * The starting location of the bottle
	 */
	public static final int STARTING_POSITION = (NUMBER_OF_POSITIONS + 1) / 2;

	public static void main(String[] args) 
	{
		// keep track of how much money each player has
		int playerOneMoney;
		int playerTwoMoney;
		// keep track of the position 
		int currentPos;
		// variable for the players
		Bidder playerOne;
		Bidder playerTwo;
		// keep track of moves
		ArrayList<Integer> playerOneMoves = new ArrayList<>();
		ArrayList<Integer> playerTwoMoves = new ArrayList<>();
		
		// Change this based on the Class they choice
		playerOne = new ExampleBidderOne();
		playerTwo = new ExampleBidderTwo();
		
		// Initialize the money
		playerOneMoney = STARTING_AMOUNT;
		playerTwoMoney = STARTING_AMOUNT;
		
		// Set the position
		currentPos = STARTING_POSITION;
		
		// Display the beginning 
		displayRound(playerOneMoney, playerTwoMoney, 0, 0, (byte)0, currentPos, playerOne, playerTwo);
		
		// while you are not at the ends and both players have money left keep playing
		while(currentPos != 1 && currentPos != NUMBER_OF_POSITIONS && playerOneMoney > 0 && playerTwoMoney > 0) 
		{
			byte roundWinner;
			
			// get the players bids
			int playerOneBid = playerOne.calculateBid(playerOneMoves, playerTwoMoves, currentPos - 1, playerOneMoney, playerTwoMoney);
			int playerTwoBid = playerTwo.calculateBid(playerTwoMoves, playerOneMoves, NUMBER_OF_POSITIONS - currentPos + 1, playerTwoMoney, playerOneMoney);
			
			// if someone makes an illegal bet other player wins
			if(playerOneBid <= 0 || playerOneBid > playerOneMoney)
			{
				System.out.println("Illegal bet. " + playerTwo.getName() + " wins.");
				break;
			}
			if(playerTwoBid <= 0 || playerTwoBid > playerTwoMoney)
			{
				System.out.println("Illegal bet. " + playerOne.getName() + " wins.");
				break;
			}
			
			// add the bets to the lists
			playerOneMoves.add(playerOneBid);
			playerTwoMoves.add(playerTwoBid);
			
			// in the event of a tie randomly select a winner 
			if (playerOneBid == playerTwoBid)
			{
				// New Random to select the winner
				Random random = new Random();
				
				if(random.nextBoolean())
				{
					playerOneMoney -= playerOneBid;
					roundWinner = 1;
					currentPos--;
				}
				else
				{
					playerTwoMoney -= playerTwoBid;
					roundWinner = 2;
					currentPos++;
				}
			}
			else if (playerOneBid > playerTwoBid)
			{
				playerOneMoney -= playerOneBid;
				roundWinner = 1;
				currentPos--;
			}
			else 
			{
				playerTwoMoney -= playerTwoBid;
				roundWinner = 2;
				currentPos++;
			}
			displayRound(playerOneMoney, playerTwoMoney, playerOneBid, playerTwoBid, roundWinner, currentPos, playerOne, playerTwo);
		}
		// display who one
		if(currentPos == 1) {
			System.out.println(playerOne.getName() + " Wins!");
		}
		// display who one
		else if(currentPos == NUMBER_OF_POSITIONS) {
			System.out.println(playerTwo.getName() + " Wins!");
		}
		else {
			System.out.println("Tie game.");
		}
	}
	
	static void displayRound(int playerOneMoney, int playerTwoMoney, int playerOneBid, int playerTwoBid, byte roundWinner, int currentPosition, 
			Bidder playerOne, Bidder playerTwo) 
	{
		System.out.println(playerOne.getName() + " Balance: " + playerOneMoney);
		System.out.println(playerTwo.getName() + " Balance: " + playerTwoMoney);
		switch(roundWinner) 
		{
		case 0:
			break;
		case 1: 
			System.out.println(playerOne.getName() + " bid: " + playerOneBid + " *Wins round");
			System.out.println(playerTwo.getName() + " bid: " + playerTwoBid);
			break;
		case 2:
			System.out.println(playerOne.getName() + " bid: " + playerOneBid);
			System.out.println(playerTwo.getName() + " bid: " + playerTwoBid + " *Wins round");
			break;
		default:
			// This case should never happen
		}
		
		for(int i = 0; i < NUMBER_OF_POSITIONS; i++) {
			if(i == currentPosition - 1)
				System.out.print(" X ");
			else
				System.out.print(" _ ");
		}
		System.out.println();
		System.out.println();
	}
}
