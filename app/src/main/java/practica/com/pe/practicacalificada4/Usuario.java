package practica.com.pe.practicacalificada4;

public class Usuario {


    private int tipo;
    private String correo;
    private String nombres;
    private String username;
    private int id;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", tipo= '" + tipo + '\'' +
                '}';
    }

    public Usuario(Integer id, String username, String nombres, String correo, Integer tipo) {
        this.id = id;
        this.username = username;
        this.nombres = nombres;
        this.correo = correo;
        this.tipo = tipo;
    }
}
