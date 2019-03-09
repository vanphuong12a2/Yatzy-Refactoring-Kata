package rule;

import dice.Dice;

import java.util.Arrays;
import java.util.function.Function;

public enum ScoringRule {

    Chance, Yatzy, Ones, Twos, Threes, Fours, Fives, Sixes, Pair, TwoPairs,
    ThreeOfAKind, FourOfAKind, SmallStraight, LargeStraight, FullHouse;

    public Function<Dice, Integer> score() {
        switch (this) {
            case Chance:
                return Dice::sum;
            case Yatzy:
                return (dice) -> {
                    if (dice.isYatzy()) return 50;
                    return 0;
                };
            case Ones:
                return dice -> dice.getSum(1);
            case Twos:
                return dice -> dice.getSum(2);
            case Threes:
                return dice -> dice.getSum(3);
            case Fours:
                return dice -> dice.getSum(4);
            case Fives:
                return dice -> dice.getSum(5);
            case Sixes:
                return dice -> dice.getSum(6);
            case Pair:
                return dice -> {
                    int[] pairs = dice.getPairs();
                    if (pairs.length > 0) return Arrays.stream(pairs).max().getAsInt() * 2;
                    return 0;
                };

            case TwoPairs:
                return dice -> {
                    int[] pairs = dice.getPairs();
                    if (pairs.length == 2) return (pairs[0] + pairs[1]) * 2;
                    return 0;
                };
            case ThreeOfAKind:
                return dice -> {
                    int[] threes = dice.getThrees();
                    if (threes.length == 1) return threes[0] * 3;
                    return 0;
                };
            case FourOfAKind:
                return dice -> {
                    int[] fours = dice.getFours();
                    if (fours.length == 1) return fours[0] * 4;
                    return 0;
                };
            case SmallStraight:
                return dice -> {
                    if (dice.isSmallStraight()) return 15;
                    return 0;
                };
            case LargeStraight:
                return dice -> {
                    if (dice.isLargeStraight()) return 20;
                    return 0;
                };
            case FullHouse:
                return dice -> {
                    if (dice.getThrees().length == 1 && dice.getPairs().length == 2)
                        return dice.sum();
                    return 0;
                };
            default:
                return (dice) -> 0;
        }
    }
}
