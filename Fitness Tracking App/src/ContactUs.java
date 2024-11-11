import javax.swing.*;
import java.awt.*;

public class ContactUs extends JFrame implements Test {

    ContactUs(){
        super("Contact Us");



        setSize(600, 380);
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);

        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/contact (1).png"));
        Image image = boyImage.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(350,70,170, 170);
        add(finalImage);

        JLabel email = new JLabel("Business Support");
        email.setBounds(30,50,125,20);
        add(email);
        JTextField emailText = new JTextField(Test.contactDetails().get(0).contact().toString());
        emailText.setBounds(170,50,125,20);
        emailText.setEditable(false);
        add(emailText);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,90,125,20);
        add(phone);
        JTextField phoneText = new JTextField(Test.contactDetails().get(1).contact().toString());
        phoneText.setBounds(170,90,125,20);
        phoneText.setEditable(false);
        add(phoneText);

        JLabel itSupport = new JLabel("IT Support");
        itSupport.setBounds(30,130,125,20);
        add(itSupport);
        JTextField itSupportText = new JTextField(Test.contactDetails().get(2).contact().toString());
        itSupportText.setBounds(170,130,125,20);
        itSupportText.setEditable(false);
        add(itSupportText);

        JLabel fax = new JLabel("Fax");
        fax.setBounds(30,170,125,20);
        add(fax);
        JTextField faxText = new JTextField(Test.contactDetails().get(3).contact().toString());
        faxText.setBounds(170,170,125,20);
        faxText.setEditable(false);
        add(faxText);

        JLabel address = new JLabel("Address");
        address.setBounds(30,210,125,20);
        add(address);
        JTextField addressText = new JTextField(Test.contactDetails().get(4).contact().toString());
        addressText.setBounds(170,210,125,20);
        addressText.setEditable(false);
        add(addressText);


        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ContactUs();
    }


}
