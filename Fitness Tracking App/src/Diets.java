import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Diets extends JFrame {

    // Immutable class representing a diet plan
    public static final class DietPlan {
        private final String meal;
        private final int calories;

        public DietPlan(String meal, int calories) {
            this.meal = meal;
            this.calories = calories;
        }

        public String getMeal() {
            return meal;
        }

        public int getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return meal + ": " + calories + " calories";
        }
    }

    public Diets() {
        super("Diet Chart");
        setSize(600, 450); // Increase height to fit JTextArea
        getContentPane().setBackground(Color.pink);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and scale the image
        ImageIcon boyImage = new ImageIcon(ClassLoader.getSystemResource("icon/diet_chart.png"));
        Image image = boyImage.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(image));
        finalImage.setBounds(160, 40, 250, 250);

        // Display diet plans
        List<DietPlan> dietPlans = Arrays.asList(
                new DietPlan("Low Calorie Diet", 150),
                new DietPlan("Med Calorie Diet", 300),
                new DietPlan("High Calorie Diet", 400)
        );

        // Using a Predicate with a lambda expression
        Predicate<DietPlan> lowCaloriePredicate = dp -> dp.getCalories() < 300;

        // Display only low-calorie meals
        StringBuilder displayText = new StringBuilder("Calorie Recommendations:\n");
        dietPlans.stream()
                .filter(lowCaloriePredicate)
                .forEach(dp -> displayText.append(dp.toString()).append("\n"));

        JTextArea dietTextArea = new JTextArea();
        dietTextArea.setBounds(220, 320, 550, 50); // Adjust bounds
        dietTextArea.setEditable(false);
        dietTextArea.setBackground(Color.pink);
        dietTextArea.setText(displayText.toString());
        dietTextArea.setLineWrap(true); // Enable line wrapping
        dietTextArea.setWrapStyleWord(true); // Wrap at word boundaries

        // Add components to the frame
        add(finalImage);
        add(dietTextArea);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Diets());
    }
}
