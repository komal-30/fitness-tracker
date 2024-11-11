import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FaqScreen extends JFrame{

    private final FAQManager faqManager;

    FaqScreen(FAQManager faqManager){
        super("FAQ Screen");
        this.faqManager = faqManager;

        setSize(600, 380);
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);

//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//        textArea.setBounds(30,30,150,20);
//        textArea.setFont(new Font("Arial", Font.PLAIN, 14));


//        JLabel height = new JLabel("Height");
//        height.setBounds(30,30,350,20);
//        add(height);
//
        JLabel height = new JLabel("Height");

        int y = 10,i = 0;
        List<String> faqs = faqManager.getFAQs();
        for (String faq : faqs) {
            height = new JLabel("");
            height.setText(faq + "\n\n");
            height.setBounds(30,y,500,20);
            if(i%2==0){
                height.setFont(new Font("", Font.BOLD, 14));
            }
            else{
                height.setFont(new Font("Arial", Font.PLAIN, 14));
            }
            add(height);
            System.out.println(faq);
            y += 30;
            i += 1;
        }

//        JScrollPane scrollPane = new JScrollPane(height);
//        add(scrollPane, BorderLayout.CENTER);

        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/Faq Image.png"));
        Image image = boyImage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(350,70,200, 200);
        add(finalImage);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleFaq simpleFaq = new SimpleFaq();
        new FaqScreen(simpleFaq);
    }
}
