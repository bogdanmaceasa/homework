package tema4.atm;

import lombok.ToString;

import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class Card extends BankAccount{

    private final Date expirationDate;
    private String ownerName;
    private final String cardNumber;
    private int PIN=1234;

    public Card(Date expirationDate, String ownerName, String cardNumber, String iban) {
        super(iban);
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
    }

    public void changePIN ( int pin) {
        this.PIN = pin;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return PIN == card.PIN && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(ownerName, card.ownerName) && Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationDate, ownerName, cardNumber, PIN);
    }

    @Override
    public String toString() {
        return super.toString() +"\nCard Details\n" +
                "expirationDate=" + expirationDate +
                "\nownerName='" + ownerName + '\'' +
                "\ncardNumber='" + cardNumber;
    }


    //    public String generateRandomCardNumber (){
//        Random random = new Random();
//    }

}
