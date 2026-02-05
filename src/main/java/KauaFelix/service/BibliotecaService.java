package KauaFelix.service;


import KauaFelix.infrastructure.persistence.EmprestimoRepository;
import KauaFelix.infrastructure.persistence.LivroRepository;

import KauaFelix.model.Livro;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaService {

    private LivroRepository livroRepository = new LivroRepository();
    private EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

    public int cadastrarLivro(String titulo, String autor, int anoPublicacao) {
        // implementar
        return 0;
    }

    public Livro buscarLivroPorId(int id) {
        // implementar
        return null;
    }

    public List<Livro> listarTodosLivros() {
        // implementar
        return null;
    }

    public List<Livro> listarLivrosDisponiveis() {
        // implementar
        return null;
    }

    public boolean atualizarTituloLivro(int id, String novoTitulo) {
        // implementar
        return false;
    }

    public boolean deletarLivro(int id) {
        // implementar
        return false;
    }

    public boolean emprestarLivro(int idLivro, String nomePessoa) {
        // implementar regra
        return false;
    }

    public boolean devolverLivro(int idLivro) {
        // implementar regra
        return false;
    }
}
