package Clase23_06.Ejemplos.Tercero.Logica;


public class Triangulo extends FiguraGeometrica {
    private float base;
    private float altura;

    public Triangulo() {
        this.base = 0;
        this.altura = 0;
    }
    
    public Triangulo(float base, float altura, String tipo) {
        super(tipo);
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
   
    @Override
    public void calcularArea() {
        float area;        
        area = (base * altura) / 2;        
        setArea(area);
    } 

    @Override
    public void imprimirDetalles() {
        System.out.println(super.detalleHeader());
        System.out.println("Base   : " + getBase());
        System.out.println("Altura : " + getAltura());
        System.out.println(super.detalleHeader());        
    }      
}
