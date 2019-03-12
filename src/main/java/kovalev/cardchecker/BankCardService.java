package kovalev.cardchecker;

/**
 * Main service
 */
public class BankCardService {

    private static BankCardService bankCardService;

    private BankCardService() {
        // Singleton
    }

    public static BankCardService createInstance() {
        if (bankCardService == null) {
            bankCardService = new BankCardService();
        }
        return bankCardService;
    }

    private int charToDigit(char c) {
        return c - '0';
    }

    /**
     * @param cardNumber in format XXXX-XXXX-XXXX-XXXX
     * @return
     */
    public boolean check(String cardNumber) {
        if (cardNumber==null) throw new IllegalArgumentException("cardNumber cannot be null");
        if (cardNumber.equals("")) throw new IllegalArgumentException("cardNumber cannot be empty");
        if (cardNumber.length()!=19) throw new IllegalArgumentException("cardNumber must be equals to ####-####-####-####");
        int pos = 0;
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int c = cardNumber.charAt(i);
            char cc = (char) c;
            if (Character.isDigit(cc)) {
                if ((pos & 1) == 0) {
                    int res = charToDigit(cc);
                    if (res >= 10) {
                        sum += res % 10;
                        sum++;
                    } else {
                        sum += res;
                    }
                } else {
                    sum += charToDigit(cc);
                }
                pos++;
            } else {
                if (i==4 || i==9 || i==14) {
                    if (c!='-') throw new IllegalArgumentException("cardNumber must be equals to ####-####-####-####");
                }
            }
        }
        return sum % 10 == 0;
    }


}
