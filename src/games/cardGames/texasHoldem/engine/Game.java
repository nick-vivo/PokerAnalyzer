package cardGames.texasHoldem.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import cardGames.card.Card;
import cardGames.card.builder.Builder;
import cardGames.exceptions.DuplicatesFound;
import cardGames.exceptions.SizeExceeded;
import cardGames.exceptions.ValueBad;
import cardGames.exceptions.ValueNotFound;
import cardGames.exceptions.ValueNotInRange;
import cardGames.player.Player;
import cardGames.texasHoldem.engine.board.Board;
import cardGames.texasHoldem.engine.combinations.Combs;


public class Game 
{
    ArrayList<Player> players;
    ArrayList<Card> pack;
    Board board;
    
    static protected final int maxCountPlayers = 11;
    static protected final int minCountPlayers = 1;
    static protected final int countCardInBoard = 5;
    static protected final int countCardsOnHand = 2;

    int indexPlayer;

    public Game(ArrayList<Player> players, ArrayList<Card> packForGame) throws Exception
    {
        if(players.size() > maxCountPlayers || players.size() < minCountPlayers)
            throw new ValueNotInRange("Количество должно быть в диапазоне от " + minCountPlayers + " до " + maxCountPlayers + ", а у тебя " + players.size());

        int factor = (packForGame.size() - countCardInBoard) / countCardsOnHand;
        if(factor < 0 || factor > players.size())
            throw new SizeExceeded("Количество карт не хватит для стола и игроков"); 

        Set<String> set = new HashSet<>();

        for(Player player : players)
        {
            set.add(player.getName());

            if(player.getHand().size() < countCardsOnHand)
                throw new ValueNotFound("Игрок не для этой игры " +
                                     countCardsOnHand + " игрок: " + 
                                     player.getName() + 
                                     " имеет количество карт для игры: " + 
                                     player.getHand().size());
        }                   

        if(players.size() - set.size() != 0) 
            throw new DuplicatesFound("Список игроков имеет повторяющиеся имена.");

        this.pack = new ArrayList<>(packForGame);
        this.board = new Board(players.size(), this.pack);
        this.players = new ArrayList<>(players);
    }

    public ArrayList<Card> getPack() 
    {
        return pack;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }


    public Board getBoard()
    {
        return board;
    }



}
