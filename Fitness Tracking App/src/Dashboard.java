import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuItem viewInfo,customerDetails,viewDiet,calculateBmi,viewTrainers,faqName,contactUsText;
    String user;
    String pass;
    JMenu faq,contactUs;
    Dashboard(String userNameText,String passText){
    this.user=userNameText;
    this.pass=passText;

        getContentPane().setBackground(Color.pink);
        setLocation(500,200);
        setTitle("DashBoard");
        setSize(600,500);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/background.png"));
        Image image = imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLable = new JLabel(imageIcon1);
        add(imageLable);
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        //Creates an item to be added in the bar
        JMenu profile = new JMenu("Profile");
        profile.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(profile);

        //Add a option to dropdown to include a customer
        viewInfo  = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(customerImage));
        viewInfo.addActionListener(this);
        profile.add(viewInfo);

        customerDetails  = new JMenuItem("Edit Information");
        customerDetails.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon customerDetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImgage = customerDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImgage));
        customerDetails.addActionListener(this);
        profile.add(customerDetails);

        JMenu diet  = new JMenu("Diet");
        diet.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(diet);

        viewDiet  = new JMenuItem("View Diet");
        viewDiet.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon dietImg = new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image dietImage = dietImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewDiet.setIcon(new ImageIcon(dietImage));
        viewDiet.addActionListener(this);
        diet.add(viewDiet);

        JMenu train  = new JMenu("Train");
        train.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(train);
        viewTrainers  = new JMenuItem("View Trainers");
        viewTrainers.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon trainImg = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image trainImage = trainImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewTrainers.setIcon(new ImageIcon(trainImage));
        viewTrainers.addActionListener(this);
        train.add(viewTrainers);

        JMenu calculate  = new JMenu("Calculate");
        calculate.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(calculate);
        calculateBmi  = new JMenuItem("Calculate BMI");
        calculateBmi.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon calImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculateImage = calImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBmi.setIcon(new ImageIcon(calculateImage));
        calculateBmi.addActionListener(this);
        calculate.add(calculateBmi);

        faq = new JMenu("FAQs");
        faq.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(faq);
        faqName  = new JMenuItem("User FAQ's");
        faqName.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon faqNameImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image faqNameImage = faqNameImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        faqName.setIcon(new ImageIcon(faqNameImage));
        faqName.addActionListener(this);
        faq.add(faqName);

        contactUs = new JMenu("Contact Us");
        contactUs.setFont(new Font("serif",Font.BOLD,15));
        menuBar.add(contactUs);

        contactUsText  = new JMenuItem("Contact Us");
        contactUsText.setFont(new Font("monospace",Font.PLAIN,15));
        ImageIcon contactUsTextImg = new ImageIcon(ClassLoader.getSystemResource("icon/contact-removebg-preview.png"));
        Image contactUsTextImage = contactUsTextImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        contactUsText.setIcon(new ImageIcon(contactUsTextImage));
        contactUsText.addActionListener(this);
        contactUs.add(contactUsText);

        setVisible(true);
        setLayout(null);

    }


    public static void main(String[] args) {
        new Dashboard("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FAQManager faqManager = new SimpleFaq();
        int ch = 0;
        if(e.getSource() == viewInfo)
            ch = 1;
        else if (e.getSource() == customerDetails)
            ch = 2;
        else if (e.getSource() == viewDiet)
            ch = 3;
        else if (e.getSource() == calculateBmi)
            ch = 4;
        else if (e.getSource() == viewTrainers)
            ch = 5;
        else if (e.getSource() == faqName)
            ch = 6;
        else if (e.getSource() == contactUsText)
            ch = 7;

        switch (ch) {
            case 1:
                new ViewInformation(user, pass);
                break;
            case 2:
                new EditInformation(user, pass);
                break;
            case 3:
                new Diets();
                break;
            case 4:
                new Calculate();
                break;
            case 5:
                new Train();
                break;
            case 6:
                new FaqScreen(faqManager);
                break;
            case 7:
                new ContactUs();
                break;
            default:
                System.out.println("Default Case");
        }


    }
}
