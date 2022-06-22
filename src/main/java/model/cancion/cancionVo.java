package model.cancion;


public class cancionVo {
    //Atributos
    private int idCancion;
    private String nombreCancion;
    private String fechaGrabacion;
    private String duracionCancion;
    private Boolean estadoCancion;

    //Metodo Constructor Vacio
    public cancionVo(){

    }

    //Metodo Constructor Con Parametros
    public cancionVo(int idCancion, String nombreCancion ,String fechaGrabacion,String duracionCancion , Boolean estadoCancion ){
        this.idCancion=idCancion;
        this.nombreCancion=nombreCancion;
        this.fechaGrabacion=fechaGrabacion;
        this.duracionCancion=duracionCancion;
        this.estadoCancion=estadoCancion;

    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getFechaGrabacion() {
        return fechaGrabacion;
    }

    public void setFechaGrabacion(String fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public Boolean getEstadoCancion() {
        return estadoCancion;
    }

    public void setEstadoCancion(Boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }


}
