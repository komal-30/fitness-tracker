import java.util.List;

sealed interface FAQManager permits SimpleFaq {

    List<String> getFAQs();

    // Static method
    static void displayWelcomeMessage() {
        System.out.println("Welcome to the FAQ Manager!");
    }
}