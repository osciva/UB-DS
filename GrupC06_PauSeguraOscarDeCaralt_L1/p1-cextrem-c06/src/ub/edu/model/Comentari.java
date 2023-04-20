package ub.edu.model;

import java.util.Date;

public class Comentari{
    private String comentari;
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Comentari(String comentari) {
            this.comentari = comentari;
        }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }
}
