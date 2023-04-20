package ub.edu.controller;

/*
 * Enum feta pel login i registre, per poder mantenir els mètodes que es criden des dels tests i que la vista pugui saber quin ha sigut el resultat
 * */
public enum SociStatus
{
    CORREU_INEXISTENT("Correu inexistent"),
    CONTRASSENYA_INCORRECTA("Contrassenya incorrecta"),
    LOGIN_CORRECTE("Login correcte"),
    SOCI_DUPLICAT("Soci Duplicat"),
    SOCI_VALIDAT("Soci Validat"),
    FORMAT_INCORRECTE("Format incorrecte");

    private final String text;

    SociStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}