package KauaFelix.infrastructure.persistence;

import KauaFelix.infrastructure.database.Conexao;
import KauaFelix.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    public Livro cadastrarLivros(Livro livro) throws SQLException {

        String sql = """
                INSERT INTO Livro (
                titulo,
                autor,
                ano_publicacao,
                disponivel )
                VALUES (?,?,?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getAnoPublicacao());
            ps.setBoolean(4, livro.isDisponivel());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                int idGerado = rs.getInt(1);
                livro.setId(idGerado);
            }
        }
        return livro;
    }


    public List<Livro>listarLivros() throws SQLException{

        List<Livro> livros = new ArrayList<>();

        String sql = """
                SELECT
                id, 
                titulo,
                autor,
                ano_publicacao,
                disponivel
                FROM Livro
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

           ResultSet rs = ps.executeQuery();

           while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anoPublicacao = rs.getInt("ano_publicacao");
                boolean disponivel = rs.getBoolean("disponivel");

                Livro livro = new Livro(id, titulo, autor, anoPublicacao, disponivel);
                livros.add(livro);
           }

        }
        return livros;
    }

    public Livro buscarLivroPorId(int id) throws SQLException{

        String sql = """
                SELECT
                id, 
                titulo,
                autor,
                ano_publicacao,
                disponivel
                FROM Livro
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao"),
                        rs.getBoolean("disponivel")
                );
                return livro;
            }

        }
        return null;
    }

    public void atualizarDisponibilidade(boolean disponivel, int id) throws SQLException{

        String sql = """
                UPDATE Livro
                SET disponivel = ?
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setBoolean(1, disponivel);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void deletarLivro(int id) throws SQLException{

        String sql = """
                DELETE FROM Livro
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Livro> listarLivrosDisponiveis() throws SQLException{
        List<Livro> livros = new ArrayList<>();

        String sql = """
                SELECT
                id, 
                titulo,
                autor,
                ano_publicacao,
                disponivel
                FROM Livro
                WHERE disponivel = true
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anoPublicacao = rs.getInt("ano_publicacao");
                boolean disponivel = rs.getBoolean("disponivel");

                Livro livro = new Livro(id, titulo, autor, anoPublicacao, disponivel);
                livros.add(livro);
            }

        }
        return livros;
    }

    public void atualizarTitulo(String novoTitulo, int id) throws SQLException{

        String sql = """
                UPDATE Livro
                SET titulo = ?
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, novoTitulo);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
