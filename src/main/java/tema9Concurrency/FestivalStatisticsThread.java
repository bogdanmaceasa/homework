package tema9Concurrency;

import lombok.SneakyThrows;

public class FestivalStatisticsThread extends Thread {

    private FestivalGate festivalGate;

    FestivalStatisticsThread(FestivalGate festivalGate){
        this.festivalGate=festivalGate;
    }

    @SneakyThrows
    @Override
    public void run() {

        if (this.festivalGate.getCheckinCounter().keySet()!=null){
            System.out.println(this.festivalGate);
        }

    }

}
