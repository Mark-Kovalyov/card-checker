package kovalev.cardchecker;

public class CheckResult {

    private boolean isCorrect;

    private String desc;

    public CheckResult() {

    }

    public CheckResult(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public CheckResult(boolean isCorrect, String desc) {
        this.isCorrect = isCorrect;
        this.desc = desc;
    }


    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
