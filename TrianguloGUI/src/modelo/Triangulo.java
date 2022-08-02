/*

                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ Brandon Calderón Prieto  
       .---.         
      /     \   calderon.brandon@correounivalle.edu.co     
      \.@-@./               
      /`\_/`\               202125974
     //  _  \\        
    | \     )|_        Ingeniería de sistemas
   /`\_`>  <_/ \
   \__/'---'\__/

 */

package modelo;

/**
 *  CLASE:     Triangulo  
 *  INTENCION: Representar un triangulo.
 *  RELACION:  NINGUNA 
 */

public class Triangulo {
    
    private float base;
    private float altura;
    private float area;

    public Triangulo() { // Constructor sin argumentos
        // Recordemos que los floats terminan en f
        this.base = 0.0f;
        this.altura = 0.0f;
        this.area = 0.0f;
    }
    public Triangulo(float base, float altura) { // Constructor con argumentos
        this.base = base;
        this.altura = altura;
        this.area = 0.0f;
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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void calcularArea(){        
        this.area = (getBase() * getAltura()) / 2.0f; // Para un triangulo rectángulo
        // Es 2.0 por la peculiaridad como se comportan los floats
    }
}
