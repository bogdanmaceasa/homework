package tema4;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tema4.atm.BankAccount;
import tema4.atm.*;

import static org.mockito.Mockito.*;

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


        when(bankAccount.cardsForBankAccount()).thenReturn(cards);
        when(user.bankAccountsForUser()).thenReturn(bankAccounts);

        BankAccount[] test = userTest.bankAccountsForUser();
        Assert.assertEquals("Test for output of User Bank Accounts",bankAccounts,test );


    }


}
