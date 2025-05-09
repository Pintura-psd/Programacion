package Programacion.Tema7.RankingVidejuegos;

public class VideojuegoFisico extends Videojuego{
    private String tiendaCompra;
    private String estado;

    public VideojuegoFisico(String titulo, String plataforma, int nota, String tiendaCompra, String estado) {
        super(titulo, plataforma, nota);
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

    public VideojuegoFisico(String tiendaCompra, String estado) {
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

    public VideojuegoFisico() {
        this.tiendaCompra = "";
        this.estado = "";
    }

    public String getTiendaCompra() {
        return tiendaCompra;
    }

    public void setTiendaCompra(String tiendaCompra) {
        this.tiendaCompra = tiendaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String getTipo() {
        return "Fisico";
    }
}
