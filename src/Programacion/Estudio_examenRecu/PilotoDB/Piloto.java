package Programacion.Estudio_examenRecu.PilotoDB;

public class Piloto {
    private int conductorId;
    private String code;
    private String nombre;
    private String apellido;
    private String nacimiento;
    private String nacionalidad;
    private String url;

    public Piloto(int conductorId, String code, String nombre, String apellido, String nacimiento, String nacionalidad, String url) {
        this.conductorId = conductorId;
        this.code = code;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.nacionalidad = nacionalidad;
        this.url = url;
    }

    public Piloto() {
        this.conductorId = 0;
        this.code = "AAA";
        this.nombre = "unkown";
        this.apellido = "unkown";
        this.nacimiento = "0000-00-00";
        this.nacionalidad = "some place called world";
        this.url = "none";
    }

    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return this.conductorId + " " + this.code + " " + this.nombre + " " + this.apellido + " " + this.nacimiento + " " + this.nacionalidad + " " + url;
    }
}
