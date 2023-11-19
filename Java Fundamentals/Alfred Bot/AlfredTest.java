public class AlfredTest {

    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        String testGuestGreetingNinja = alfredBot.guestGreeting("Beth Kane", "evening");

        String testGuestGreetingSensei = alfredBot.guestGreeting();

        // Print the new test greetings
        System.out.println(testGuestGreetingNinja);
        System.out.println(testGuestGreetingSensei);

        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        
        
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
    }
}
