package ub.edu.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayPal implements MetodePagament {


    private final String correu;
    private int comptador = 0;


    Scanner sc = new Scanner(System.in);


    public PayPal(String correu) {
        this.correu = correu;

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
        System.out.println("Mètode de pagament: PayPal");
        System.out.println("");
        System.out.println("Correu: " + getCorreu());
        Excursio excursio = excursions.getExcursionsMap().getOrDefault(p.getNomExcursio(), null);
        Activitat act = excursio.getActivitat(p.getNomActivitat());
        System.out.println("Valor: " + act.getPreu());

    }


    public String getCorreu() {
        return correu;
    }
    public boolean validarCorreu(String correu){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }

    public void completar(){
        System.out.println("Dona el correu");
        String correu = sc.nextLine();
        if(this.validarCorreu(correu) == true){
            System.out.println("Correu correcte");

        }else{
            System.out.println("Correu no existent");
        }

    }







}