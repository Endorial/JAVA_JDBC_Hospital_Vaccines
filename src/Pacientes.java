/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Pacientes {
    
    int nsip;
    String cnombre;
    String capellidos;
    int nedad;
    int nambulatorio;

    public Pacientes(int nsip, String cnombre, String capellidos, int nedad, int nambulatorio) {
        this.nsip = nsip;
        this.cnombre = cnombre;
        this.capellidos = capellidos;
        this.nedad = nedad;
        this.nambulatorio = nambulatorio;
    }

    public Pacientes() {
    }

    
    
    public int getNsip() {
        return nsip;
    }

    public void setNsip(int nsip) {
        this.nsip = nsip;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public void setCapellidos(String capellidos) {
        this.capellidos = capellidos;
    }

    public int getNedad() {
        return nedad;
    }

    public void setNedad(int nedad) {
        this.nedad = nedad;
    }

    public int getNambulatorio() {
        return nambulatorio;
    }

    public void setNambulatorio(int nambulatorio) {
        this.nambulatorio = nambulatorio;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "nsip=" + nsip + ", cnombre=" + cnombre + ", capellidos=" + capellidos + ", nedad=" + nedad + ", nambulatorio=" + nambulatorio + '}';
    }
    
    
    
}
