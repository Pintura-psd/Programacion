package Programacion.Tema6.RedSocial;

public class PublicarVideo implements IPublicacionConReaccion, IAbrirPublicacion{
   private String video;

   public PublicarVideo (String video){
       this.video = video;
   }

    @Override
    public void abrir() {

    }

    @Override
    public void publicar() {

    }

    @Override
    public void compartir() {

    }

    @Override
    public void cometar(String comentario) {

    }
}
