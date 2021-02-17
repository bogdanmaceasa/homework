package tema9Concurrency;

/*
Festival Statistics

Every Festival has a gate, where people have to show their tickets.
Write an application where every person is represented by a special Thread that is instantiated with random ticket data.
Possible ticket types: full, full-vip, free-pass, one-day, one-day-vip
FestivalGate gate = new FestivalGate();
TicketType ticketType = // this should be enum value randomly generated.
FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
Every attendee validates the ticket, and the ticket-data is kept is a queue.
Meanwhile, every 5 seconds a FestivalStatisticsThread wakes up and reads the new data from the gate and generates statistics:

e.g
100 people entered
57 people have full tickets
30 have free passes
3 have full VIP passes
10 have one-day passes
0 have one-day VIP passes

FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
statsThread.start();

Note:
There can be only one statsThread
Stats thread reads from the gate-data only if it's not empty
There can be unlimited attendee threads
Attendee threads can add data to the gate regardless of the gate data being empty or full.
The app must randomly generate multiple attendee threads - at least 100
Use Thread.sleep in both thread types.
 */

import lombok.extern.log4j.Log4j;

import java.util.concurrent.*;

@Log4j
public class ConcurrencyMain {

    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate("Main Gate");
        FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(gate, 100);
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(1000);


        try {

//  ========================= V1 ==========================
//      using a festival attendee thread that has a
//      multiple ticket entries ( i.e. new FestivalAttendeeThread(gate, 100) )
//      REQUIRES V1 from StatisticsThread run() AND FestivalAttendee run()

//          start the festivalAttendee thread via executor service
            executorService.submit(festivalAttendee::start);
            System.out.println("WTF");

//          runnable for starting the the statsthread
            Runnable printGateStatistics = () -> {
                System.out.println("WTF4");
                statsThread.run();
            };
            System.out.println("WTF1");

            executorService1.submit(printGateStatistics);
            System.out.println("WTF2");
            while (festivalAttendee.isAlive()) {
                System.out.println("WTF3");
                statsThread.run();
            }
//  ========================== V2 ==========================
//      using a instance with a single ticket,
//      instantiated any number of times via a a for-loop
//      REQUIRES V2 from StatisticsThread run() AND FestivalAttendee run()
//
//            //runnable for starting the the statsthread
//            Runnable printGateStatistics = () -> {
//                System.out.println("WTF4");
//                statsThread.run();
//            };
//
//            // add the runnable to the executorservice
//            executorService2.execute(printGateStatistics);
//
//            // start a lot of attendee instances
//            for (int i = 0; i < 500; i++) {
//                Thread.sleep(10);
//                executorService2.execute(new FestivalAttendeeThread(gate)::start);
//            }
//
//            //once the instances are finished - the stat gets a indication that the previous execution is finished, which stops the stat thread
//            statsThread.setFinished();

//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            executorService1.shutdown();
            executorService.shutdown();
            executorService2.shutdown();
            System.out.println("Shutting down!");

        }
    }
}
