import org.junit.jupiter.api.*;
import KauaFelix.service.BibliotecaService;
import KauaFelix.model.Livro;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BibliotecaServiceTest {

    private static BibliotecaService service;

    @BeforeAll
    public static void setup() {
        service = new BibliotecaService();
    }

    @Test
    @Order(1)
    public void testCadastrarLivro() {
        int id = service.cadastrarLivro("Livro Teste", "Autor Teste", 2020);
        assertTrue(id > 0);
    }

    @Test
    @Order(2)
    public void testBuscarLivroPorId() {
        Livro livro = service.buscarLivroPorId(1);
        assertNotNull(livro);
        assertEquals("Clean Code", livro.getTitulo());
    }

    @Test
    @Order(3)
    public void testListarTodosLivros() {
        List<Livro> livros = service.listarTodosLivros();
        assertTrue(livros.size() >= 4);
    }

    @Test
    @Order(4)
    public void testListarLivrosDisponiveis() {
        List<Livro> livros = service.listarLivrosDisponiveis();
        assertTrue(livros.size() >= 1);
        assertTrue(livros.stream().allMatch(Livro::isDisponivel));
    }

    @Test
    @Order(5)
    public void testAtualizarTituloLivro() {
        boolean atualizado = service.atualizarTituloLivro(1, "Clean Code Updated");
        assertTrue(atualizado);

        Livro livro = service.buscarLivroPorId(1);
        assertEquals("Clean Code Updated", livro.getTitulo());
    }

    @Test
    @Order(6)
    public void testEmprestarLivro() {
        boolean emprestado = service.emprestarLivro(2, "Kauã Felix");
        assertTrue(emprestado);

        Livro livro = service.buscarLivroPorId(2);
        assertFalse(livro.isDisponivel());
    }

    @Test
    @Order(7)
    public void testEmprestarLivroIndisponivel() {
        boolean emprestado = service.emprestarLivro(2, "Outro Cara");
        assertFalse(emprestado);
    }

    @Test
    @Order(8)
    public void testDevolverLivro() {
        boolean devolvido = service.devolverLivro(2);
        assertTrue(devolvido);

        Livro livro = service.buscarLivroPorId(2);
        assertTrue(livro.isDisponivel());
    }

    @Test
    @Order(9)
    public void testDeletarLivro() {
        int id = service.cadastrarLivro("Livro Deletar", "Autor X", 2010);

        boolean deletado = service.deletarLivro(id);
        assertTrue(deletado);

        Livro livro = service.buscarLivroPorId(id);
        assertNull(livro);
    }
}
