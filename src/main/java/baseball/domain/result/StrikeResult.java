package baseball.domain.result;

public class StrikeResult extends Result {

    private Result result;

    public StrikeResult(Result result) {
        this.result = result;
        setState(State.STRIKE);
    }

    @Override
    public String result() {
        String strikeResult = result.result();
        if (result.isNothing()) {
            return nothingStrikeResult(strikeResult);
        }
        return notNothingStrikeResult(strikeResult);
    }

    @Override
    protected int getStrike() {
        return result.getStrike();
    }

    @Override
    protected void setStrike(int strike) {
        result.setStrike(strike);
    }

    private String notNothingStrikeResult(String strikeResult) {
        if (getStrike() != 0) {
            return strikeResult + " " + getStrike() + getDescription();
        }
        return strikeResult;
    }

    private String nothingStrikeResult(String strikeResult) {
        if (getStrike() != 0) {
            return getStrike() + getDescription();
        }
        return strikeResult;
    }

}
