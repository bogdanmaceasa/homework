package tema9Concurrency;

import lombok.SneakyThrows;
import lombok.ToString;

@ToString
public class FestivalAttendeeThread extends Thread {

    private FestivalGate festivalGate;
    private int queueSize;

    FestivalAttendeeThread(FestivalGate festivalGate, int queueSize) {
        this.festivalGate = festivalGate;
        this.queueSize = queueSize;
    }

    FestivalAttendeeThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }


    //  needed for V1 of build
//    @SneakyThrows
//    @Override
//    public void run() {
//        for (int i = 0; i < this.queueSize; i++) {
//            //we assume that each attendee that passes through the gate has a random ticket, which will be checked at the gate
//            Thread.sleep(100); // time required for each person to actually pass through the gate
//            TicketType randomTicket = TicketType.getRandomTicket();
//            this.festivalGate.counterIncrement(randomTicket);
//        }
//    }
////  needed for V2 of build
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Thread START");
        this.festivalGate.counterIncrement(TicketType.getRandomTicket());
    }

}
