package tema7;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@ToString
public class RaceResults<T> {

    private T t;
    private List<String> shootingResult = new ArrayList<>();
    private LocalTime time;
    private LocalTime finalTime;


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