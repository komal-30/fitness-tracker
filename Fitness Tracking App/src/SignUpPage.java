import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpPage extends JFrame implements ActionListener {


    JTextField userNameText,passwordText,nameText,emailText,mobileText,ageText,weightText,heightText,genderText,countryText;
    JButton submitButton,cancelButton;

    SignUpPage(){
        setSize(600,500);
        getContentPane().setBackground(Color.pink);
        setLocation(500,200);
        setTitle("SignUp");

        JLabel userName = new JLabel("User Name");
        userName.setBounds(30,50,125,20);
        add(userName);
        userNameText = new JTextField();
        userNameText.setBounds(170,50,125,20);
        add(userNameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30,80,125,20);
        add(password);
        passwordText = new JTextField();
        passwordText.setBounds(170,80,125,20);
        add(passwordText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,110,125,20);
        add(name);
        nameText = new JTextField();
        nameText.setBounds(170,110,125,20);
        add(nameText);

        JLabel email = new JLabel("Email");
        email.setBounds(30,140,125,20);
        add(email);
        emailText = new JTextField();
        emailText.setBounds(170,140,125,20);
        add(emailText);

        JLabel mobile = new JLabel("Mobile");
        mobile.setBounds(30,170,125,20);
        add(mobile);
        mobileText = new JTextField();
        mobileText.setBounds(170,170,125,20);
        add(mobileText);

        JLabel age = new JLabel("Age");
        age.setBounds(30,200,125,20);
        add(age);
        ageText = new JTextField();
        ageText.setBounds(170,200,125,20);
        add(ageText);

        JLabel weight = new JLabel("Weight");
        weight.setBounds(30,230,125,20);
        add(weight);
        weightText = new JTextField();
        weightText.setBounds(170,230,125,20);
        add(weightText);

        JLabel height = new JLabel("Height");
        height.setBounds(30,260,125,20);
        add(height);
        heightText = new JTextField();
        heightText.setBounds(170,260,125,20);
        add(heightText);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,290,125,20);
        add(gender);
        genderText = new JTextField();
        genderText.setBounds(170,290,125,20);
        add(genderText);

        JLabel country = new JLabel("Country");
        country.setBounds(30,320,125,20);
        add(country);
        countryText = new JTextField();
        countryText.setBounds(170,320,125,20);
        add(countryText);

        ImageIcon signup = new ImageIcon(ClassLoader.getSystemResource("icon/sign-up.png"));
        Image image = signup.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(320, 80, 250, 250);
        add(finalImage);

        submitButton = new JButton("Submit");
        submitButton.setBounds(160, 380, 100, 25);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 380, 100, 25);
        cancelButton.setForeground(Color.black);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==submitButton){

        Database database = new Database();
        String query ="";
        query = "Select * from user_details where user_name='"+userNameText.getText()+"' and password='"+passwordText.getText()+"' ";
        try {

            ResultSet resultSet = database.statement.executeQuery(query);


            int age = Integer.parseInt( ageText.getText());

            if(resultSet.next()){
                JOptionPane.showMessageDialog(null,"User Already Exists!");
            }else{
                query = "INSERT INTO user_details (user_name, password, name, email, mobile, age, weight, height, sex, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = database.connection.prepareStatement(query);
                pstmt.setString(1, userNameText.getText());
                pstmt.setString(2, passwordText.getText());
                pstmt.setString(3, nameText.getText());
                pstmt.setString(4, emailText.getText());
                pstmt.setString(5, mobileText.getText()); // Assuming mobile is stored as a string in your DB
                pstmt.setInt(6, Integer.parseInt(ageText.getText()));
                pstmt.setInt(7, Integer.parseInt(weightText.getText()));
                pstmt.setInt(8, Integer.parseInt(heightText.getText()));
                pstmt.setString(9, genderText.getText());
                pstmt.setString(10, countryText.getText());

                int result = pstmt.executeUpdate(); //executeUpdate() returns 1 if successful else 0 if unsuccessful
                if(result==1){
                    JOptionPane.showMessageDialog(null,"User Registration Successfull!");
                }else{
                    JOptionPane.showMessageDialog(null,"Registration Unsuccessfull,Please try later!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }else if(e.getSource()==cancelButton){
        setVisible(false);
    }
    }
}
