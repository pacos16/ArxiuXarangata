package es.xarangata;

import java.io.File;

public class Partitura{
    private String nombre;
    private String instrumento;
    private String voz;
    private File file;

    public Partitura(){

    }
    public Partitura(Partitura partitura){
        this.nombre=partitura.nombre;
        this.instrumento=partitura.instrumento;
        this.voz=partitura.voz;
        this.file=partitura.file;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", instrumento='" + getInstrumento() + "'" +
            ", voz='" + getVoz() + "'" +
            ", file='" + getFile().getName() + "'" +
            "}";
    }


    public String getNombre(){
        return this.nombre;
    }

    public String getInstrumento(){
        return this.instrumento;
    }
    public String getVoz(){
        return this.voz;
    }

    public File getFile(){
        return this.file;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setInstrumento(String instrumento){
        this.instrumento=instrumento;
    }

    public void setVoz(String voz){
        this.voz=voz;
    }

    public void setFile(File file){
        this.file=file;
    }


}