package model.genero;

public class generoVo {
    
    //Atributos
    private int idGenero;
    private String nombreGenero;
    private Boolean estadoGenero;

    //Metodo Constructor Vacio
    public generoVo(){

    }

    //Metodo Constructor Con Parametros
    public generoVo(int idGenero, String nombreGenero, Boolean estadoGenero){
        this.idGenero=idGenero;
        this.nombreGenero=nombreGenero;
        this.estadoGenero=estadoGenero;
    }

    //Getters Y Setters

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public Boolean getEstadoGenero() {
        return estadoGenero;
    }

    public void setEstadoGenero(Boolean estadoGenero) {
        this.estadoGenero = estadoGenero;
    }    
}
