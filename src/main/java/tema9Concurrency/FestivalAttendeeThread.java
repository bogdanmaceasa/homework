package tema9Concurrency;

public class FestivalAttendeeThread extends Thread{

    private FestivalGate festivalGate;

    @Override
    public void run() {

        for ( int i = 0; i<20; i++){
            festivalGate.counterIncrement(TicketType.getRandomTicket());
        }

    }

}
