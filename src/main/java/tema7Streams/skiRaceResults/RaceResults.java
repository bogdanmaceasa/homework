package tema7Streams.skiRaceResults;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@ToString
public class RaceResults<T> implements Serializable {

    private T t;
    private List<String> shootingResult = new ArrayList<>();
    private LocalTime time;
    private LocalTime finalTime;
    private int penalty;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm'min':ss'sec'");

    public void setT(T t) {
        this.t = t;
    }

    public void setShootingResult(List<String> shootingResult) {
        this.shootingResult = shootingResult;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setFinalTime(LocalTime finalTime) {
        this.finalTime = finalTime;
    }

    public void setPenalty(int penalty) { this.penalty = penalty;}

    public String timeToString(LocalTime timeToString){
        return timeToString.format(formatter);
    }

    public T getT() {
        return t;
    }

    public List<String> getShootingResult() {
        return shootingResult;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalTime getFinalTime() {
        return finalTime;
    }

    public int getPenalty() { return penalty; }

}

