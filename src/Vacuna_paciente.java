/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Vacuna_paciente {
    
    int npaciente;
    int nvacuna;
    int ndosis;

    public Vacuna_paciente(int npaciente, int nvacuna, int ndosis) {
        this.npaciente = npaciente;
        this.nvacuna = nvacuna;
        this.ndosis = ndosis;
    }

    public Vacuna_paciente() {
    }
    
    

    public int getNpaciente() {
        return npaciente;
    }

    public void setNpaciente(int npaciente) {
        this.npaciente = npaciente;
    }

    public int getNvacuna() {
        return nvacuna;
    }

    public void setNvacuna(int nvacuna) {
        this.nvacuna = nvacuna;
    }

    public int getNdosis() {
        return ndosis;
    }

    public void setNdosis(int ndosis) {
        this.ndosis = ndosis;
    }

    @Override
    public String toString() {
        return "Vacuna_paciente{" + "npaciente=" + npaciente + ", nvacuna=" + nvacuna + ", ndosis=" + ndosis + '}';
    }
    
    
    
}
