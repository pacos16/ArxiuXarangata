package es.xarangata;

import java.util.ArrayList;
import java.util.HashMap;

public class DiccionarioInstrumentos{

    public static HashMap<String,String[]> getDiccionario(){
        HashMap<String, String[]> hashMap = new HashMap<>();
        hashMap.put("CAJA",new String[]{"caja","caixa","tambor","caxa"});
        hashMap.put("BOMBO",new String[]{"bombo","drum"});
        hashMap.put("PLATOS",new String[]{"platos","plats","platillos","cymbal"});
        hashMap.put("TIMBALES",new String[]{"timbal","kettledrums"});
        hashMap.put("PERCUSION",new String[]{"drums","percu"});
        hashMap.put("LIRA",new String[]{"lira"});
        hashMap.put("XILOFONO",new String[]{"xilofon","xilófon","xilòfon"});
        hashMap.put("BATERIA",new String[]{"drum set","bater"});
        hashMap.put("TROMPETA",new String[]{"trumpet","trompe","tromprta","tpta","flisco"});
        hashMap.put("TUBA",new String[]{"tub","bass","baix","bajo"});
        hashMap.put("SAXO TENOR",new String[]{"tenor"});
        hashMap.put("SAXO ALTO",new String[]{"alt"});
        hashMap.put("SAXO BARITONO",new String[]{"bariton"});
        hashMap.put("SAXO SOPRANO",new String[]{"soprano"});
        hashMap.put("TROMBON",new String[]{"tromb"});
        hashMap.put("CLARINETE",new String[]{"clarinet"});
        hashMap.put("FLAUTA",new String[]{"flauta","flute","flautes"});
        hashMap.put("OBOE",new String[]{"oboe"});
        hashMap.put("TROMPA",new String[]{"trompa"});
        hashMap.put("BOMBARDINO",new String[]{"bombardi"});
        hashMap.put("REQUINTO",new String[]{"requint"});
        return hashMap;
    }
    

    public static ArrayList<String> getVoces(){

        ArrayList<String> voces =new ArrayList<>();
        voces.add("principal");
        voces.add("pral");
        voces.add("1");
        voces.add("2");
        voces.add("3");
        voces.add("4");
        return voces;
    }
    

}
    
