package work8Java8;

import work8Java8.transaction.Trader;
import work8Java8.transaction.Transaction;

import java.util.stream.Stream;

public class Tema8Main {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Lisbon");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Paris");
        Trader bill = new Trader("Bill", "Cambridge");
        Trader andrew = new Trader("Andrew", "Cambridge");

        Transaction transaction1 = new Transaction(1000, 2021, raoul);
        Transaction transaction2 = new Transaction(1500, 2021, mario);
        Transaction transaction3 = new Transaction(100, 2020, alan);
        Transaction transaction5 = new Transaction(1200, 2021, brian);
        Transaction transaction4 = new Transaction(1200, 2021, raoul);
        Transaction transaction6 = new Transaction(1300, 2021, brian);
        Transaction transaction7 = new Transaction(110, 2021, bill);
        Transaction transaction8 = new Transaction(150, 2021, andrew);
        Transaction transaction9 = new Transaction(155, 2020, bill);

        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction5, transaction6, transaction4, transaction7, transaction8, transaction9};

//Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("\nTransactions in 2011:");
        Stream.of(transactions)
                .filter(transaction -> transaction.getYear() == 2021)
                .distinct()
                .sorted((tr1, tr2) -> tr1.getValue() - tr2.getValue())
                .forEach(System.out::println);

//Find all traders from Cambridge and sort them by name.
        System.out.println("\nTraders in Cambridge are:");
        Stream.of(transactions)
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                .map(s -> s.getTrader().getName())
                .forEach(System.out::println);

//Are any traders based in Milan?

        System.out.println("\nTraders in Milan are:");
        Stream.of(transactions)
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                .map(s -> s.getTrader().getName())
                .forEach(System.out::println);


//Find all traders from Cambridge and sort them by name.
        System.out.println("\nTransactions values from the traders living in Cambridge are:");
        Stream.of(transactions)
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted((tr1, tr2) -> tr1.getValue() - tr2.getValue())
                .mapToInt(Transaction::getValue)
                .forEach(System.out::println);

//What are all the unique cities where the traders work?
        System.out.println("\nWhat are all the unique cities where the traders work?:");
        Stream.of(transactions)
                .sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
                .map(s -> s.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

//Return a string of all traders names sorted alphabetically.
        System.out.println("\nTraders' names sorted alphabetically:");
        Stream.of(transactions)
                .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                .map(s -> s.getTrader().getName())
                .distinct()
                .forEach(System.out::println);

//Whats the highest value of all the transactions?
        System.out.println("\nWhats the highest value of all the transactions?:");
//        int max =
        Stream.of(transactions)
                .sorted((tr1, tr2) -> tr2.getValue() - tr1.getValue())
                .map(Transaction::getValue)
                .findFirst()
                .ifPresent(System.out::println);
//        System.out.println(max);


//Find the transaction with the smallest value.
        System.out.println("\nFind the transaction with the smallest value:");
//        int min =
        Stream.of(transactions)
                .sorted((tr1, tr2) -> tr1.getValue() - tr2.getValue())
                .map(Transaction::getValue)
                .findFirst()
                .ifPresent(System.out::println);
//        System.out.println(min);
    }

}

