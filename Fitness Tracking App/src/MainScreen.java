import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MainScreen extends JFrame implements ActionListener {

    JButton signUpButton, loginButton;
    JTextField employerIdText;
    JTextField userNameText;

    JTextField nameText;
    JPasswordField passwordText;
    JTextField meterNoText;
    Choice createAccountAsChoice;


    MainScreen(String username,String pass) {

        //Give the frame name
        super("Fitness App");
        setLayout(null);

        getContentPane().setBackground(Color.pink);




        JLabel userName = new JLabel("Username");
        userName.setBounds(30, 100, 125, 20);
        add(userName);
        userNameText = new JTextField();
        userNameText.setBounds(170, 100, 125, 20);
        add(userNameText);


        JLabel titleName = new JLabel("Fitness App");
        titleName.setBounds(150, 3, 250, 60);
        titleName.setFont(new Font("castellar",Font.BOLD,25));
        add(titleName);

        JLabel password = new JLabel("Password");
        password.setBounds(30, 150, 125, 20);
        add(password);
        passwordText = new JPasswordField();
        passwordText.setBounds(170, 150, 125, 20);
        passwordText.setEchoChar('*');
        add(passwordText);


        signUpButton = new JButton("Sign Up ");
        signUpButton.setBounds(30, 230, 100, 25);
        signUpButton.setForeground(Color.black);
        signUpButton.addActionListener(this);
        add(signUpButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(170, 230, 100, 25);
        loginButton.setForeground(Color.black);
        loginButton.addActionListener(this);
        add(loginButton);


        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image image = boyImage.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(320,40,250, 250);
        add(finalImage);

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        JLabel dateTime = new JLabel("Login Time: "+ formattedDateTime);
        dateTime.setBounds(360  ,290,180, 50);
        dateTime.setVisible(true);
        add(dateTime);


        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);

    }


    public static void main(String[] args) {
        new MainScreen("","");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){

            Database database  = new Database();
            String query = "";
            query = "Select * from user_details where user_name = '"+userNameText.getText()+"' and password = '"+passwordText.getText()+"' ";

            try{
                ResultSet resultSet = database.statement.executeQuery(query);
                if(resultSet.next()){
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    new Dashboard(userNameText.getText(),passwordText.getText());
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(e.getSource()==signUpButton){
            new SignUpPage();
            setVisible(false);
        }

    }

}