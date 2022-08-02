package Clase23_06.Ejemplos.Cuarto;


public class Articulo {   
    String codigo;
    double precio;

    /**
     * Constrctor de a clase Articulo
     * @param codigo
     * @param precio 
     */
    
    public Articulo(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
    
    /**
     * método que retona el código del artículo
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * método que retorna el precio del artíclo
     * @return 
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * método que retorna toda la información de un artículo como un slo Strng
     * @return 
     */    
    public String getInfoArticulo() {
        return codigo + " " + precio;
    } 
}
