package cardGames.texasHoldem.engine.player;

import java.lang.reflect.Executable;

import cardGames.card.Card;
import cardGames.exceptions.ValueNotInRange;
import cardGames.player.Player;
import cardGames.texasHoldem.engine.combinations.Combs;
import cardGames.texasHoldem.engine.combinations.Combs.combinations;

public class PlayerTexas extends Player
{
    final private static int countCards = 2;
    final private static int minCountCardsOnTableCombine = 3;
    final private static int maxCountCardsOnTableCombine = 5;

    public PlayerTexas(String name)  throws Exception
    {
        super(name, countCards);
    }

    public ArrayList<combinations> checkCombination(final ArrayList<Card> cards) throws Exception
        
        switch (cards.size()) 
        {
            case minCountCardsOnTableCombine:
                ArrayList<Card> combine = new ArrayList<Card>(cards);
                return Combs.myCombineIs(combine);
                break;
            case 4:
                
                break;
            case maxCountCardsOnTableCombine:
                
                break;
            default:
                throw new ValueNotInRange("Количество карт долнжо быть от " + minCountCardsOnTableCombine + " до " + maxCountCardsOnTableCombine+ ", а на столе " + cards.size()); 
                break;
        }
    }
}
