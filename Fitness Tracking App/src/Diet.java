import javax.swing.*;
import java.awt.*;

public class Diet extends JFrame {

    Diet(){

        super("Diet Chart");
//        super.setTitle("Diet Chart");
        setSize(600, 380);
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);

        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/diet_chart.png"));
        Image image = boyImage.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(160, 40, 250, 250);

        add(finalImage);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Diet();
    }
}
