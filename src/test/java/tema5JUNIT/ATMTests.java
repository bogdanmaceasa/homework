package tema5JUNIT;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tema4ATM.atm.*;

public class ATMTests {

    @InjectMocks
    private BankAccount[] bankAccounts = {new BankAccount(), new BankAccount(), new BankAccount()};
    private Card[] cards = {new Card("m"), new Card("ma"), new Card("bo"), new Card("iu")};
    private User userTest = new User("firstName", "lastName", "password", bankAccounts, cards );

    @Mock
    private User user;
    private BankAccount bankAccount;
    private Card card;


    /*  ATM methods tests  */

    @Test
    public void testBankAccountsForUser(){

//        when(bankAccount.cardsForBankAccount()).thenReturn(cards); //-> NullPointerException?!
//        when(user.bankAccountsForUser()).thenReturn(bankAccounts);

        BankAccount[] test = userTest.bankAccountsForUser();
        Assert.assertEquals("Test for output of User Bank Accounts",bankAccounts,test );


    }




}
