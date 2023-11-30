import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGame extends JFrame {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;

    public RockPaperScissorsGame() {
        super("Rock, Paper, Scissors");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeButtons();
        initializeResultLabel();
    }

    private void initializeButtons() {
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        rockButton.addActionListener(new ButtonClickListener("Rock"));
        paperButton.addActionListener(new ButtonClickListener("Paper"));
        scissorsButton.addActionListener(new ButtonClickListener("Scissors"));

        setLayout(new FlowLayout());
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
    }

    private void initializeResultLabel() {
        resultLabel = new JLabel("Result: ");
        add(resultLabel);
    }

    private class ButtonClickListener implements ActionListener {
        private String playerChoice;

        public ButtonClickListener(String choice) {
            this.playerChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String computerChoice = generateComputerChoice();
            determineWinner(playerChoice, computerChoice);
        }

        private String generateComputerChoice() {
            String[] choices = {"Rock", "Paper", "Scissors"};
            int randomIndex = (int) (Math.random() * choices.length);
            return choices[randomIndex];
        }

        private void determineWinner(String playerChoice, String computerChoice) {
            String result;

            if (playerChoice.equals(computerChoice)) {
                result = "It's a tie!";
            } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                    (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                    (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                result = "You win!";
            } else {
                result = "Computer wins!";
            }

            resultLabel.setText("Result: " + result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorsGame game = new RockPaperScissorsGame();
            game.setVisible(true);
        });
    }
}