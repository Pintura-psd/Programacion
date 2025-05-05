package Programacion.Tema6.RedSocial;

public class PublicarTexto implements  IPublicacionConReaccion{
    private String texto;

    public PublicarTexto (String texto){
        this.texto = texto;

    }

    @Override
    public void publicar() {
        System.out.println();
        //falta rellenar los método
    }

    @Override
    public void compartir() {

    }

    @Override
    public void cometar(String comentario) {

    }
}
