package tema9Concurrency;

import java.util.HashMap;
import java.util.Map;

public class FestivalGate {


    private Map<TicketType,Integer> checkinCounter = new HashMap<>();
//    private List<TicketType> values = TicketType.getVALUES();

    void counterIncrement(TicketType ticketType){
            int check = checkinCounter.get(ticketType);
            checkinCounter.put(ticketType,check++);
       }


}
