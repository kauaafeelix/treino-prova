package KauaFelix.service;


import KauaFelix.infrastructure.persistence.EmprestimoRepository;
import KauaFelix.infrastructure.persistence.LivroRepository;

import KauaFelix.model.Emprestimo;
import KauaFelix.model.Livro;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private LivroRepository livroRepository = new LivroRepository();
    private EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

    public int cadastrarLivro(String titulo, String autor, int anoPublicacao) {
        Livro livro = new Livro();

        try{
            if (titulo == null || titulo.isEmpty()) {
                throw new IllegalArgumentException("O título do livro não pode ser nulo ou vazio.");
            }
            if (autor == null || autor.isEmpty()) {
                throw new IllegalArgumentException("O autor do livro não pode ser nulo ou vazio.");
            }
            if (anoPublicacao <= 1500 && anoPublicacao > LocalDate.now().getYear()) {
                throw new IllegalArgumentException("O ano de publicação é inválido.");
            }
            else {
                livro = livroRepository.cadastrarLivros(new Livro(titulo, autor, anoPublicacao, true));
                return livro.getId();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro buscarLivroPorId(int id) {

            try {
                return livroRepository.buscarLivroPorId(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    public List<Livro> listarTodosLivros() {

        List<Livro> livros = new ArrayList<>();

        try {
            livros = livroRepository.listarLivros();
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro>livros = new ArrayList<>();

        try{
            livros = livroRepository.listarLivrosDisponiveis();
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean atualizarTituloLivro(int id, String novoTitulo) {
        boolean atualizado = false;
        try {
            livroRepository.atualizarTitulo(novoTitulo, id);
            return atualizado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletarLivro(int id) {
        boolean deletado = false;
        try {
            livroRepository.deletarLivro(id);
            return deletado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean emprestarLivro(int idLivro, String nomePessoa) {
        boolean emprestado = false;

        try{
            Livro livro = livroRepository.buscarLivroPorId(idLivro);
            if (livro == null) {
                throw new IllegalArgumentException("Livro não encontrado com o ID: " + idLivro);
            }
            if (!livro.isDisponivel()) {
                return false;
            }
            else{
                emprestimoRepository.realizarEmprestimo(new Emprestimo(idLivro, nomePessoa, LocalDate.now(), null));
                livroRepository.atualizarDisponibilidade(false, idLivro);
                return emprestado = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean devolverLivro(int idLivro) {
        boolean devolvido = false;

        try{
            Livro livro = livroRepository.buscarLivroPorId(idLivro);
            if (livro == null){
                throw new IllegalArgumentException("Livro não encontrado com o ID: " + idLivro);
            }
            if (livro.isDisponivel()){
                return false;
            }
            livroRepository.atualizarDisponibilidade(true, idLivro);
            devolvido = true;
            return devolvido;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
