package ub.edu.model;

public class CompteBancari {

    private int num_id;
    private String entitat;
    private String oficina;
    private String num_entitat;

    public CompteBancari(int num_id, String entitat, String oficina, String num_entitat) {
        this.num_id = num_id;
        this.entitat = entitat;
        this.oficina = oficina;
        this.num_entitat = num_entitat;
    }

    public int getNum_id() {
        return num_id;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public String getEntitat() {
        return entitat;
    }

    public void setEntitat(String entitat) {
        this.entitat = entitat;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNum_entitat() {
        return num_entitat;
    }

    public void setNum_entitat(String num_entitat) {
        this.num_entitat = num_entitat;
    }


    public void crearCompte(int num_id, String entitat, String oficina, String num_entitat){

        CompteBancari compte = new CompteBancari(num_id, entitat, oficina, num_entitat);

    }
}