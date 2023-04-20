package ub.edu.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Top10 implements  LlistaObserver{

    public  LlistaExcursions llistaExcursions;
    public CarteraSocis carteraSocis;
    public String[][] arrayReservades = new String[100][3];
    public String [][] arrayPagades = new String[100][3];


    public Top10(LlistaExcursions llistaExcursions, CarteraSocis carteraSocis) {
        this.llistaExcursions = llistaExcursions;
        this.carteraSocis = carteraSocis;



    }
    public String[][] mostraReservades(){
        List<Excursio> llista =  llistaExcursions.getExcursionsList();
        Iterator<Excursio> it = llista.iterator();
        String[][] array  = new String[100][3];
        ArrayList<Activitat> llistaActivitats = new ArrayList<>();
        while(it.hasNext()){
            Excursio e = it.next();
            Collection<Activitat> values = e.getActivitatsMap().values();
            ArrayList<Activitat> listOfValues  = new ArrayList<>(values);
            for(int i = 0; i < listOfValues.size();i++){
                Activitat a = listOfValues.get(i);
                llistaActivitats.add(a);





            }




        }
        for(int i = 0; i < llistaActivitats.size(); i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    array[i][j] = llistaActivitats.get(i).getNomExcursio();
                }if(j == 1){
                    array[i][j] = llistaActivitats.get(i).getNom();
                }if(j == 2){
                    String apuntats = String.valueOf(llistaActivitats.get(i).getApuntats());
                    array[i][j] = apuntats;
                }

            }
        }
        return array;

    }
    public String[][] mostraPagades(){
        List<Excursio> llista =  llistaExcursions.getExcursionsList();
        Iterator<Excursio> it = llista.iterator();
        String[][] array  = new String[100][3];
        ArrayList<Activitat> llistaActivitats = new ArrayList<>();
        while(it.hasNext()){
            Excursio e = it.next();
            Collection<Activitat> values = e.getActivitatsMap().values();
            ArrayList<Activitat> listOfValues  = new ArrayList<>(values);
            for(int i = 0; i < listOfValues.size();i++){
                Activitat a = listOfValues.get(i);
                llistaActivitats.add(a);


            }

        }
        for(int i = 0; i < llistaActivitats.size(); i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    array[i][j] = llistaActivitats.get(i).getNomExcursio();
                }if(j == 1){
                    array[i][j] = llistaActivitats.get(i).getNom();
                }if(j == 2){
                    String apuntats = String.valueOf(llistaActivitats.get(i).getPagaments());
                    array[i][j] = apuntats;
                }

            }
        }
        return array;

    }
    public void esborrarLlistaReservades() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
               // arrayReservades[i][j] = null;
            }
        }
    }
    public void esborrarLlistaPagades() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                //arrayPagades[i][j] = null;
            }
        }
    }



    @Override
    public void update() {
    /*  esborrarLlistaReservades();
        esborrarLlistaPagades();
        mostraPagades();
        mostraReservades();
                            */
    }
}

