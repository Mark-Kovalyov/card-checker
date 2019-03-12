package kovalev.cardchecker;

import org.junit.Before;
import org.junit.Test;

public class CardTesterErrors {

    private BankCardService bankCardService;

    @Before
    public void before() {
        bankCardService = BankCardService.createInstance();
    }

    @Test(expected = IllegalArgumentException.class)
    public void assumeThatNullArgumentProducesIllegalArgException() {
        bankCardService.check(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assumeThatEmptyArgumentProducesIllegalArgException() {
        bankCardService.check("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void assumeThatShortArgumentProducesIllegalArgException() {
        bankCardService.check("0123-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void assumeThatIncorrectFormatArgumentProducesIllegalArgException() {
        bankCardService.check("5168 7422 1127 0610");
    }



}
