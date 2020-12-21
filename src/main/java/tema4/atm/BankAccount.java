package tema4.atm;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class BankAccount {

    private final String IBAN;
    private double balance;
    Card[] attachedCardNumbers;
    int cardsAttachedToAccount=0;

    public BankAccount(String iban) {
        this.IBAN = "RO09 JAVA " + iban;
    }

    public BankAccount(String IBAN, double balance, Card attachedCardNumber) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.attachedCardNumbers[0] = attachedCardNumber;
    }

    public void addBalance(double balance) {
        this.balance += balance;
        System.out.println("Current balance is: $"+ this.balance);
    }

    public double showBalance() {
        return balance;
    }

    public void withdrawMonet(double balance){
        if ( this.balance>=balance){
            this.balance-=balance;
            System.out.println(this.balance + "$ have been withdrawn");
        }
        else System.out.println("insufficient balance");
    }

    public void attachCard ( Card card){
        attachedCardNumbers = addCardToArray(attachedCardNumbers, card);
        cardsAttachedToAccount++;
    }

//    @Override
//    public String toString() {
//        return "BankAccount\n" +
//                "IBAN='" + IBAN + "\n" +
//                ", balance=" + balance ;
//    }

    private static Card[] addCardToArray(Card[] array1, Card a) {

        Card[] array2 = new Card[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

}
