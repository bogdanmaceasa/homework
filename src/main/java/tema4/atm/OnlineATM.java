package tema4.atm;


import java.util.Scanner;

/*
  Write an app that simulates an ATM machine.
Requirements:
the app should run indefinitely, allowing customers to enter their cards and withdraw money, deposit money, interrogate sold and change pin.
class design (just a recommendation):
        - User has one or more BankAccounts
        - User has one or more Cards
        - Cards are emitted to a single BankAccount
        - User interacts with Cards via a withdraw(Card), deposit(Card), changePin(Card) or interrogateBalance(Card) action from ATM class based on the option he inputs to the keyboard.
*/
public class OnlineATM {

    public static void main(String[] args) {

        boolean isAuthenticated = false;
        int loginAttempts = 3;
        User authenticatedUser = null;

        User[] atmUsers = new User[2];
        atmUsers[0] = new User("Bogdan", "Maceasa", "test123");
        atmUsers[1] = new User("", "Maceasa", "test456");

        boolean continueActions = true;

        System.out.println("======================== WELCOME TO JAVA ATM ========================");

        while (continueActions) {
            Scanner sc = new Scanner(System.in);
            if (isAuthenticated) {
                System.out.println("Account Options\n_________________________________________\n\nTo list your bank accounts, press 1\nTo list your cards, type 2\n" +
                        "To create a new Bank Account, type 3\nTo generate a new card, type 4\nTo list the balance on your accounts, type 5\nTo make a payment, type 6\n" +
                        "To withdraw money, type 7\nTo deposit money, type 8\nTo change your account password, type 9\nTo logout, type 10");
                byte operation = sc.nextByte();
                switch (operation) {
                    case 1: {
                        authenticatedUser.printBankAccounts();
                        break;
                    }
                    case 2: {
                        System.out.println("Your cards are : ");
                        authenticatedUser.listCards();
                        break;
                    }
                    case 3: {
                        authenticatedUser.addBankAccount();
                        break;
                    }
                    case 4: {
                        authenticatedUser.addCard();
                        break;
                    }
                    case 5: {
                        System.out.println("Balance to your accounts : ");
                        for ( BankAccount bankAccount : authenticatedUser.bankAccountsForUser())
                            System.out.println("Account: " + bankAccount.getIBAN() + " has: $" + bankAccount.showBalance());
                        break;
                    } // de test ce se intampla daca ai 2 conturi ?!?!?! ce output afiseaza? 1 IBAN sau ambele ? ?
                    case 6: {

                    }
                    default: {
                        System.out.println("you have not entered a valid option");
                        break;
                    }
                }
            } else {
                System.out.println("Select the desired operation:");
                System.out.println("To login, type 1\nTo create a new Account, type 2\n");
                byte operation = sc.nextByte();
                switch (operation) {
                    case 1: {
                        System.out.println("enter your username: ");
                        String name = sc.next();
                        for (User user : atmUsers) {
                            if (user.getUserName().equals(name))
                                if (!user.isAccountLocked()) {
                                    isAuthenticated = user.login(name, loginAttempts);
                                    authenticatedUser = user;
                                } else
                                    System.out.println("account is locked, you will not be able to use the onlineATM app");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("enter your First Name: ");
                        String name = sc.next();
                        System.out.println("enter your Last Name: ");
                        String lastName = sc.next();
                        System.out.println("enter enter the desired password: ");
                        String pass = sc.next();
                        User newUser = new User(name, lastName, pass);
                        atmUsers = addUserToATM(atmUsers, newUser);
                        isAuthenticated = true;
                        authenticatedUser = newUser;
                        break;
                    }
                    default: {
                        System.out.println("you have not entered a valid option");
                        break;
                    }
                }
            }
            System.out.println("Do you want to continue? (Y/N)");
            String cont = sc.next();
            if (cont.equals("N") || cont.equals("n"))
                continueActions = false;
        }

        for (User user : atmUsers) {
            System.out.println(user.toString());
        }
    }




    /* --------------------------------   STATIC METHODS   -------------------------------- */

    private static User[] addUserToATM(User[] array1, User a) {

        User[] array2 = new User[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

//    private static void addCardToUser()
}

