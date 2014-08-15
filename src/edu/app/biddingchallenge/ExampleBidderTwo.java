package edu.app.biddingchallenge;

import java.util.ArrayList;

public class ExampleBidderTwo implements Bidder 
{
	@Override
	public int calculateBet(ArrayList<Integer> yourMovesSoFar, ArrayList<Integer> theirMovesSoFar, int position) 
	{
		return (int) (Math.random() * 5) + 7;
	}

	@Override
	public String getName() 
	{
		return "Bidder Two";
	}
}
