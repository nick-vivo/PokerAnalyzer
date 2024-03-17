package cardGames.texasHoldem.engine.combinations;

import java.util.ArrayList;

import cardGames.card.Card;
import cardGames.card.Rank;
import cardGames.exceptions.ValueBad;
import cardGames.card.sort.Sort;

public class Combs {

    static public enum combinations {
        HIGH_CARD
        {
            @Override
            public String toString()
            {
                return "HIGH CARD";
            }
        },
        PAIR
        {
            @Override
            public String toString()
            {
                return "PAIR";
            }
        },
        TWO_PAIR
        {
            @Override
            public String toString()
            {
                return "TWO PAIR";
            }
        },
        SET
        {
            @Override
            public String toString()
            {
                return "SET";
            }
        },
        STREET
        {
            @Override
            public String toString()
            {
                return "STREET";
            }
        },
        FLUSH
        {
            @Override
            public String toString()
            {
                return "FLUSH";
            }
        }, 
        FULL_HOUSE
        {
            @Override
            public String toString()
            {
                return "FULL HOUSE";
            }
        },
        QUADS
        {
            @Override
            public String toString()
            {
                return "QUADS";
            }
        }, 
        STRAIGHT_FLUSH
        {
            @Override
            public String toString()
            {
                return "STRAIGHT FLUSH";
            }
        },
        ROYAL_FLUSH
        {
            @Override
            public String toString()
            {
                return "ROYAL FLUSH";
            }
        };
    

        public final boolean less(final combinations other)
        {
            return this.compareTo(other) < 0;
        }

        public final boolean more(final combinations other)
        {
            return this.compareTo(other) > 0;
        }

        public abstract String toString();
    }

    final static int maxCountCards = 5;

    
    public static combinations myCombineIs(final ArrayList<Card> combine) throws Exception
    {
        if(combine.size() != maxCountCards)
            throw new ValueBad("Количество карт не допустимо, нужно: " + maxCountCards + " у тебя: " + combine.size());
        
        ArrayList<Card> cards = new ArrayList<>(combine);
        
        Sort.sort(cards, Sort.TypeSort.RANK);
        
        boolean IsFlush = isFlush(cards);
        boolean IsStreet = isStreet(cards);

        if(IsFlush && IsStreet)
        {
            if(cards.get(0).rank() == Rank.TEN) return combinations.ROYAL_FLUSH;
            return combinations.STRAIGHT_FLUSH;
        }
        else if(IsFlush) return combinations.FLUSH;
        else if(IsStreet) return combinations.STREET;

        int countPair = 0;
        int countSet = 0;
        
        for(int i = 0; i < maxCountCards - 1; ++i)
        {
            if(cards.get(i).differenceRank(cards.get(i + 1)) == 0)
            {
                ++countPair;
                if(i < maxCountCards - 2) if(cards.get(i + 1).differenceRank(cards.get(i + 2)) == 0) ++countSet;
            }
            
        }

        switch (countPair + countSet) {
            case 0:
                return combinations.HIGH_CARD;
            case 1:
                return combinations.PAIR;
            case 2:
                return combinations.TWO_PAIR;
            case 3:
                return combinations.SET;
            case 4:
                return combinations.FULL_HOUSE;
            case 5:
                return combinations.QUADS;
            default:
                throw new Exception("Комбинации не существует");
        }
    }

    private static boolean isFlush(final ArrayList<Card> cards) throws Exception
    {
        for(int i = 0; i < maxCountCards - 1; ++i) 
            if(!cards.get(i).equalsSuit(cards.get(i + 1))) return false;
        return true;
    }

    private static boolean isStreet(final ArrayList<Card> cards) throws Exception
    {

        Sort.sort(cards, Sort.TypeSort.RANK);

        int shift = 1;

        if(cards.get(maxCountCards - 1).equalsRank(Rank.ACE)) ++shift;

        for(int i = 0; i < maxCountCards - shift; ++i)
            if(cards.get(i + 1).differenceRank(cards.get(i)) != 1) return false;
        return true;
    }
}
