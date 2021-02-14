package tema8Java8.transaction;


import lombok.Data;

@Data
public class Transaction {

    private final int value;
    private final int year;
    private final Trader trader;

}
