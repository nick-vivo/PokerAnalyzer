package cardGames.card.builder;

import cardGames.card.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Builder 
{
    public static Set<Card> build(Set<Suit> suits, Set<Rank> ranks)
    {
        Set<Card> cards = new HashSet<Card>();

        for(Suit suit : suits)
        {
            for(Rank rank : ranks)
            {
                cards.add(new Card(suit, rank));
            }   
        }

        return cards;
    }

    public static ArrayList<Card> build(ArrayList<Suit> suits, ArrayList<Rank> ranks)
    {
        ArrayList<Card> cards = new ArrayList<Card>();

        for(Suit suit : suits)
        {
            for(Rank rank : ranks)
            {
                cards.add(new Card(suit, rank));
            }   
        }

        return cards;
    }

    public static Set<Card> packUnique52()
    {
        Set<Suit> suits = new HashSet<>();

        suits.add(Suit.HEART);
        suits.add(Suit.DIAMOND);
        suits.add(Suit.SPADE);
        suits.add(Suit.CLUB);

        Set<Rank> ranks = new HashSet<>();

        ranks.add(Rank.TWO);
        ranks.add(Rank.THREE);
        ranks.add(Rank.FOUR);
        ranks.add(Rank.FIVE);
        ranks.add(Rank.SIX);
        ranks.add(Rank.SEVEN);
        ranks.add(Rank.EIGHT);
        ranks.add(Rank.NINE);
        ranks.add(Rank.TEN);
        ranks.add(Rank.JACK);
        ranks.add(Rank.QUEEN);
        ranks.add(Rank.KING);
        ranks.add(Rank.ACE);

        return build(suits, ranks);
    }

    public static ArrayList<Card> pack52()
    {
        ArrayList<Suit> suits = new ArrayList<>();

        suits.add(Suit.HEART);
        suits.add(Suit.DIAMOND);
        suits.add(Suit.SPADE);
        suits.add(Suit.CLUB);

        ArrayList<Rank> ranks = new ArrayList<>();

        ranks.add(Rank.TWO);
        ranks.add(Rank.THREE);
        ranks.add(Rank.FOUR);
        ranks.add(Rank.FIVE);
        ranks.add(Rank.SIX);
        ranks.add(Rank.SEVEN);
        ranks.add(Rank.EIGHT);
        ranks.add(Rank.NINE);
        ranks.add(Rank.TEN);
        ranks.add(Rank.JACK);
        ranks.add(Rank.QUEEN);
        ranks.add(Rank.KING);
        ranks.add(Rank.ACE);

        return build(suits, ranks);
    }
}
