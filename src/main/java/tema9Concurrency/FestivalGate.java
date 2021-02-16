package tema9Concurrency;

import java.util.HashMap;
import java.util.Map;

public class FestivalGate {

    private final String name;
    private Map<TicketType, Integer> checkinCounter = new HashMap<>();
    private boolean available = false;

    FestivalGate(String name) {
        this.name = name;
    }

    synchronized void counterIncrement(TicketType ticketType) {

        if (this.checkinCounter.containsKey(ticketType)) {
            int occ = this.checkinCounter.get(ticketType);
            this.checkinCounter.put(ticketType, ++occ);
        } else {
            this.checkinCounter.put(ticketType, 1);
        }
    }

    @Override
    public synchronized String toString() {
        String out = "";
        int sum = 0;
        for (TicketType ticketType : this.checkinCounter.keySet()) {
            out = out.concat("\n" + this.checkinCounter.get(ticketType) + " people entered with " + ticketType.getName());
            sum += this.checkinCounter.get(ticketType);
        }
        return "\n" + "=========================================\n" + "Gate: " + name + "\n" + "Total entries: " + sum + out;
    }

    public Map<TicketType, Integer> getCheckinCounter() {
        return checkinCounter;
    }
}
