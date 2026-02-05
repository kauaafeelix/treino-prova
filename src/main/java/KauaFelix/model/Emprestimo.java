package KauaFelix.model;

import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private int idLivro;
    private String nomePessoa;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo() {}

    public Emprestimo(int id, int idLivro, String nomePessoa, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.idLivro = idLivro;
        this.nomePessoa = nomePessoa;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(int idLivro, String nomePessoa, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.idLivro = idLivro;
        this.nomePessoa = nomePessoa;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(int id, int idLivro, String nomePessoa, LocalDate dataEmprestimo) {
        this.id = id;
        this.idLivro = idLivro;
        this.nomePessoa = nomePessoa;
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
