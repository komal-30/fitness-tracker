import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Train extends JFrame implements ActionListener {


    Choice timeChoice,feeChoice,sportChoice;
    JButton submitButton;
    JLabel trainerName,trainerContact,trainerEmail;
    Train(){

        setTitle("Diet Chart");
        setSize(600, 380);
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);


//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//        panel.setBackground(new Color(252,186,3));
//        add(panel);

        //based on time,sport,fees range give list of trainers available
        //Add a submit button which will take all the input from the screen and than search for trainers and display thier details

        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/Train.png"));
        Image image = boyImage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(360, 60, 200, 200);

        JLabel sport = new JLabel("Sport");
        sport.setBounds(30, 50, 50, 20);
        add(sport);
        sportChoice =  new Choice();
        //Here you can just simply write loginChoice.add("Customer")
        sportChoice.add("Badminton");
        sportChoice.add("FootBall");
        sportChoice.add("Rugby");
        sportChoice.add("Swimming");
        sportChoice.setBounds(120,50,100,20);
        add(sportChoice);


        JLabel time = new JLabel("Time");
        time.setBounds(30, 90, 50, 20);
        add(time);
        timeChoice =  new Choice();
        //Here you can just simply write loginChoice.add("Customer")
        timeChoice.add(String.valueOf(TimeChoice.Weekday));
        timeChoice.add(String.valueOf(TimeChoice.Weekend));
        timeChoice.setBounds(120,90,100,20);
        add(timeChoice);


        JLabel fees = new JLabel("Fees");
        fees.setBounds(30, 130, 50, 20);
        add(fees);
        feeChoice =  new Choice();
        //Here you can just simply write loginChoice.add("Customer")
        feeChoice.add(" < 10 E/H ");
        feeChoice.add(" > 10 E/H ");
        feeChoice.setBounds(120,130,100,20);
        add(feeChoice);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 190, 100, 25);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener(this);
        add(submitButton);

        trainerName = new JLabel();
        trainerName.setBounds(30,240,150,20);
        add(trainerName);

        trainerContact = new JLabel();
        trainerContact.setBounds(30,260,150,20);
        add(trainerContact);

        trainerEmail = new JLabel();
        trainerEmail.setBounds(30,280,150,20);
        add(trainerEmail);

        add(finalImage);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == submitButton){

        Database database = new Database();
        String query ="";
        String feeQuery = ">10";
        if(feeChoice.getSelectedItem().equals(" < 10 E/H "))
            feeQuery = "<10";
        query = "Select * from trainer_details where sport='"+sportChoice.getSelectedItem()+"' and time='"+timeChoice.getSelectedItem()+"' and fee " + feeQuery;
        try {
            ResultSet resultSet = database.statement.executeQuery(query);
            if(resultSet.next()){
                trainerName.setText("Name: " +resultSet.getString("name"));
                trainerEmail.setText("Email: " +resultSet.getString("email"));
                trainerContact.setText("Contact: " +resultSet.getString("contact"));
            }else{
                JOptionPane.showMessageDialog(null,"No Trainers Found");
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    }

    public static void main(String[] args) {
        new Train();
    }


    public enum TimeChoice {
        Weekday,
        Weekend;
    }




}
