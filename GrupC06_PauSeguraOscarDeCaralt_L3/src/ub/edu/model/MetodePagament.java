package ub.edu.model;

public interface MetodePagament {

    public boolean hasDelay();

    String pagar(Pagament p);


    void imprimir(Pagament p, LlistaExcursions excursions);

}





















