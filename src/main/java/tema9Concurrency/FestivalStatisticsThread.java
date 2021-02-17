package tema9Concurrency;

import lombok.SneakyThrows;

public class FestivalStatisticsThread extends Thread {

    private boolean isFinished = false;
    private FestivalGate festivalGate;


    FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }


    public synchronized void setFinished() {
        this.isFinished = true;
    }

    public synchronized boolean getStatus() {
        return this.isFinished;
    }

////    Needed for V2 of build
//    @SneakyThrows
//    @Override
//    public void run() {
//        while(!getStatus()) {
//            sleep(100);
//            if (this.festivalGate.getCheckinCounter().keySet() != null) {
//                System.out.println(this.festivalGate);
//            }
//        }
//
//    }

//    Needed for V1 of build
    @SneakyThrows
    @Override
    public void run() {
        sleep(100);
        if (this.festivalGate.getCheckinCounter().keySet() != null) {
            System.out.println(this.festivalGate);
        }
    }

}

