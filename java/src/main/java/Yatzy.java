import java.util.Arrays;
import java.util.OptionalInt;

class Yatzy {

    private static final int[] DICE = {1, 2, 3, 4, 5, 6};

    static int chance(int... dice) {
        return Arrays.stream(dice).sum();
    }

    static int yatzy(int... dice) {
        if (isYatzy(dice)) return 50;
        return 0;
    }

    static int ones(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 1).sum();
    }

    static int twos(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 2).sum();
    }

    static int threes(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 3).sum();
    }

    static int fours(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 4).sum();
    }

    static int fives(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 5).sum();
    }

    static int sixes(int... dice) {
        return Arrays.stream(dice).filter(die -> die == 6).sum();
    }

    static int pair(int... dice) {
        OptionalInt maxPairValue = Arrays.stream(DICE)
                .filter(die -> hasPair(dice, die)).max();
        if (maxPairValue.isPresent()) return maxPairValue.getAsInt() * 2;
        return 0;
    }

    static int twoPair(int... dice) {
        int[] pairs = Arrays.stream(DICE)
                .filter(die -> hasPair(dice, die)).toArray();
        if (pairs.length == 2) return (pairs[0] + pairs[1]) * 2;
        return 0;
    }

    static int fourOfAKind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private static boolean isYatzy(int... dice) {
        return Arrays.stream(dice).distinct().count() == 1;
    }

    private static boolean hasPair(int[] dice, int die) {
        return Arrays.stream(dice).filter(d -> d == die).count() >= 2;
    }
}



