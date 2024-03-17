package cardGames;

import java.util.ArrayList;


import cardGames.card.*;
import cardGames.texasHoldem.engine.combinations.Combs;


public class Tmp {

    public static void main(String[] args) 
    {
        ArrayList<Card> combine1 = new ArrayList<>();
        combine1.add(new Card(Suit.HEART, Rank.TWO));
        combine1.add(new Card(Suit.HEART, Rank.THREE));
        combine1.add(new Card(Suit.HEART, Rank.FOUR));
        combine1.add(new Card(Suit.HEART, Rank.FIVE));
        combine1.add(new Card(Suit.HEART, Rank.SIX));
        
        ArrayList<Card> combine2 = new ArrayList<>();
        combine2.add(new Card(Suit.HEART, Rank.SEVEN));
        combine2.add(new Card(Suit.HEART, Rank.EIGHT));
        combine2.add(new Card(Suit.HEART, Rank.NINE));
        combine2.add(new Card(Suit.HEART, Rank.TEN));
        combine2.add(new Card(Suit.HEART, Rank.JACK));

        ArrayList<Card> combine3 = new ArrayList<>();
        combine3.add(new Card(Suit.SPADE, Rank.TEN));
        combine3.add(new Card(Suit.SPADE, Rank.JACK));
        combine3.add(new Card(Suit.SPADE, Rank.QUEEN));
        combine3.add(new Card(Suit.SPADE, Rank.KING));
        combine3.add(new Card(Suit.SPADE, Rank.ACE));
        
        ArrayList<Card> combine4 = new ArrayList<>();
        combine4.add(new Card(Suit.HEART, Rank.TWO));
        combine4.add(new Card(Suit.SPADE, Rank.THREE));
        combine4.add(new Card(Suit.CLUB, Rank.FOUR));
        combine4.add(new Card(Suit.DIAMOND, Rank.FIVE));
        combine4.add(new Card(Suit.HEART, Rank.EIGHT));

        ArrayList<Card> combine5 = new ArrayList<>();
        combine5.add(new Card(Suit.SPADE, Rank.FOUR));
        combine5.add(new Card(Suit.HEART, Rank.THREE));
        combine5.add(new Card(Suit.SPADE, Rank.FOUR));
        combine5.add(new Card(Suit.CLUB, Rank.FIVE));
        combine5.add(new Card(Suit.DIAMOND, Rank.EIGHT));

        try
        {
            System.out.println("\n" + combine1 + Combs.myCombineIs(combine1));
            System.out.println("\n" + combine2 + Combs.myCombineIs(combine2));
            System.out.println("\n" + combine3 + Combs.myCombineIs(combine3));
            System.out.println("\n" + combine4 + Combs.myCombineIs(combine4));
            System.out.println("\n" + combine5 + Combs.myCombineIs(combine5));
        }
        catch(Exception e)
        {
            System.out.println("Ошибка");
        }
        combine1.clear();
    }
}

