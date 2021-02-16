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

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < this.queueSize; i++) {
            //we assume that each attendee that passes through the gate has a random ticket, which will be checked at the gate
            sleep(10); // time required for each person to actually pass through the gate
            this.festivalGate.counterIncrement(TicketType.getRandomTicket());
        }
    }
}
