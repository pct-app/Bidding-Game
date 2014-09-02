package edu.app.biddingchallenge;

import java.util.ArrayList;

public class ExampleBidderOne implements Bidder 
{
	@Override
	public int calculateBid(ArrayList<Integer> yourMovesSoFar, ArrayList<Integer> theirMovesSoFar, int position, int yourMoneyLeft, int theirMoneyLeft) 
	{
		return 10;
	}

	@Override
	public String getName() 
	{
		return "Bidder One";
	}
}
