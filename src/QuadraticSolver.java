import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class QuadraticSolver implements ActionListener {

    JFrame frame;
    JTextField textField;
    JLabel lDirections;
    JLabel lZeros;
    JButton bSolve;

    String sTextField;

    Font boldFont = new Font("Montserrat", Font.BOLD, 20);
    Font italicFont = new Font("Montserrat", Font.ITALIC, 20);
    Font font = new Font("Montserrat", Font.PLAIN, 20);

    QuadraticSolver() {

        textField = new JTextField();
        textField.setBounds(45, 40, 400, 40);
        textField.setFont(italicFont);
        textField.setText(" ");

        lDirections = new JLabel();
        lDirections.setBounds(50, 10, 500, 30);
        lDirections.setText("Enter quadratic equation:");
        lDirections.setFont(font);

        lZeros = new JLabel();
        lZeros.setBounds(50, 85, 400, 30);
        lZeros.setFont(font);

        bSolve = new JButton("Solve");
        bSolve.setBounds(475, 40, 150, 40);
        bSolve.addActionListener(this);
        bSolve.setFont(boldFont);

        frame = new JFrame("Quadratic Solver");
        frame.setSize(750, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.add(lDirections);
        frame.add(lZeros);
        frame.add(bSolve);
        frame.setVisible(true);

        while (true) {
            if (textField.getText().isBlank()) {
                bSolve.setEnabled(false);
            } else {
                bSolve.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSolve) {
            bSolve.setEnabled(false);

            sTextField = textField.getText();
            String[] quadraticExpression = sTextField.split("\\s");

            String ax = quadraticExpression[0];
            String bx = quadraticExpression[2];
            String strC = quadraticExpression[4];

            String signB = quadraticExpression[1];
            String signC = quadraticExpression[3];

            String strA = ax.substring(0, ax.length() - 3);
            String strB = bx.substring(0, bx.length() - 1);
            String [] arrayA = ax.split("\\D+");

            if (strA.isEmpty()) {
                strA = "1";
            }

            if (ax.charAt(0) == '-' && ax.charAt(1) == 'x') {
                strA = "-1";
            } else if (ax.charAt(0) == '-') {
                strA = "-" + arrayA[1];
            }

            if (signB.equals("-")) {
                strB = "-" + bx.substring(0, bx.length() - 1);
            }

            if (signC.equals("-")) {
                strC = "-" + strC;
            }

            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            int c = Integer.parseInt(strC);

            //math
            double radical = Math.pow(b, 2);
            radical -= 4 * a * c;
            radical = Math.sqrt(radical);

            double positiveZero = (-b + radical) / 2 * a;
            double negativeZero = (-b - radical) / 2 * a;

            lZeros.setText("Roots: " + String.valueOf(positiveZero) + ", " +  String.valueOf(negativeZero));
        }
    }
}
