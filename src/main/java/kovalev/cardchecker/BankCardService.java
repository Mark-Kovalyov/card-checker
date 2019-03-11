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
        int pos = 0;
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int c = cardNumber.charAt(i);
            if (c >= '0' && c <= '9') {
                if ((pos & 1) == 0) {
                    int res = ((c - '0') << 1);
                    if (res >= 10) {
                        sum += res %10;
                        sum++;
                    } else {
                        sum += res;
                    }
                } else {
                    sum += (c - '0');
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
