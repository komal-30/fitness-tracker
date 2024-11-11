import java.util.ArrayList;
import java.util.List;

public final class SimpleFaq implements FAQManager {

    @Override
    public List<String> getFAQs() {
            List<String> faqList = new ArrayList<>();
        faqList.add("What is the app about ?");
        faqList.add("->This app helps you track workouts");
        faqList.add("How do I create an account ? ");
        faqList.add("->Click on SignUp and follow step");
        faqList.add("How do I update my details ?");
        faqList.add("->Click on Edit Information and save changes");
        faqList.add("How can I contact the app support?");
        faqList.add("->Please visit the Contact Us Page");
        faqList.add("Can I filter trainers based on sports ?");
        faqList.add("->Yes, you can filter trainers on various sports");
        return faqList;

    }



    //Create a panel with options to view the faq categories - It will include the general faq and login faq.
    //Use Switch for that
}
