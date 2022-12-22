package es.xarangata;

import java.io.File;
import java.io.IOException;

public class Main{
    public static int i;
    public static void main(String[] args) {

        /*
        String filepath="D:\\xaranga\\ARXIU\\Xaranga";
        
        FuncionesArchivo funcionesArchivo = new FuncionesArchivo();

        BuscaInstrumentos buscador = (BuscaInstrumentos) funcionesArchivo.carpetasRecursivo(filepath,0,new BuscaInstrumentos());       
        int i=0;
        for(Partitura partitura:buscador.getPartituras()){
            if(partitura.getInstrumento()!=null && (partitura.getFile().getName().contains(".pdf") || partitura.getFile().getName().contains(".jpg"))){
                i++;
            }
        }

        funcionesArchivo.creaInforme(buscador).forEach((pieza)->{
            funcionesArchivo.analizarPieza(pieza, DiccionarioInstrumentos.getDiccionario());
        });
        System.out.println(i);
        File pdf=new File("D:/xaranga/ARXIU/Arreglos Xarangata/Pulp Dogs/Pulp Dogs.pdf");
        
        try {
            PdfUtils.pdfSplitterPorInstrumentos(pdf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("IOE");
        }
        */
        File image=new File("D:\\xaranga\\ARXIU\\Xaranga\\Mecano\\Mecano.pdf");
        try{

            PdfUtils.ReadImageText(image);
        }catch(IOException ioe){
            System.out.println("IOE");
        }
    }
    

}