package automation.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DataHelper {

    public HashMap<String, String> getAddressData() {
        HashMap<String, String> billingData = new HashMap<String, String>();
        billingData.put("firstname", "test");
        billingData.put("lastname", "user");
        billingData.put("country", "India");
        billingData.put("state", "Delhi");
        billingData.put("city", "Delhi");
        billingData.put("address", "Delhi, India");
        billingData.put("zip", "1234");
        billingData.put("mobile", "91000000000");
        return billingData;
    }

    public HashMap<String, String> getCardInfo() {
        HashMap<String, String> cardData = new HashMap<String, String>();
        cardData.put("name", "Visa");
        cardData.put("mm", "2");
        cardData.put("year", "2024");
        cardData.put("cvc", "123");
        cardData.put("cardNumber", "4111111111111111");
        return cardData;
    }

    public String getDynamicEmail() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDate = myDateObj.format(myFormatObj);
        return "test" + formattedDate + "@test.com";
    }
}
