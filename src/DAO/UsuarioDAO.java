package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidades.Usuario1;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = Conexao.conectar();
    }

    public void inserirUsuario(Usuario1 usuario) {
        String sql = "INSERT INTO usuario (NOME,LOGIN,SENHA,EMAIL) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getEmail());
            


            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir usuário.");
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }
	public void deletarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
			


            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Usuário não encontrado ou falha ao deletar.");
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
	}

    public void fecharConexao() {
        Conexao.fechar();
    }
}