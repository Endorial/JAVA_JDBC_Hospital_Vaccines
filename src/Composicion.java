
import java.io.Serializable;

public class Composicion implements Serializable {
    
    private String principioActivo;
    private int cantidad;
    private String base;
    private int porcentajeBase;

    public Composicion(String principioActivo, int cantidad, String base, int porcentajeBase) {
        this.principioActivo = principioActivo;
        this.cantidad = cantidad;
        this.base = base;
        this.porcentajeBase = porcentajeBase;
    }

    public Composicion() {
    }
    
    

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getPorcentajeBase() {
        return porcentajeBase;
    }

    public void setPorcentajeBase(int porcentajeBase) {
        this.porcentajeBase = porcentajeBase;
    }

    @Override
    public String toString() {
        return "Composocion{" + "principioActivo=" + principioActivo + ", cantidad=" + cantidad + ", base=" + base + ", porcentajeBase=" + porcentajeBase + '}';
    }
    
    
    
}
