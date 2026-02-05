package KauaFelix.infrastructure.database;

import java.sql.SQLException;

public class ConexaoTeste {

    public static void main(String[] args) {
        try{
            Conexao.conectar();
            System.out.println("Conexao feita com Sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro na Conexao." + e.getMessage());
        }
    }
}
