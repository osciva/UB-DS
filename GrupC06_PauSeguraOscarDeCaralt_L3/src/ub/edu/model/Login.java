package ub.edu.model;

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
    public String validateRegisterSoci(String username, String password) {
        if (isMail(username) && isPasswordSegur(password)) {
            Soci Soci = carteraSocis.find(username);
            if (Soci != null) {
                return "Soci Duplicat";
            } else return "Soci Validat";
        } else return "Format incorrecte";
    }
    public String loguejarSoci(String username, String password){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return "Correu inexistent";
        }
        if(soci.getPwd().equals(password)){
            return "Login correcte";
        }else{
            return "Contrassenya incorrecta";
        }
    }
    public String recuperarContrassenya(String username){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return "Correu inexistent";
        }
        return soci.getPwd();
    }







}
