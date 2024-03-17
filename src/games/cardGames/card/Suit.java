package cardGames.card;

public enum Suit 
{
    HEART
    {
        @Override
        public String toString() {
            return "h";
        }
    },
    DIAMOND
    {
        @Override
        public String toString() {
            return "d";
        }
    },
    SPADE
    {
        @Override
        public String toString() {
            return "s";
        }
    },
    CLUB
    {
        @Override
        public String toString() {
            return "c";
        }
    };

    public final boolean less(final Suit other)
    {
        return this.compareTo(other) < 0;
    }

    public final boolean more(final Suit other)
    {
        return this.compareTo(other) > 0;
    }

    public abstract String toString();
}