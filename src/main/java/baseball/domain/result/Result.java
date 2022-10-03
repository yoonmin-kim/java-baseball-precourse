package baseball.domain.result;

public abstract class Result {

    private int strike;
    private int ball;
    private State state = State.NOTHING;
    private String result = state.getDescription();

    public abstract String result();

    protected boolean isNothing() {
        return state.isNothing();
    }

    protected String getDescription() {
        return state.getDescription();
    }

    protected int getStrike() {
        return strike;
    }

    protected void setStrike(int strike) {
        this.strike = strike;
    }

    protected int getBall() {
        return ball;
    }

    protected void setBall(int ball) {
        this.ball = ball;
    }

    protected void setState(State state) {
        this.state = state;
    }
}
