package practica.com.pe.practicacalificada4;

public class Usuario {


    private Integer tipo;
    private String correo;
    private String nombres;
    private String password;
    private String username;
    private Integer id;

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", tipo= '" + tipo + '\'' +
                '}';
    }

    public Usuario(Integer id, String username, String password, String nombres, String correo, Integer tipo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.correo = correo;
        this.tipo = tipo;
    }
}
