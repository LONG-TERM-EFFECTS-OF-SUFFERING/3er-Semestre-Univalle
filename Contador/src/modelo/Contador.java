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
 *  CLASE:     Contador  
 *  INTENCION: LLevar la cuenta de clicks que hace el usuario, ademas de tener otras funcionalidades
 *  RELACION:  NINGUNA 
 */

public class Contador {
    private int cuenta;
    
    public Contador() {
        cuenta = 0;
    }
    
    public int getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void aumentarCuenta() {
        cuenta++;
    }
    
    public void disminuirCuenta() {
        cuenta--;
    }
    
    public void reinciarCuenta() {
        cuenta = 0;
    }    
}