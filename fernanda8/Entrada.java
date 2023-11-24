import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrada extends JFrame {
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private GerenciadorAutenticacao gerenciadorAutenticacao;

    public Entrada(GerenciadorAutenticacao gerenciadorAutenticacao) {
        setTitle("Login App");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        this.gerenciadorAutenticacao = gerenciadorAutenticacao;

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLoginButton();
            }
        });

        loginPanel.add(emailLabel);
        loginPanel.add(emailTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel);

        setVisible(true);
    }

    private void handleLoginButton() {
        String email = emailTextField.getText();
        String password = new String(passwordField.getPassword());

        Usuario usuario = gerenciadorAutenticacao.autenticar(email, password);
        if (usuario != null && usuario instanceof Administrador) {
            dispose();
            new TelaInicial((Administrador) usuario);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GerenciadorAutenticacao gerenciador = new GerenciadorAutenticacao();
                new Entrada(gerenciador);
            }
        });
    }
}
