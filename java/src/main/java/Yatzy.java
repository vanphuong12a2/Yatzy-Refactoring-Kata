import dice.Dice;

import static rule.ScoringRule.Chance;
import static rule.ScoringRule.Fives;
import static rule.ScoringRule.FourOfAKind;
import static rule.ScoringRule.Fours;
import static rule.ScoringRule.FullHouse;
import static rule.ScoringRule.LargeStraight;
import static rule.ScoringRule.Ones;
import static rule.ScoringRule.Pair;
import static rule.ScoringRule.Sixes;
import static rule.ScoringRule.SmallStraight;
import static rule.ScoringRule.ThreeOfAKind;
import static rule.ScoringRule.Threes;
import static rule.ScoringRule.TwoPairs;
import static rule.ScoringRule.Twos;
import static rule.ScoringRule.Yatzy;

class Yatzy {

    static int chance(int... dice) {
        return new Dice(dice).score(Chance);
    }

    static int yatzy(int... dice) {
        return new Dice(dice).score(Yatzy);
    }

    static int ones(int... dice) {
        return new Dice(dice).score(Ones);
    }

    static int twos(int... dice) {
        return new Dice(dice).score(Twos);
    }

    static int threes(int... dice) {
        return new Dice(dice).score(Threes);
    }

    static int fours(int... dice) {
        return new Dice(dice).score(Fours);
    }

    static int fives(int... dice) {
        return new Dice(dice).score(Fives);
    }

    static int sixes(int... dice) {
        return new Dice(dice).score(Sixes);
    }

    static int pair(int... dice) {
        return new Dice(dice).score(Pair);
    }

    static int twoPairs(int... dice) {
        return new Dice(dice).score(TwoPairs);
    }

    static int threeOfAKind(int... dice) {
        return new Dice(dice).score(ThreeOfAKind);
    }

    static int fourOfAKind(int... dice) {
        return new Dice(dice).score(FourOfAKind);
    }

    static int smallStraight(int... dice) {
        return new Dice(dice).score(SmallStraight);
    }

    static int largeStraight(int... dice) {
        return new Dice(dice).score(LargeStraight);
    }

    static int fullHouse(int... dice) {
        return new Dice(dice).score(FullHouse);
    }
}