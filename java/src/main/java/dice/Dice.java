package dice;

import rule.ScoringRule;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Dice {
    private static final int[] DICE = {1, 2, 3, 4, 5, 6};
    private final int[] dice;

    public Dice(int... dice) {
        this.dice = dice;
    }

    public int[] getPairs() {
        IntPredicate hasPair = die -> Arrays.stream(this.dice).filter(d -> d == die).count() >= 2;
        return Arrays.stream(DICE)
                .filter(hasPair)
                .toArray();
    }

    public int[] getThrees() {
        IntPredicate hasThreeOfAKind = die -> Arrays.stream(this.dice).filter(d -> d == die).count() >= 3;
        return Arrays.stream(DICE)
                .filter(hasThreeOfAKind).toArray();
    }

    public int[] getFours() {
        IntPredicate hasFourOfAKind = die -> Arrays.stream(this.dice).filter(d -> d == die).count() >= 4;
        return Arrays.stream(DICE)
                .filter(hasFourOfAKind).toArray();
    }

    public boolean isYatzy() {
        return Arrays.stream(this.dice).distinct().count() == 1;
    }

    public int sum() {
        return Arrays.stream(this.dice).sum();
    }

    public int score(ScoringRule scoringRule) {
        return scoringRule.score().apply(this);
    }

    public int getSum(int i) {
        return Arrays.stream(this.dice).filter(die -> die == i).sum();
    }

    public boolean isSmallStraight() {
        return Arrays.stream(this.dice).filter(die -> die != 6).distinct().count() == 5;
    }

    public boolean isLargeStraight() {
        return Arrays.stream(this.dice).filter(die -> die != 1).distinct().count() == 5;
    }
}
