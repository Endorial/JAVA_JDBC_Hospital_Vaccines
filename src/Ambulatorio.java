/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Ambulatorio {
    
    int ncodigo;
    String cnombre;
    String cdireccion;
    String ctelefono;

    public Ambulatorio(int ncodigo, String cnombre, String cdireccion, String ctelefono) {
        this.ncodigo=ncodigo;
        this.cnombre = cnombre;
        this.cdireccion = cdireccion;
        this.ctelefono = ctelefono;
    }

    public Ambulatorio() {
    }
    
    

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    
    
    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCdireccion() {
        return cdireccion;
    }

    public void setCdireccion(String cdireccion) {
        this.cdireccion = cdireccion;
    }

    public String getCtelefono() {
        return ctelefono;
    }

    public void setCtelefono(String ctelefono) {
        this.ctelefono = ctelefono;
    }

    @Override
    public String toString() {
        return "Ambulatorio{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", cdireccion=" + cdireccion + ", ctelefono=" + ctelefono + '}';
    }

   
    
    
    
}
