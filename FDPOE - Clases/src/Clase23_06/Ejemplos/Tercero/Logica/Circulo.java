package Clase23_06.Ejemplos.Tercero.Logica;


public class Circulo extends FiguraGeometrica {
    private float radio;

    public Circulo() {
        super();
        this.radio = 0;        
    }
    
    public Circulo(float radio, String tipo) {
        super(tipo);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }    

    @Override
    public void calcularArea() {
        float area;
        area = (float) (Math.PI * Math.pow(radio, 2));
        setArea(area);
    }    
    
    @Override
    public void imprimirDetalles() {
        System.out.println(super.detalleHeader());       
        System.out.println("Radio   : " + getRadio());        
        System.out.println(super.detalleFooter());        
    }   
}
