package cardGames.texasHoldem.engine.board;

import cardGames.card.Card;
import cardGames.exceptions.ValueNotFound;
import cardGames.exceptions.SizeExceeded;
import cardGames.exceptions.ValueBad;

import java.util.ArrayList;


public class Board 
{
    final ArrayList<Card> cardsInPack;
    int countCardsOnBoard;
    
    ArrayList<Card> cardsOnBoard;
    ArrayList<Card> noLostСards;

    public Board(final ArrayList<Card> cardsInPack, final  int countCardsOnBoard) throws Exception
    {
        if(countCardsOnBoard > cardsInPack.size()) 
            throw new ValueBad("Количество кард на доске больше количества карт в колоде: на доске " + countCardsOnBoard + " в колоде: " + cardsInPack.size());
        
        this.cardsInPack = cardsInPack;
        this.countCardsOnBoard = countCardsOnBoard;
        this.cardsOnBoard = new ArrayList<Card>(countCardsOnBoard);
        this.noLostСards = new ArrayList<Card>(cardsInPack);
    }

    public void add(final Card card) throws Exception
    {
        if(cardsOnBoard.size() + 1 > countCardsOnBoard) 
            throw new SizeExceeded("Невозможно добавить карту");

        if(noLostСards.contains(card))
        {
            removeFirstOccurrence(noLostСards, card);
            cardsOnBoard.add(card);
        }
        
        if(cardsInPack.contains(card))
            throw new ValueNotFound("Карты нету в колоде");
        throw new ValueNotFound("Карты уже нету в колоде");
    }

    public void removeCardInDeck(final Card card) throws Exception
    {
        if(noLostСards.contains(card))
            removeFirstOccurrence(noLostСards, card);
        
        if(cardsInPack.contains(card))
            throw new ValueNotFound("Карты нету в колоде");
        throw new ValueNotFound("Карты уже нету в колоде");
    }

    private static <T> boolean removeFirstOccurrence(ArrayList<T> list, final T value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public void makeBoardStarter()
    {
        cardsOnBoard.clear();
        noLostСards = new ArrayList<>(cardsInPack);
    }



    public ArrayList<Card> board()
    {
        return this.cardsOnBoard;
    }

    public ArrayList<Card> deck()
    {
        return this.noLostСards;
    }

    public ArrayList<Card> pack()
    {
        return this.cardsInPack;
    }

    
    public String toString()
    {
        String newStr = "Board:";

        for(Card card : cardsOnBoard) newStr += card;

        return newStr;
    }
}