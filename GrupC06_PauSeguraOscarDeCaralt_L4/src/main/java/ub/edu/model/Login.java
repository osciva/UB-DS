package ub.edu.model;

import ub.edu.controller.SociStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

 private CarteraSocis carteraSocis;

    public Login(CarteraSocis carteraSocis) {
        this.carteraSocis = carteraSocis;
    }
    public boolean isPasswordSegur(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean isMail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }
    public String validatePassword(String b) {
        if (!isPasswordSegur(b)) {
            return "Contrassenya no segura";
        } else
            return "Contrassenya segura";
    }
    public String validateUsername(String b) {
        if (!isMail(b))
            return "Correu en format incorrecte";
        else
            return "Correu en format correcte";
    }


    public String recuperarContrassenya(String username){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return "Correu inexistent";
        }
        return soci.getPwd();
    }


    public SociStatus RegistrarSoci(String username, String password) {
        if  (carteraSocis.find(username) != null)
            return SociStatus.SOCI_DUPLICAT;
        else if (isMail(username) && isPasswordSegur(password)){
            Soci soci = new Soci(username, password);
            carteraSocis.addSoci(soci);

            return SociStatus.SOCI_VALIDAT;
        }
        else return SociStatus.FORMAT_INCORRECTE;
    }
    public SociStatus loguejarSociStatus(String username, String password){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return SociStatus.CORREU_INEXISTENT;
        }
        if(soci.getPwd().equals(password)){
            return SociStatus.LOGIN_CORRECTE;
        }else{
            return SociStatus.CONTRASSENYA_INCORRECTA;
        }
    }
    public boolean isVisa(String visa){
        if(visa.length() == 16){
            return true;

        }else{
            return false;
        }
    }
    public boolean isCodi(String codi){
        if(codi.length() == 3){
            return true;
        }else{
            return  false;
        }

    }
    public boolean isCad(String cad){
        String a = String.valueOf(cad.charAt(2));
        if(cad.length() == 5 && a.equals("/") ){
            return true;
        }else{
            return false;
        }

    }






}
