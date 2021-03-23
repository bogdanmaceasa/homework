package work9Concurrency;

import java.util.List;
import java.util.Random;

public enum TicketType {

    FULL("Full ticket"),
    FREE("Free pass"),
    VIP("VIP pass"),
    ONEDAY("One-Day pass"),
    ONEDAYVIP("One-Day VIP pass");

    private final String name;
    //TICKET_LIST = list of 30% FULL, 30% ONEDAY, 20% VIP, 10% FREE, 10% ONEDAYVIP
    private static final List<TicketType> TICKET_LIST = List.of(FULL, FULL, FULL, ONEDAY, ONEDAY, ONEDAY, VIP, VIP, FREE, ONEDAYVIP);
    private static final int SIZE = TICKET_LIST.size();
    private static final List<TicketType> TICKET_TYPE_LIST = List.of(values());
    private static final Random RANDOM = new Random();

    TicketType(String s) {
        name = s;
    }

    public static TicketType getRandomTicket() {
        return TICKET_LIST.get(RANDOM.nextInt(SIZE));
    }

    public String getName() {
        return name;
    }

    public static List<TicketType> getVALUES() {
        return TICKET_TYPE_LIST;
    }

}
