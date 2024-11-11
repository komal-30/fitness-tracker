import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewInformation extends JFrame implements ActionListener {
    JTextField nameText,emailText,mobileText,ageText,weightText,heightText,genderText,countryText;
    JButton cancelButton;

    public ViewInformation(String userName, String password){

        setSize(600,500);
        getContentPane().setBackground(Color.pink);
        setLocation(500,200);
        setTitle("View Information");


        JLabel name = new JLabel("Name");
        name.setBounds(30,50,125,20);
        add(name);
        nameText = new JTextField();
        nameText.setBounds(170,50,125,20);
        nameText.setEditable(false);
        add(nameText);

        JLabel email = new JLabel("Email");
        email.setBounds(30,90,125,20);
        add(email);
        emailText = new JTextField();
        emailText.setBounds(170,90,125,20);
        emailText.setEditable(false);
        add(emailText);

        JLabel mobile = new JLabel("Mobile");
        mobile.setBounds(30,130,125,20);
        add(mobile);
        mobileText = new JTextField();
        mobileText.setBounds(170,130,125,20);
        mobileText.setEditable(false);
        add(mobileText);

        JLabel age = new JLabel("Age");
        age.setBounds(30,170,125,20);
        add(age);
        ageText = new JTextField();
        ageText.setBounds(170,170,125,20);
        ageText.setEditable(false);
        add(ageText);

        JLabel weight = new JLabel("Weight");
        weight.setBounds(30,210,125,20);
        add(weight);
        weightText = new JTextField();
        weightText.setBounds(170,210,125,20);
        weightText.setEditable(false);
        add(weightText);

        JLabel height = new JLabel("Height");
        height.setBounds(30,250,125,20);
        add(height);
        heightText = new JTextField();
        heightText.setBounds(170,250,125,20);
        heightText.setEditable(false);
        add(heightText);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,290,125,20);
        add(gender);
        genderText = new JTextField();
        genderText.setBounds(170,290,125,20);
        genderText.setEditable(false);
        add(genderText);

        JLabel country = new JLabel("Country");
        country.setBounds(30,330,125,20);
        add(country);
        countryText = new JTextField();
        countryText.setBounds(170,330,125,20);
        countryText.setEditable(false);
        add(countryText);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 390, 100, 25);
        cancelButton.setForeground(Color.black);
        cancelButton.addActionListener(this);
        add(cancelButton);


        ImageIcon signup = new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image image = signup.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(320, 80, 250, 250);
        add(finalImage);


        String query = "Select * from user_details where user_name = ? and password = ? ";
        try{
            Connection connection;
            Statement statement;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitness?useSSL=false&serverTimezone=UTC","root","Komal@325740");
            statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                emailText.setText(resultSet.getString("email"));
                mobileText.setText(resultSet.getString("mobile"));
                ageText.setText(resultSet.getString("age"));
                weightText.setText(resultSet.getString("weight"));
                heightText.setText(resultSet.getString("height"));
                genderText.setText(resultSet.getString("sex"));
                countryText.setText(resultSet.getString("country"));

                }
            } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ViewInformation("kom","kom@123");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton){
            setVisible(false);
        }

    }
}
