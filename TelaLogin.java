import javax.swing.*; 
import java.awt.*;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario; // Campo de texto para o usuário
    private JPasswordField campoSenha; // Campo de senha (oculta os caracteres)
    private JButton botaoLogin; // Botão para fazer login
    public TelaLogin(){
        JFrame frame = new JFrame("Minha Janela"); // Cria uma nova janela com título
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela

        frame.setLayout(new BorderLayout()); // Define o layout da janela como BorderLayout

        JPanel painel = new JPanel(new GridBagLayout()); // Cria um painel com GridBagLayout para organizar componentes
        GridBagConstraints c = new GridBagConstraints(); // Cria constraints para posicionar componentes no GridBagLayout
        c.insets = new Insets(15, 12, 12, 12); // Define margens internas entre componentes
        c.anchor = GridBagConstraints.LINE_END; // Alinha componentes à direita

        c.gridx = 0; // Define coluna 0
        c.gridy = 0; // Define linha 0
        painel.add(new JLabel("Usuário:"), c); // Adiciona rótulo "Usuário:" na posição (0,0)

        campoUsuario = new JTextField(15); // Cria campo de texto com 15 colunas
        c.gridx = 1; // Muda para coluna 1
        c.gridy = 0; // Mantém linha 0
        c.anchor = GridBagConstraints.LINE_START; // Alinha à esquerda
        painel.add(campoUsuario, c); // Adiciona o campo de usuário na posição (1,0)

        c.gridx = 0; // Volta para coluna 0
        c.gridy = 1; // Muda para linha 1
        c.anchor = GridBagConstraints.LINE_END; // Alinha à direita
        painel.add(new JLabel("Senha:"), c); // Adiciona rótulo "Senha:" na posição (0,1)

        campoSenha = new JPasswordField(15); // Cria campo de senha com 15 colunas
        c.gridx = 1; // Muda para coluna 1
        c.gridy = 1; // Mantém linha 1
        c.anchor = GridBagConstraints.LINE_START; // Alinha à esquerda
        painel.add(campoSenha, c); // Adiciona o campo de senha na posição (1,1)

        botaoLogin = new JButton("Entrar"); // Cria botão "Entrar"
        botaoLogin.addActionListener(e -> autenticar()); // Adiciona ação ao clicar no botão
        c.gridx = 1; // Coluna 1
        c.gridy = 2; // Linha 2
        c.anchor = GridBagConstraints.CENTER; // Centraliza
        painel.add(botaoLogin, c); // Adiciona o botão na posição (1,2)

        frame.add(painel, BorderLayout.CENTER); // Adiciona o painel ao centro da janela
        frame.pack(); // Ajusta o tamanho da janela aos componentes
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true); // Torna a janela visível
    }

    private void autenticar() {
        String usuario = campoUsuario.getText(); // Obtém o texto do campo usuário
        String senha = new String(campoSenha.getPassword()); // Obtém a senha como string

        if ("admin".equals(usuario) && "1234".equals(senha)) { // Verifica se usuário e senha estão corretos
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE); // Mostra mensagem de sucesso
        } else { // Caso contrário
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE); // Mostra mensagem de erro
        }
    }
}
