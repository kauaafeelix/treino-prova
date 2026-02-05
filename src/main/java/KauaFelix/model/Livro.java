package KauaFelix.model;


public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean isdisponivel;

    public Livro() {}

    public Livro(int id, String titulo, String autor, int anoPublicacao, boolean isdisponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isdisponivel = isdisponivel;
    }

    public Livro(String titulo, String autor, int anoPublicacao, boolean isdisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isdisponivel = isdisponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return isdisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.isdisponivel = disponivel;
    }
}
