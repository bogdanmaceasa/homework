package tema4.atm;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class User {

    private Card[] cards = new Card[0];
    private BankAccount[] bankAccounts = new BankAccount[1];
    private final String userName;
    private String password;
    private int numberOfCards = 0, numberOfBankAccounts = 0;
    private boolean isAuthenticated = false, isLocked = false;
    private String firstName, lastName;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = firstName + lastName;
        this.password = password;
        this.bankAccounts[0] = new BankAccount("123123uy234v12");
    }

    public void addCard(Date expirationDate, String ownerName, String cardNumber, String iban) {
        if (isAuthenticated) {
            this.cards = addCardToArray(cards, new Card(expirationDate, ownerName, cardNumber, iban));
            this.numberOfCards++;
        } else System.out.println("Please login before performing this action.");
    }

    public void addBankAccount(String IBAN, double balance, Card attachedCardNumber) {
        if (isAuthenticated) {
            this.bankAccounts = addBankAccountToArray(bankAccounts, new BankAccount(IBAN, balance, attachedCardNumber));
            this.numberOfBankAccounts++;
        } else System.out.println("Please login before performing this action.");
    }

    public void listCards() {
        if (this.cards.length == 0)
            System.out.println("No added cards");
        else
            for (Card card : this.cards) {
                System.out.println(card.toString());
            }
    }

    public void listBankAccounts() {
        for (BankAccount bankaccount : this.bankAccounts) {
            System.out.println(bankaccount.toString());
        }
    }

    public double showBalance(BankAccount bankAccount){
        return bankAccount.showBalance();
    }

    public boolean login(String userName, int loginAttempts) {
        System.out.println("Hello! " + this.userName + " please enter your password: ");
        return isAuthenticated = passwordChecker(loginAttempts);
    }

    public boolean passwordChecker(int count) {

        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        count = count - 1;

        if (this.password.equals(pass)) {
            System.out.println("Login successful!");
            return true;
        } else if (count == 0) {
            System.out.println("You have entered the incorrect password too many times, your account is blocked!");
            this.isLocked = true;
            return false;
        } else {
            System.out.println("Password incorrect, please enter the password again. You have " + count + " attempts remaining!");
            passwordChecker(count);
        }
        return true;
    }

    public void logout() {
        System.out.println("You have been logged out!");
        isAuthenticated = false;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getAuthenticationStatus() {
        return isAuthenticated;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    private static Card[] addCardToArray(Card[] array1, Card a) {

        Card[] array2 = new Card[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

    private static BankAccount[] addBankAccountToArray(BankAccount[] array1, BankAccount a) {

        BankAccount[] array2 = new BankAccount[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

}
