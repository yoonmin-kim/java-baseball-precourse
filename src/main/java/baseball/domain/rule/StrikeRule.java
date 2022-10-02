package baseball.domain.rule;

public class StrikeRule implements Rule {

    @Override
    public int count(String input, String randomValue) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result = isStrikeThenAddCount(input, randomValue, result, i);
        }
        return result;
    }

    private int isStrikeThenAddCount(String input, String randomValue, int result, int i) {
        if (input.charAt(i) == randomValue.charAt(i)) {
            result++;
        }
        return result;
    }
}
