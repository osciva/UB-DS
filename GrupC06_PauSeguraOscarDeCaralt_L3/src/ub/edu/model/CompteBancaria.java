package ub.edu.model;

import java.util.Scanner;

public class CompteBancaria implements MetodePagament {

    private String visa;
    private String cad;
    private String codi;
    private int comptador = 0;
    Scanner sc = new Scanner(System.in);

    public CompteBancaria(String visa,String cad, String codi) {
        this.visa = visa;
        this.cad = cad;
        this.codi = codi;

    }
    public int getComptador() {
        return comptador;
    }

    public void setComptador(int comptador) {
        this.comptador = comptador;
    }

    @Override
    public boolean hasDelay() {
        return true;
    }

    @Override
    public String pagar(Pagament p) {
        p.setEstatPagat();
        setComptador(getComptador()+1);
        return "Pagament complert";
    }
    public int comptador(){
        return getComptador();


    }

    @Override
    public void imprimir(Pagament p, LlistaExcursions excursions) {
        System.out.println("Mètode de pagament: Compte Bancaria");
        System.out.println("");
        System.out.println("Compte: " + getVisa());
        System.out.println("Caducitat:" + getCad());
        System.out.println("Codi:" + getCodi());
        Excursio excursio = excursions.getExcursionsMap().getOrDefault(p.getNomExcursio(), null);
        Activitat act = excursio.getActivitat(p.getNomActivitat());
        System.out.println("Valor: " + act.getPreu());




    }


    public String getCad() {
        return cad;
    }

    public String getCodi() {
        return codi;
    }

    public String getVisa() {
        return visa;
    }


    public void setVisa(String visa){
        this.visa = visa;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }



    public CompteBancaria completar(){
        System.out.println("Dona el numero de targeta");
        String visa = sc.nextLine();
        if(validarCompte(visa).equalsIgnoreCase("Numero valid")){
            System.out.println("Quan caduca?");
            String cad = sc.nextLine();
            System.out.println("Digues el codi");
            String codi = sc.nextLine();
            CompteBancaria comptebnc1 = new CompteBancaria(visa,cad,codi);
            return comptebnc1;

        }

           return null;
    }
    public String validarCompte(String compte){
        if(compte.length() == 24){
            return "Numero valid";
        }else{
            return "Numero invalid";
        }
    }
}
