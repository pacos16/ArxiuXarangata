package es.xarangata;
import java.util.List;

public class Pieza {
    
    private String nombre;
    private List<Partitura> partituras;
    private String autor;
    private String arreglista;
    private int anyo;
    //TODO crear enumeracion
    private String genero;
    private String duracion;
    private String descripcion;
    private String tituloOriginal;
    private List<String> listaMix;


    public Pieza(String nombre, List<Partitura> partituras) {
        this.nombre = nombre;
        this.partituras = partituras;
      
    }



    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", partituras='" + getPartituras() + "'" +
            ", autor='" + getAutor() + "'" +
            ", arreglista='" + getArreglista() + "'" +
            ", anyo='" + getAnyo() + "'" +
            ", genero='" + getGenero() + "'" +
            ", duracion='" + getDuracion() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", tituloOriginal='" + getTituloOriginal() + "'" +
            ", listaMix='" + getListaMix() + "'" +
            "}";
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Partitura> getPartituras() {
        return this.partituras;
    }

    public void setPartituras(List<Partitura> partituras) {
        this.partituras = partituras;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArreglista() {
        return this.arreglista;
    }

    public void setArreglista(String arreglista) {
        this.arreglista = arreglista;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTituloOriginal() {
        return this.tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public List<String> getListaMix() {
        return this.listaMix;
    }

    public void setListaMix(List<String> listaMix) {
        this.listaMix = listaMix;
    }


}
