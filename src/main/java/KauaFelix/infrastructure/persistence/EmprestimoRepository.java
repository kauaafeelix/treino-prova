package KauaFelix.infrastructure.persistence;

import KauaFelix.infrastructure.database.Conexao;
import KauaFelix.model.Emprestimo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {

    public Emprestimo realizarEmprestimo(Emprestimo emprestimo) throws SQLException{

        String sql = """
                INSERT INTO Emprestimo(
                id_livro,
                nome_pessoa,
                data_emprestimo )
                VALUES (?,?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setInt(1, emprestimo.getIdLivro());
            ps.setString(2, emprestimo.getNomePessoa());
            ps.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                int idGerado = rs.getInt(1);
                emprestimo.setId(idGerado);
            }
        }
        return emprestimo;
    }



    public List<Emprestimo> listarEmprestimos () throws SQLException{
        List<Emprestimo> emprestimos = new ArrayList<>();

        String sql = """
                SELECT 
                id,
                id_livro,
                nome_pessoa,
                data_emprestimo
                FROM Emprestimo
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Emprestimo emprestimo = new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("id_livro"),
                        rs.getString("nome_pessoa"),
                        rs.getObject("data_emprestimo", LocalDate.class)
                );
            emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }

    public void atualizarDevolucao(int id) throws SQLException{

        String sql = """
                UPDATE Emprestimo 
                SET data_devolucao = NOW()
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }


}
