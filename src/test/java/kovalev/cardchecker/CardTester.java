package kovalev.cardchecker;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class CardTester {

    @DataPoints
    public final static String[] numbers = { 
            "5168-7554-2103-4394",
            "4149-4978-6871-3779",
            "5168-7573-3310-7425",
            "5168-7422-1127-0610"
    };

    @Theory
    public void bankCardIsCorrect(String cardNumber) {
        BankCardService bankCardService = BankCardService.createInstance();
        assertTrue(bankCardService.check(cardNumber));
    }

}
