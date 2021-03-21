package tema4ATM.atm;

import java.util.Scanner;

public class Pos {

    public static void operations(User user) {

        Scanner sc = new Scanner(System.in);

        boolean interrupt = false;
        while (!interrupt) {
            System.out.println("\nYour bank accounts are: ");
            int i = 1, j = 1, k = 1, l = 1;
            for (BankAccount bankAccount : user.bankAccountsForUser()) {
                System.out.print("\n" + i + ") " + bankAccount.toString() + "\n");
                i++;
            }
            System.out.println("\n\nYou will need to have a card attached to the selected bank account to use for the POS operations");
            System.out.println("\n\nTo make a payment, type 1\n" + "To withdraw money, type 2\nTo deposit money, type 3\nTo change PIN for one of your cards, type 4\nTo exit the POS, type 9");
            int op = sc.nextInt();

            switch (op) {
                case 1: {
                    System.out.println("Type the desired account to use for the payment: ");
                    int index = sc.nextInt();
                    BankAccount account = user.bankAccountsForUser()[index - 1];
                    System.out.println("Type the desired card you want to use for the transaction: ");
                    for (Card card : account.cardsForBankAccount()) {
                        System.out.print("\n" + l + ") " + card.toString() + "\n");
                        l++;
                    }
                    int cardIndex = sc.nextInt();
                    Card card = account.cardsForBankAccount()[cardIndex - 1];
                    System.out.println("Card : " + card.getCardNumber() + " will be used for the transaction!\n");
                    System.out.println("Enter the desired amount to pay: ");
                    double sum = sc.nextDouble();
                    account.pay(sum);
                    break;
                }
                case 2: {
                    System.out.println("Type the desired account to withdraw from: ");
                    int index = sc.nextInt();
                    BankAccount account = user.bankAccountsForUser()[index - 1];
                    System.out.println("Type the desired card you want to use for the transaction: ");
                    for (Card card : account.cardsForBankAccount()) {
                        System.out.print("\n" + j + ") " + card.toString() + "\n");
                        j++;
                    }
                    int cardIndex = sc.nextInt();
                    Card card = account.cardsForBankAccount()[cardIndex - 1];
                    System.out.println("Card : " + card.getCardNumber() + " will be used for the transaction!\n");
                    System.out.println("Enter the desired amount to withdraw: ");
                    double sum = sc.nextDouble();
                    account.withdrawMoney(sum);
                    break;
                }
                case 3: {
                    System.out.println("Type the desired account to deposit on: ");
                    int index = sc.nextInt();
                    BankAccount account = user.bankAccountsForUser()[index - 1];
                    System.out.println("Type the desired card you want to use for the transaction: \n");
                    for (Card card : account.cardsForBankAccount()) {
                        System.out.print("\n" + k + ") " + card.toString() + "\n");
                        k++;
                    }
                    int cardIndex = sc.nextInt();
                    Card card = account.cardsForBankAccount()[cardIndex - 1];
                    System.out.println("Card : " + card.getCardNumber() + " will be used for the transaction!\n");
                    System.out.println("Enter the desired amount to deposit: ");
                    double sum = sc.nextDouble();
                    account.addBalance(sum);
                    break;
                }
                case 4: {
                    user.listCards();
                    System.out.println("Type the desired card you want to change the pin for: ");
                    int index = sc.nextInt();
                    Card card = user.getCards()[index - 1];
                    System.out.println("Enter the new PIN ( 4 digits ): ");
                    int pin = sc.nextInt();
                    card.changePIN(pin);
                    break;
                }
                case 9: {
                    interrupt = true;
                    break;
                }
                default: {
                    System.out.println("Invalid entry");

                }
            }
        }
    }

}
