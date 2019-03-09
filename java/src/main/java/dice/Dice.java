package dice;

import rule.ScoringRule;

import java.util.Arrays;
import java.util.function.IntPredicate;

import static dice.DieValue.FIVE;
import static dice.DieValue.FOUR;
import static dice.DieValue.ONE;
import static dice.DieValue.SIX;
import static dice.DieValue.THREE;
import static dice.DieValue.TWO;

public class Dice {
    private static final int[] ALL_POSSIBLE_DICE = new int[]{ONE, TWO, THREE, FOUR, FIVE, SIX};
    private final int[] dice;

    public Dice(int... dice) {
        this.dice = dice;
    }

    public int score(ScoringRule scoringRule) {
        return scoringRule.score().apply(this);
    }

    public boolean isYatzy() {
        return Arrays.stream(this.dice).distinct().count() == 1;
    }

    public int sumAll() {
        return Arrays.stream(this.dice).sum();
    }

    public int sumAValue(int dieValue) {
        return Arrays.stream(this.dice).filter(die -> die == dieValue).sum();
    }

    public boolean isSmallStraight() {
        return Arrays.stream(this.dice).filter(die -> die != SIX).distinct().count() == this.dice.length;
    }

    public boolean isLargeStraight() {
        return Arrays.stream(this.dice).filter(die -> die != ONE).distinct().count() == this.dice.length;
    }

    public int[] getRepeatedDice(int times) {
        IntPredicate isRepeated = die -> Arrays.stream(this.dice).filter(d -> d == die).count() >= times;
        return Arrays.stream(ALL_POSSIBLE_DICE)
                .filter(isRepeated)
                .toArray();
    }

    public boolean isFullHouse() {
        return this.getRepeatedDice(3).length == 1
                && this.getRepeatedDice(2).length == 2;
    }
}
