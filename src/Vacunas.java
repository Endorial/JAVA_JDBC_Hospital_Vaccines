
/**
 *
 * @author sorin C
 */
public class Vacunas {
    
    String cnombre;
    
    
    public Vacunas(String cnombre){
        this.cnombre=cnombre;
    }

    public Vacunas() {
    }
    
    

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    @Override
    public String toString() {
        return "Vacunas{" + "cnombre=" + cnombre + '}';
    }
    
    
    
}
