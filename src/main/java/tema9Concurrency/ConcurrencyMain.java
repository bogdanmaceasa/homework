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
//        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService executorServiceScheduled = Executors.newSingleThreadScheduledExecutor();

        try {
            Runnable printGateStatistics = () -> {
                System.out.println(gate.toString());
            };

            Future<?> festivalAttendeesExecutor = executorService.submit(festivalAttendee::start);
            ScheduledFuture<?> gateStatisticsScheduler = executorServiceScheduled.scheduleWithFixedDelay(printGateStatistics, 1, 1, TimeUnit.SECONDS);

            while (!festivalAttendeesExecutor.isDone()) {
                gateStatisticsScheduler.get();
            }

        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        } finally {
            System.out.println("Shutting down!");
            executorServiceScheduled.shutdown();
            executorService.shutdown();

        }
    }
}
