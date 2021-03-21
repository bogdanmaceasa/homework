package tema4ATM.atm;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BankAccount {

    private final String IBAN;
    private double balance;
    private Card[] attachedCardNumbers = {}; // each bank account can have one or more cards attached.
    int cardsAttachedToAccount = 0;

    public BankAccount() {
        this.IBAN = "RO09 JAVA " + generateRandomIBAN();
    }

    public void addBalance(double balance) {
        this.balance += balance;
        System.out.println("Current balance is: $" + balance);
    }

    public void withdrawMoney(double balance) {
        if (this.balance >= balance) {
            this.balance -= balance;
            System.out.println(balance + "$ have been withdrawn");
        } else System.out.println("insufficient funds");
    }

    public void pay(double balance) {
        if (this.balance >= balance) {
            this.balance -= balance;
            System.out.println("paid : $ " + balance);
        } else System.out.println("insufficient funds");
    }

    public void attachCard(Card card) {
        attachedCardNumbers = addCardToArray(attachedCardNumbers, card);
        cardsAttachedToAccount++;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double showBalance() {
        return this.balance;
    }

    public String listCards() {
        String outputString = "";
        if (this.attachedCardNumbers.length == 0)
            return "No cards attached to this account";
        else
            for (Card card : this.attachedCardNumbers) {
                outputString = outputString + card.toString() + "\n\n";
            }
        return outputString;
    }

    @Override
    public String toString() {
        return "Bank Account Details\n------------------------------\n" + "IBAN='" + IBAN + '\'' + ", balance=" + balance + "\n" + listCards();
    }

    public Card[] cardsForBankAccount() {
        return this.attachedCardNumbers;
    }

    private static Card[] addCardToArray(Card[] array1, Card a) {
        Card[] array2 = new Card[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

    private String generateRandomIBAN() {
        String digits = "0123456789";
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 12; i++) {
            int index = (int) ((digits.length() - 1) * Math.random());
            s.append(digits.charAt(index));
        }
        return s.toString();
    }
}
