package view;

import model.CalculoImc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaImc {

    private CustomPanel painelTitulo = new CustomPanel("/images/skeletu.jpg");
    private JLabel labelTitulo = new JLabel("Índice de Massa Corporal - IMC");

    private JLabel labelMassa = new JLabel("Massa:");
    private JTextField textMassa = new JTextField();

    private JLabel labelAltura = new JLabel("Altura");
    private JTextField textAltura = new JTextField();

    private JLabel labelTituloReusltadoIMC = new JLabel("Resultado IMC");
    private JLabel labelResultado = new JLabel();
    private JLabel labelStatusIMC = new JLabel();

    private JButton botaoCalcular = new JButton("Calcular");
    private JButton botaoReset = new JButton("Resetar");

    private String imagePath = "../images/";
    private Icon iconBotaoCalc = new ImageIcon(getClass().getResource(imagePath + "calc2.png"));
    private Icon iconBotaoReset = new ImageIcon(getClass().getResource(imagePath + "restart24.png"));
    ImageIcon iconPagina = new ImageIcon(getClass().getResource(imagePath + "iconApp.png"));

    public TelaImc() {
        criarTela();
    }

    public void criarTela() {
        JFrame tela = new JFrame();

        tela.setTitle("Calculadora IMC");
        tela.setSize(500, 350);
        tela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tela.setLayout(null);

        painelTitulo.setBounds(0, 0, 500, 80);
        painelTitulo.setBackground(new Color(144, 238, 114));
        painelTitulo.setLayout(null);

        labelTitulo.setBounds(20, -20, 230, 120);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 15));
        labelTitulo.setForeground(Color.BLACK);
        painelTitulo.add(labelTitulo);

        labelMassa.setBounds(10, 110, 150, 30);
        textMassa.setBounds(10, 140, 150, 30);
        textMassa.setFont(new Font("Arial", Font.BOLD, 24));

        labelAltura.setBounds(10, 190, 150, 30);
        textAltura.setBounds(10, 220, 150, 30);
        textAltura.setFont(new Font("Arial", Font.BOLD, 24));

        labelTituloReusltadoIMC.setBounds(250, 130, 150, 30);
        labelTituloReusltadoIMC.setForeground(Color.DARK_GRAY.darker());
        labelTituloReusltadoIMC.setFont(new Font("Arial", Font.BOLD, 20));
        labelTituloReusltadoIMC.setHorizontalAlignment(JLabel.CENTER);

        labelResultado.setBounds(170, 150, 300, 70);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 50));
        labelResultado.setHorizontalAlignment(JLabel.CENTER);

        labelStatusIMC.setBounds(195, 190, 250, 70);
        labelStatusIMC.setFont(new Font("Arial", Font.ITALIC, 15));
        labelStatusIMC.setHorizontalAlignment(JLabel.CENTER);

        botaoReset.setBounds(320, 270, 150, 30);
        botaoReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparTela();
            }
        });
        botaoReset.setIcon(iconBotaoReset);

        botaoCalcular.setBounds(170, 270, 150, 30);
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImc();
            }
        });
        botaoCalcular.setIcon(iconBotaoCalc);

        tela.getContentPane().add(painelTitulo);
        tela.setIconImage(iconPagina.getImage());
        tela.getContentPane().add(labelMassa);
        tela.getContentPane().add(textMassa);
        tela.getContentPane().add(textAltura);
        tela.getContentPane().add(labelAltura);
        tela.getContentPane().add(labelTituloReusltadoIMC);
        tela.getContentPane().add(labelResultado);
        tela.getContentPane().add(labelStatusIMC);
        tela.getContentPane().add(botaoReset);
        tela.getContentPane().add(botaoCalcular);

        tela.setVisible(true);
    }

    private void limparTela() {
        textAltura.setText("");
        textMassa.setText("");
        labelStatusIMC.setText("");
        labelResultado.setText("");
        textMassa.requestFocus();
    }

    CalculoImc calculoImc = new CalculoImc();
    int massa = 0;
    double altura = 0;

    private void calcularImc() {
        if (validarDados()) {

            calculoImc.setMassa(massa);
            calculoImc.setAltura(altura);

            double imc = calculoImc.getImc();
            String status = calculoImc.getStatus();

            if (imc >= 18.5 && imc <= 25.0) {
                labelResultado.setForeground(Color.GREEN.darker());
            } else
                labelResultado.setForeground(Color.RED);

            labelResultado.setText(Double.toString(imc));
            labelResultado.setText(
                    String.format("%.2f", calculoImc.getImc()).trim().replace(",", "."));
            labelStatusIMC.setText(status);
        }
    }
    private boolean validarDados () {
        try {
            massa = Integer.parseInt(textMassa.getText().trim());
        } catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null,
                    "A massa deve ser um valor numérico",
                    "Erro de entrada",
                    JOptionPane.ERROR_MESSAGE);

            return false;
        }

        try {
            altura = Double.parseDouble(textAltura.getText().replace(",", "."));
        } catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null,
                    "A altura deve ser um valor numérico",
                    "Erro de entrada",
                    JOptionPane.ERROR_MESSAGE);

            return false;
        }

        return true;
    }
}

