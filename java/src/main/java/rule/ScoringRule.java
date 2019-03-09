package rule;

import dice.Dice;

import java.util.Arrays;
import java.util.function.Function;

import static dice.DieValue.FIVE;
import static dice.DieValue.FOUR;
import static dice.DieValue.ONE;
import static dice.DieValue.SIX;
import static dice.DieValue.THREE;
import static dice.DieValue.TWO;

public enum ScoringRule {

    Chance, Yatzy, Ones, Twos, Threes, Fours, Fives, Sixes, Pair, TwoPairs,
    ThreeOfAKind, FourOfAKind, SmallStraight, LargeStraight, FullHouse;

    public Function<Dice, Integer> score() {
        return (dice -> {
            switch (this) {
                case Chance:
                    return dice.sumAll();
                case Yatzy:
                    return dice.isYatzy() ? 50 : 0;
                case Ones:
                    return dice.sumAValue(ONE);
                case Twos:
                    return dice.sumAValue(TWO);
                case Threes:
                    return dice.sumAValue(THREE);
                case Fours:
                    return dice.sumAValue(FOUR);
                case Fives:
                    return dice.sumAValue(FIVE);
                case Sixes:
                    return dice.sumAValue(SIX);
                case Pair: {
                    int[] pairs = dice.getRepeatedDice(2);
                    return (pairs.length > 0) ? Arrays.stream(pairs).max().getAsInt() * 2 : 0;
                }
                case TwoPairs: {
                    int[] pairs = dice.getRepeatedDice(2);
                    return pairs.length == 2 ? (pairs[0] + pairs[1]) * 2 : 0;
                }
                case ThreeOfAKind: {
                    int[] threes = dice.getRepeatedDice(3);
                    return threes.length == 1 ? threes[0] * 3 : 0;
                }
                case FourOfAKind: {
                    int[] fours = dice.getRepeatedDice(4);
                    return fours.length == 1 ? fours[0] * 4 : 0;
                }
                case SmallStraight:
                    return dice.isSmallStraight() ? dice.sumAll() : 0;
                case LargeStraight:
                    return dice.isLargeStraight() ? dice.sumAll() : 0;
                case FullHouse:
                    return dice.isFullHouse() ? dice.sumAll() : 0;
                default:
                    return 0;
            }
        });
    }
}
