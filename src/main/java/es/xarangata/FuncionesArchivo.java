package es.xarangata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FuncionesArchivo{

    public static final String ANSI_RESET = "\u001B[0m";
  

    public static final String ANSI_MAGENTA = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public BuscaInstrumentos carpetasRecursivo(String filePath,int profundidad,BuscaInstrumentos buscaInstrumentos){
        File carpeta = new File(filePath);
        //Bucle principal que recorre todas las carpetas
        File[] lista=carpeta.listFiles();
        for(int i=0;i<lista.length;i++){

            // Do things here
            if (lista[i].isDirectory()) {
                profundidad++;
                
                buscaInstrumentos.buscaInstrumentos(lista[i]);;
                
                carpetasRecursivo(lista[i].getAbsolutePath(),profundidad,buscaInstrumentos);
                profundidad--;
            }
            
        }
        
        return buscaInstrumentos;
    }

    //Creación de informes
    public ArrayList<Pieza> creaInforme(BuscaInstrumentos buscaInstrumentos){
        HashMap<String,ArrayList<Partitura>> piezaPartituraMap=new HashMap<>();
        for(Partitura p : buscaInstrumentos.getPartituras()){
            ArrayList<Partitura> partituras = piezaPartituraMap.get(p.getNombre());
            if (partituras != null){
                partituras.add(p);
            }else{
                partituras=new ArrayList<>();
                partituras.add(p);
            }

            piezaPartituraMap.put(p.getNombre(), partituras);

        }        

        ArrayList<Pieza> piezas=new ArrayList<>();
        piezaPartituraMap.forEach((key,object)->{
             piezas.add(new Pieza(key, object));
        });
        return piezas;
    }


    public HashMap<File,ArrayList<String>> analizarPieza(Pieza pieza,HashMap<String,String[]> diccionario){
        HashMap<String,Integer> ocurrenciasInstrumentos =new HashMap<>();
        HashMap<File,ArrayList<String>> ficheroMap = new HashMap<>();
        System.out.println(pieza.getNombre());
        pieza.getPartituras().forEach((partitura)->{
            if(partitura.getInstrumento()==null){
                System.out.println(" "+ANSI_RED+pieza.getNombre()+" "+partitura.getInstrumento()+" "+partitura.getVoz()+" "+partitura.getFile().getName()+ANSI_RESET);
            }else{
                //comprobar numero instrumentos
                diccionario.keySet().forEach((instrumento)->{
                    if(partitura.getInstrumento().equals(instrumento)){
                        int ocurrencias =1;
                        if(ocurrenciasInstrumentos.containsKey(instrumento)){
                            ocurrencias=ocurrenciasInstrumentos.get(instrumento);
                        }
                        ocurrenciasInstrumentos.put(instrumento, ocurrencias);
                    }
                });            

                // comparar ficheros
                ArrayList<String> listaInstrumentoVoz ;
                if(ficheroMap.containsKey(partitura.getFile())){
                listaInstrumentoVoz=ficheroMap.get(partitura.getFile()); 
                }else{
                    listaInstrumentoVoz=new ArrayList<>();
                }
                listaInstrumentoVoz.add(partitura.getInstrumento()+" "+partitura.getVoz());
                ficheroMap.put(partitura.getFile(), listaInstrumentoVoz);
                String color=ANSI_GREEN;
                if(ficheroMap.get(partitura.getFile()).size()>1){
                    color=ANSI_MAGENTA;
                }
                System.out.println(" "+color+pieza.getNombre()+" "+partitura.getInstrumento()+" "+partitura.getVoz()+" "+partitura.getFile().getName()+ANSI_RESET);
            }

            

        });

        return ficheroMap;
    }



    // Creación de nueva bbdd

    // Creación mongo

}