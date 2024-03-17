package cardGames.card.sort;

import cardGames.card.Card;
import cardGames.exceptions.ValueNotFound;
import cardGames.exceptions.ValueNotInRange;

import java.util.ArrayList;


public class Sort 
{

    public static enum TypeSort
    {
        SUIT,
        RANK;
    }

    public static class Comparator
    {
        TypeSort typeSort;
        
        Comparator(final TypeSort typeSort)
        {
            this.typeSort = typeSort;
        }
        
        public boolean less(final Card c1, final Card c2) throws Exception
        {
            switch (this.typeSort) {
                case SUIT:
                    return c1.lessSuit(c2);
                case RANK:
                    return c1.lessRank(c2);
                default:
                    throw new ValueNotFound("Такого компаратора не существует");
            }
        }

        public boolean more(final Card c1, final Card c2) throws Exception
        {
            switch (this.typeSort) {
                case SUIT:
                    return c1.moreSuit(c2);
                case RANK:
                    return c1.moreRank(c2);
                default:
                    throw new ValueNotFound("Такого компаратора не существует");
            }
        }

        public boolean equals(final Card c1, final Card c2) throws Exception
        {
            switch (this.typeSort) {
                case SUIT:
                    return c1.equals(c2);
                case RANK:
                    return c1.equals(c2);
                default:
                    throw new ValueNotFound("Такого компаратора не существует");
            }
        }
    }

    public static void sort(ArrayList<Card> cards, final TypeSort type) throws Exception
    {
        if(cards.size() < 2) return;

        int mid = cards.size() / 2;
        ArrayList<Card> left = new ArrayList<>(cards.subList(0, mid));
        ArrayList<Card> right = new ArrayList<>(cards.subList(mid, cards.size()));
        
        sort(left, type);
        sort(right, type);

        merge(cards, left, right, new Comparator(type));
    }

    public static void sort(ArrayList<Card> cards, final int begin, final int end, final TypeSort type) throws Exception
    {

        int count = end - begin;

        if(count < 2) return;
        if(count < 0) new ValueNotInRange("begin больше end");
        
        ArrayList<Card> subCards = new ArrayList<>(cards.subList(begin, end));
        ArrayList<Card> left = new ArrayList<>(subCards.subList(0, count / 2));
        ArrayList<Card> right = new ArrayList<>(subCards.subList(count / 2, count));
        
        
        sort(left, type);
        sort(right, type);        
        merge(subCards, left, right, new Comparator(type));

        for(int i = begin, j = 0; i < end; ++i, ++j) cards.set(i, subCards.get(j));
    }

    public static void merge(ArrayList<Card> original, final ArrayList<Card> left, final ArrayList<Card> right,  Comparator comp) throws Exception
    {
        int leftIndex = 0, rightIndex = 0, originalIndex = 0;
        
        while(leftIndex < left.size() && rightIndex < right.size())
        {
            if(comp.less(left.get(leftIndex), right.get(rightIndex))) original.set(originalIndex, left.get(leftIndex++));
            else original.set(originalIndex, right.get(rightIndex++));
            
            ++originalIndex;
        }
        while (leftIndex < left.size()) original.set(originalIndex++, left.get(leftIndex++));
        while(rightIndex < right.size()) original.set(originalIndex++, right.get(rightIndex++));
    }
    
    // public static void sortCardsBySuitWithEqualRankCountsThenRank(ArrayList<Card> cards) throws Exception
    // {
    //     Suit[] suits = Suit.values();
    //     int factorSuits = cards.size() % suits.length;
        
    //     if(factorSuits != suits.length)
    //         throw new ValueBad("Количество карт долнжо быть кратно " + suits.length + ", у тебя " + cards.size());
            
    //     int countCardsInOneSuits  = cards.size() / suits.length;
    //     sort(cards, TypeSort.SUIT);

    //     int index = 0;
    //     List<Card> forException;
        
    //     for(Suit suit : suits)
    //     {
    //         forException = cards.subList(index * countCardsInOneSuits, (index + 1) * countCardsInOneSuits);
    //         for(Card excep : forException)
    //             if( excep.suit().equals(suit) ) 
    //             throw new ValueBad("Рубашка карты  " + excep + 
    //             " не подходит для такой сортировки, нужна рубашка" + suit + 
    //             "(количество значений в различных рубашках должно совпадать, количество рубашек в библиотеке: " 
    //             + suits + ")");

    //         sort(cards, index * countCardsInOneSuits, (index + 1) * countCardsInOneSuits, TypeSort.RANK);
    //     }
    // }
}
