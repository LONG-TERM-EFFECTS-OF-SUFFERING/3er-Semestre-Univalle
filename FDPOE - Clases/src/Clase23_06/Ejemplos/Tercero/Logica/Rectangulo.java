package Clase23_06.Ejemplos.Tercero.Logica;


public class Rectangulo extends FiguraGeometrica {
    private float lado1;
    private float lado2;

     public Rectangulo() {
        super();
        this.lado1 = 0;
        this.lado2 = 0;
    }
     
    public Rectangulo(float lado1, float lado2, String tipo) {
        super(tipo);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public float getLado1() {
        return lado1;
    }

    public void setLado1(float lado1) {
        this.lado1 = lado1;
    }

    public float getLado2() {
        return lado2;
    }

    public void setLado2(float lado2) {
        this.lado2 = lado2;
    }

    @Override
    public void calcularArea() {
        float area;        
        area = lado1 * lado2;        
        setArea(area);
    }
    
    @Override
    public void imprimirDetalles() {
        System.out.println(super.detalleHeader());      
        System.out.println("Lado 1   : " + getLado1());
        System.out.println("Lado 2   : " + getLado2());
        System.out.println(super.detalleFooter());    
    }    
}
