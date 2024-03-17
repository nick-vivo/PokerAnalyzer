package cardGames.card;

public class Card
{
    protected final Suit suit;
    protected final Rank rank;


    public Card(final Suit suit, final Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public final boolean less(final Card other)
    {
        return rank.less(other.rank) && suit.equals(other.suit);
    }
    
    public final boolean more(final Card other)
    {
        return rank.more(other.rank) && suit.equals(other.suit);
    }

    public final boolean lessRank(final Card other)
    {
        return rank.less(other.rank);
    }

    public final boolean moreRank(final Card other)
    {
        return rank.more(other.rank);
    }

    public final boolean lessSuit(final Card other)
    {
        return suit.less(other.suit);
    }

    public final boolean moreSuit(final Card other)
    {
        return suit.more(other.suit);
    }

    public final boolean equalsSuit(final Card other)
    {
        return suit.equals(other.suit);
    }

    public final boolean equalsSuit(final Suit other)
    {
        return suit.equals(other);
    }

    public final boolean equalsRank(final Card other)
    {
        return this.rank.equals(other.rank);
    }

    public final boolean equalsRank(final Rank other)
    {
        return rank.equals(other);
    }
    
    public final int differenceRank(final Card other)
    {
        return rank.compareTo(other.rank);
    }
    
    public Rank rank()
    {
        return this.rank;
    }
    
    public Suit suit()
    {
        return this.suit;
    }


    public String toString()
    {
        return  '['  + this.rank.toString() + this.suit.toString() + ']';
    }
}
