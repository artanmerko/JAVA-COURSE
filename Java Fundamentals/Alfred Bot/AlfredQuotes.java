import java.util.Date;
import java.text.SimpleDateFormat;

public class AlfredQuotes {

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    // Sensei Bonus: Overloaded guestGreeting with no parameters, determining day period from Date
    public String guestGreeting() {
        String dayPeriod;
        SimpleDateFormat hourFormat = new SimpleDateFormat("H");
        int hour = Integer.parseInt(hourFormat.format(new Date()));

        if (hour < 12) {
            dayPeriod = "morning";
        } else if (hour < 18) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }

        return String.format("Good %s. Lovely to see you.", dayPeriod);
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.indexOf("Alfred") >= 0) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }
    
}
