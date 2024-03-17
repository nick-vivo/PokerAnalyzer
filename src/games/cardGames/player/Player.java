package cardGames.player;

import cardGames.card.Card;
import cardGames.exceptions.ValueBad;
import cardGames.exceptions.ValueTooSmall;

import java.util.ArrayList;
import java.lang.Exception;

public class Player
{
    protected String name;
    protected ArrayList<Card> hand;
    protected final int countCards;


    public Player(final String name, final int countCards) throws Exception
    {
        if(name.length() < 1) throw new ValueTooSmall("Имя игрока пусто");
        
        if (countCards < 1) 
            throw new ValueTooSmall("Количество карт меньше 1");
        

        this.name = name;
        this.countCards = countCards;
        this.hand = new ArrayList<Card>(countCards);
    }

    public Player(final String name, final ArrayList<Card> cards) throws Exception
    {
        this(name, cards.size());
        this.hand = cards;
    }

    
    public final String name()
    {
        return name;
    }

    public final void rename(final String newName) throws Exception
    {
        if(newName.length() < 1) throw new ValueTooSmall("Имя игрока пусто");
        
        name = newName;
    }

    public final ArrayList<Card> hand()
    {
        return hand;
    }

    public final void changeHand(final ArrayList<Card> distribution) throws Exception
    {
        if(distribution.size() != countCards) 
            throw new ValueBad("Количество карт в руке этого игрока должно быть: " + this.hand.size() + ", а у тебя" + distribution.size());
        
        this.hand = distribution;
    }



    public String toString()
    {
        String str = name + ':';
        
        for(Card card : hand) str += card.toString();

        return str;
    }
}
