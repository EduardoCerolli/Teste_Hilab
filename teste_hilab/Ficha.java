package teste_hilab;

public class Ficha {
    private String nome;
    private String sobrenome;
    private String email;
    private String categoria;
    private String nascimento;

    Ficha (String nome, String sobrenome, String email, String Categoria, String nascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.categoria = Categoria;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNascimento() {
        return nascimento;
    }
    
    public String getCategoria() {
        return categoria;
    }
        
    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}