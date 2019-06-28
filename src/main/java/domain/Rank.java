package domain;

/**
 * 로또 등수를 의미하는 enum
 */
public enum Rank {
    FIRST(6, 2_000_000_000, false), // 1등
    SECOND(5, 30_000_000, true), // 2등
    THIRD(5, 1_500_000, false), // 3등
    FOURTH(4, 50_000, false), // 4등
    FIFTH(3, 5_000, false), // 5등
    MISS(0, 0, false);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;
    private boolean hasBonus;

    private Rank(int countOfMatch, int winningMoney, boolean hasBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.hasBonus = hasBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}

