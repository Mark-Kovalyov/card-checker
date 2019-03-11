package kovalev.cardchecker;

public class BankCardService {

    private static BankCardService bankCardService;

    private BankCardService() {

    }

    public static BankCardService createInstance() {
        if (bankCardService == null) {
            bankCardService = new BankCardService();
        }
        return bankCardService;
    }

    /**
     * @param cardNumber in format XXXX-XXXX-XXXX-XXXX
     * @return
     */
    public boolean check(String cardNumber) {
        if (cardNumber==null) throw new IllegalArgumentException("cardNumber cannot be null");
        if (cardNumber.length()!=19) throw new IllegalArgumentException("cardNumber must be equals to ####-####-####-####");
        return true;
    }


}
