import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToeGUI() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        currentPlayer = 'X';

        // Initialize buttons and add ActionListener
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                //buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Check if the button is empty
        if (clickedButton.getText().equals("")) {
            clickedButton.setText(String.valueOf(currentPlayer));

            // Check for a winner
            if (checkForWinner()) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkForWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText()) ||
                checkLine(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText())) {
                return true;
            }
        }

        return checkLine(buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText()) ||
               checkLine(buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText());
    }

    private boolean checkLine(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.equals("");
    }

    private boolean isBoardFull() {
        // Check if all buttons are filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        // Reset all buttons and the current player
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGUI ticTacToe = new TicTacToeGUI();
            ticTacToe.setVisible(true);
        });
    }
}
