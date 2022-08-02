package Clase23_06.Ejemplos.Tercero.Logica;


public abstract class FiguraGeometrica { // Este va a ser el molde de las demas figuras
    private float area;
    private String tipo;

    public FiguraGeometrica() {
        this.area = 0;
        this.tipo = "";
    }

    public FiguraGeometrica(String tipo) {
        this.area = 0;
        this.tipo = tipo;
    }
    
    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public abstract void calcularArea();
    
    public abstract void imprimirDetalles(); 
    
    public String detalleHeader() {
        String text = "*********************************\n"
                + "Tipo   : " + getTipo() + "\n*********************************";
        return text;
    }
    
    public String detalleFooter() {
        String text = "Area     : " + getArea() + "\n*********************************";
        return text;
    }
}
