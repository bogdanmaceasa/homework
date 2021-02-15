package tema9Concurrency;

import java.util.List;
import java.util.Random;

public enum TicketType {

     FULL("Full ticket"),
     FREE("Free pass"),
     VIP("VIP pass"),
     ONEDAY("One-Day pass"),
     ONEDAYVIP("One-Day VIP pass");

     private final String name;
     private static final List<TicketType> TICKET_TYPE_LIST = List.of(values());
     private static final int SIZE = TICKET_TYPE_LIST.size();
     private static final Random RANDOM = new Random();

     TicketType(String s){
          name = s;
     }

     public static TicketType getRandomTicket(){
         return TICKET_TYPE_LIST.get(RANDOM.nextInt(SIZE));
     }

     public String getName(){
          return name;
     }

     public static List<TicketType> getVALUES() {
          return TICKET_TYPE_LIST;
     }
}
