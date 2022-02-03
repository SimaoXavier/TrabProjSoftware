package vista;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String dnasc;
    private String sexo;
    private String tipo;
    private String dcads;
    
public Usuario() {
        this.id = 0;
        this.nome = "";        
        this.email = "";
        this.senha = "";
        this.dnasc = "";
        this.sexo = "";
        this.tipo = "";
        this.dcads = "";
}

public Usuario(int id, String nome, String email, String dnasc, String sexo, String tipo, String senha, String dcads) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dnasc = dnasc;
        this.sexo = sexo;
        this.tipo = tipo;
        this.senha = senha;
        this.tipo = tipo;
        this.dcads = dcads;        
}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDnasc() {
        return dnasc;
    }
    public void setDnasc(String dnasc) {
        this.dnasc = dnasc;
    }
    
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
        
    public String getDcads() {
        return dcads;
    }
    public void setDcads(String dcads) {
        this.dcads = dcads;
    }
}

