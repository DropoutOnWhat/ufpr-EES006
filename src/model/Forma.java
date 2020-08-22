package model;

import model.Superficie;

public abstract class Forma implements Superficie {
    private double medida[]; //array para medidas
    //construtor parametrizado que aloca array de medidas
    public Forma(int numMedidas) {
        medida = new double[numMedidas];
    }
    //define uma medida da forma
    public void setMedida(int i, double m) {
        if ((i > 0) || (i < medida.length) || (m < 0)) {
            medida[i -1] = m;
        }
    }
    public double getMedida(int i) {
        if ((i > 0) || (i < medida.length)) {
            return medida[i -1];
        } else {
            return -1;
        }
    }
}
