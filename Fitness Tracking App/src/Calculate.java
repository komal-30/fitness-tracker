import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate extends JFrame implements ActionListener,UserActions{


    JButton calculate;
    JTextField weightText,heightText;
    JTable bmiTable;

    Calculate(){

        setTitle("BMI Calculator");
        setSize(600, 380);
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);

        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/Bmi.png"));
        Image image = boyImage.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(325, 55, 220, 220);

        calculate = new JButton("Calculate");
        calculate.setBounds(80, 280, 100, 25);
        calculate.setForeground(Color.black);
        calculate.addActionListener(this);
        add(calculate);

        JLabel weight = new JLabel("Weight");
        weight.setBounds(30, 50, 125, 20);
        add(weight);
        weightText = new JTextField();
        weightText.setBounds(170, 50, 125, 20);
        add(weightText);

        JLabel height = new JLabel("Height");
        height.setBounds(30, 90, 125, 20);
        add(height);
        heightText = new JTextField();
        heightText.setBounds(170, 90, 125, 20);
        add(heightText);

        String[] columnNames = {"BMI Range", "Category"};
        Object[][] data = {
                {"< 18.5", "Underweight"},
                {"18.5 - 24.9", "Normal weight"},
                {"25.0 - 29.9", "Overweight"},
                {">= 30", "Obesity"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        bmiTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(bmiTable);
        scrollPane.setBounds(30, 140, 200, 100);
        add(scrollPane);


        add(finalImage);
        setLayout(null);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculate){
            Double bmi = UserActions.super.calculateBMI(Double.valueOf(weightText.getText()),Double.valueOf(heightText.getText()));
//            Float bmi = Float.parseFloat(weightText.getText())/(Float.parseFloat(heightText.getText()) * Float.parseFloat(heightText.getText()));
            JOptionPane.showMessageDialog(null,"Your BMI Is " +bmi.toString());
        }
    }


    public static void main(String[] args) {
        new Calculate();
    }
}

