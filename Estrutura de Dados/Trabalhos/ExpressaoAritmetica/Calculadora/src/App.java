import javax.swing.*;

import trabalho.Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    private static JLabel expressaoLabel = new JLabel("Expressão");
    private static JTextField expressaoTextField = new JTextField(15);
    private static JButton calcularButton = new JButton("Calcular");
    private static JLabel resultadoLabel = new JLabel("Resultado");
    private static JTextField resultadoTextField = new JTextField(15);

    public static void main(String[] args) throws Exception {
        App window = new App();
        window.setSize(300,200);
        window.setVisible(true);
        window.setTitle("Calculadora");
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        window.getContentPane().add(expressaoLabel);
        window.getContentPane().add(expressaoTextField);
        window.getContentPane().add(calcularButton);
        window.getContentPane().add(resultadoLabel);
        window.getContentPane().add(resultadoTextField);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private static void calcular(){
        try {
            if(!expressaoTextField.getText().isEmpty())
                resultadoTextField.setText(String.valueOf(new Calculadora().Calcular(expressaoTextField.getText())));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
