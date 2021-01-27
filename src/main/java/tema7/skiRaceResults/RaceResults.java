package tema7.skiRaceResults;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@ToString
public class RaceResults<T> {

    private T t;
    private List<String> shootingResult = new ArrayList<>();
    private LocalTime time;
    private LocalTime finalTime;
    private int penalty;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm'min':ss'sec'");

    private String timeToString;

//
//    public RaceResults(T t, List<String> shootingResult,LocalTime time ){
//        this.t = t;
//        this.shootingResult = shootingResult;
//        this.time = time;
//
//    }

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

    public String setTimeToString(LocalTime timeToString){
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

    public String getTimeToString(){
        return timeToString;
    }

    //    public LocalTime calculateFinalTime() {
//        int penalty = 0;
//        for (String string : this.shootingResult) {
//            for (int i = 0; i < string.length(); i++) {
//                if (string.charAt(i) == 'o') {
//                    penalty += 1;
//                }
//            }
//        }
//        this.finalTime = this.time.plusSeconds(penalty * 10);
//        return this.finalTime;
//    }

}