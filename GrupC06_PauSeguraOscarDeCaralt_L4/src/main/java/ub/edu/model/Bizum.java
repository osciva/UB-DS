package ub.edu.model;

import java.util.Scanner;

public class Bizum implements MetodePagament {

    private final String telefon;
    private final String missatge;
    private int comptador = 0;

    Scanner sc = new Scanner(System.in);


    public Bizum(String telefon, String missatge) {
        this.telefon = telefon;
        this.missatge = missatge;

    }

    public int getComptador() {
        return comptador;
    }

    public void setComptador(int comptador) {
        this.comptador = comptador;
    }

    @Override
    public boolean hasDelay() {
        return false;
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

        System.out.println("Mètode de pagament: Bizum");
        System.out.println("");
        System.out.println("Num Telefon: " + getTelefon());
        System.out.println("Comentari " + getMissatge());
        Excursio excursio = excursions.getExcursionsMap().getOrDefault(p.getNomExcursio(), null);
        Activitat act = excursio.getActivitat(p.getNomActivitat());
        System.out.println("Valor: " + act.getPreu());

    }


    public String getTelefon() {
        return telefon;
    }

    public String getMissatge() {
        return missatge;
    }

    public String validarNumero(String num){
        if(num.length() == 9){
            return "Numero valid";
        }else{
            return "Numero invalid";
        }
    }

   /* public Bizum completar(){
        System.out.println("Dona el numero de telèfon");
        String num = sc.nextLine();
        if(this.validarNumero(num).equals("Numero valid")){
            System.out.println("Quin missatge poses?");
            String msg = sc.nextLine();
            Bizum bizum1 = new Bizum(num,msg);
            return bizum1;

    }
        return null;*/




}








