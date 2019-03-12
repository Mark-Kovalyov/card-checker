package kovalev.cardchecker;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    static Logger logger = LoggerFactory.getLogger(CardController.class);

    @RequestMapping(value = "/check/{card}", method = RequestMethod.GET, produces = "application/json")
    @HystrixCommand(fallbackMethod = "fallbackCheck",
                    commandKey = "cardKey",
                    groupKey = "cardGroup")
    public CheckResult check(@PathVariable("card") String card) {
        logger.info(":: card = {}", card);
        boolean result = false;
        try {
            result = BankCardService.createInstance().check(card);
        } catch (IllegalArgumentException ex) {
            return new CheckResult(false, ex.getMessage());
        }
        return new CheckResult(result);
    }

    public CheckResult fallbackCheck(String card) {
        return new CheckResult(false, "fallback");
    }

}
