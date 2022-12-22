package es.xarangata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class BuscaInstrumentos { 

    private ArrayList<Partitura> partituras;

    public BuscaInstrumentos(){
        
        partituras = new ArrayList<>();
    }
    public void buscaInstrumentos(File file){
        File[] archivos = file.listFiles();
        //Diccionario de instrumentos con sus sinonimos
        //TODO pasar diccionario por parametro
        HashMap<String,String[]> diccionario = DiccionarioInstrumentos.getDiccionario(); 
        //Recorremos todos los archivos de la carpeta y los comparamos con el diccionario
        for (int i=0; i< archivos.length;i++){
            if(archivos[i].isFile()) comparaNombresConDiccionario(archivos[i], diccionario);
        }
    }

    public void comparaNombresConDiccionario(File file,HashMap<String,String[]> diccionario){
        Partitura partitura = new Partitura();
        //Asignamos a nombre de la Partitura el nombre de su carpeta padre
        partitura.setNombre(file.getParentFile().getName());
    
        partitura.setFile(file);
        //Recorremos todo el diccionario
        diccionario.forEach((instrumento,nombresInstrumentos)->{
            //Recorremos los instrumentos
            for(int i=0;i<nombresInstrumentos.length;i++){
                //Comparamos el nombre del fichero con los sinonimos de cada instrumento
                if(file.getName().toLowerCase().contains(nombresInstrumentos[i])){
                    //Si el nombre coincide establecemos el instrumento
                    partitura.setInstrumento(instrumento);
                    //Obtenemos el diccionario de voces y lo recorremos
                    //TODO Externalizar diccionario voces en caso de necesitarlo
                    for(String voz : DiccionarioInstrumentos.getVoces()){
                        if(file.getName().toLowerCase().contains(voz)){
                            //En caso de encontrar una voz, asignamos voz y creamos una partitura
                            //para posteriormente guardarla en el array.
                            partitura.setVoz(voz);
                            partituras.add(new Partitura(partitura));
                        }
                        
                    }
                }
            }
            //En caso de encontrar instrumento pero no encontrar voz generamos un nuevo objeto partitura y lo guardamos
            if(partitura.getInstrumento()!=null && partitura.getInstrumento().equals(instrumento) && partitura.getVoz()==null){
                partituras.add(new Partitura(partitura));
            }
        });
        //En caso de no encontrar instrumento lo guardamos para procesarlo posteriormente en el informe.
        if(partitura.getInstrumento()==null){
            partituras.add(new Partitura(partitura));
        }
    }

    public ArrayList<Partitura> getPartituras(){
        return this.partituras;
    }
}

