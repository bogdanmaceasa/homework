package tema4ATM.atm;

import org.apache.commons.lang3.time.DateUtils;
import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class Card{

    private final Date expirationDate;
    private String ownerName;
    private final String cardNumber;
    private int PIN=1234;

    public Card(String ownerName) {
        Date d = new Date();
        this.expirationDate = DateUtils.addYears(d, 4);
        this.ownerName = ownerName;
        this.cardNumber = "4254" + generateRandomCardNumber();
    }

    public void changePIN ( int pin) {
        this.PIN = pin;
        System.out.println("PIN has been updated!");
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return PIN == card.PIN && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(ownerName, card.ownerName) && Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(expirationDate, ownerName, cardNumber, PIN); }

    @Override
    public String toString() {
        return "Card Details\n" +
                "expires on: " + expirationDate +
                "\nCardholder Name: '" + ownerName + '\'' +
                "\nCard Number: '" + cardNumber +"\'";
    }

    public String generateRandomCardNumber (){
        String digits = "0123456789";
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        for ( int i = 1; i<=3; i++){
            s.append(" ");
            for ( int j = 0 ; j<4; j++){
                int index = (int)((digits.length()-1)* Math.random());
                s.append(digits.charAt(index));
            }
        }
        return s.toString();
    }

}
