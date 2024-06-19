import DAO.UsuarioDAO;
import entidades.Usuario1;


public class App {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Exemplo de inserção de usuário
        Usuario1 novoUsuario = new Usuario1("Emerson","Emerson21","12345678","emerson21@gmail.com");
        usuarioDAO.inserirUsuario(novoUsuario);

        usuarioDAO.deletarUsuario(0);

        usuarioDAO.fecharConexao();
    }
}
