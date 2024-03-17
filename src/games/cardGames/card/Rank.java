package cardGames.card;

public enum Rank
{
    TWO
    {
        @Override
        public String toString() {
            return "2";
        }
    },
    
    THREE
    {
        @Override
        public String toString() {
            return "3";
        }
    },

    FOUR
    {
        @Override
        public String toString() {
            return "4";
        }
    },

    FIVE
    {
        @Override
        public String toString() {
            return "5";
        }
    },

    SIX
    {
        @Override
        public String toString() {
            return "6";
        }
    },
    SEVEN
    {
        @Override
        public String toString() {
            return "7";
        }
    },
    EIGHT
    {
        @Override
        public String toString() {
            return "8";
        }
    },
    NINE
    {
        @Override
        public String toString() {
            return "9";
        }
    },
    TEN
    {
        @Override
        public String toString() {
            return "T";
        }
    },
    JACK
    {
        @Override
        public String toString() {
            return "J";
        }
    },
    QUEEN
    {
        @Override
        public String toString() {
            return "Q";
        }
    },
    KING
    {
        @Override
        public String toString() {
            return "K";
        }
    },
    ACE
    {
        @Override
        public String toString() {
            return "A";
        }
    };


    public final boolean less(final Rank other)
    {
        return this.compareTo(other) < 0;
    }

    public final boolean more(final Rank other)
    {
        return this.compareTo(other) > 0;
    }

    public abstract String toString();
}
