
class LoginPorto {
    private String usuario;
    private String senha;
    private String email;

    public LoginPorto(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginPorto{usuario='" + usuario + "', senha='" + senha + "', email='" + email + "'}";
    }
}



