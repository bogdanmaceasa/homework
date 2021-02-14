package tema4ATM.atm;

import lombok.ToString;
import java.util.Objects;
import java.util.Scanner;

@ToString
public class User {

    private Card[] cards = new Card[0]; // each user has a list of cards attached to his account. these are not automatically linked to a bank account.
    private BankAccount[] bankAccounts = new BankAccount[1]; // each ATM user has at least one Bank Account - generated automatically with his account.
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
        this.bankAccounts[0] = new BankAccount();
        this.numberOfBankAccounts++;
    }

    public User(String firstName, String lastName, String password, BankAccount[] bankAccounts, Card[] cards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = firstName + lastName;
        this.password = password;
        this.numberOfBankAccounts = bankAccounts.length;
        this.numberOfCards = cards.length;
        this.bankAccounts = bankAccounts;
        this.cards = cards;
    }

    public void addCard() {
        int i = 0;

        if (numberOfBankAccounts > 1) {
            System.out.println("Select one of your bank accounts to attach your bank account to:");
            for (BankAccount bankAccount : this.bankAccounts) {
                i++;
                System.out.println(i + ") " + bankAccount.toString());
            }
            System.out.println("\n");
        } else System.out.println("You can only add a card for account: \n1) " + this.bankAccounts[0].toString() + "\n\n");

        System.out.println("Please type the account you want to add the card for");
        Scanner sc = new Scanner(System.in);
        byte b = sc.nextByte();

        if ( b <= numberOfBankAccounts){
            Card newCard = new Card(this.firstName+" "+this.lastName);
            this.bankAccounts[b-1].attachCard(newCard);
            this.cards = addCardToArray(cards, newCard);
            this.numberOfCards++;
        }

    }

    public void addBankAccount() {
        if (isAuthenticated) {
            this.bankAccounts = addBankAccountToArray(bankAccounts, new BankAccount());
            this.numberOfBankAccounts++;
        } else System.out.println("Please login before performing this action.");
    }

    public void listCards() {
        if (this.cards.length == 0)
            System.out.println("None");
        else
            for (Card card : this.cards) {
                System.out.println("\n" + card.toString());
            }
    }

    public void printBankAccounts() {
        for ( BankAccount bankAccount : this.bankAccounts){
            System.out.println(bankAccount.toString());
        }
    }

    public BankAccount[] bankAccountsForUser() {
        return this.bankAccounts;
    }

    public boolean login(String userName, int loginAttempts) {
        System.out.println("Hello! " + userName + " please enter your password: ");
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

    public String getUserName() {
        return userName;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public void changePassword (String password){
       this.password = password;
    }

    public Card[] getCards() {
        return cards;
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
