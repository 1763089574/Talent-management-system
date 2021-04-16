package net.suncaper.demo.common.domain.extend;

public class WorkerCompare {
    private String name;
    private String countMis;
    private String countAch;
    private String countLate;
    private String score;
    private String Evaluate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountMis() {
        return countMis;
    }

    public void setCountMis(String countMis) {
        this.countMis = countMis;
    }

    public String getCountAch() {
        return countAch;
    }

    public void setCountAch(String countAch) {
        this.countAch = countAch;
    }

    public String getCountLate() {
        return countLate;
    }

    public void setCountLate(String countLate) {
        this.countLate = countLate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(String evaluate) {
        Evaluate = evaluate;
    }

    public WorkerCompare() {
    }

    public WorkerCompare(String name, String countMis, String countAch, String countLate, String score, String evaluate) {
        this.name = name;
        this.countMis = countMis;
        this.countAch = countAch;
        this.countLate = countLate;
        this.score = score;
        Evaluate = evaluate;
    }
}
