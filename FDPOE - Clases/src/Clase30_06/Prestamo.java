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

package Clase30_06;


/**
 *  CLASE:     Prestamo
 *  INTENCION: Representar un prestamo (con toda la informacion de uno)
 *  RELACION:  NINGUNA 
 */


public class Prestamo {
    private float amount;
    private int monthsNumber;
    private float valuation;
    private float fee;
    private float finalBalance; // Esta variable me va a ayudar en la generacion de la tabla
    
    public Prestamo(float amount, int monthsNumber) {
        this.amount = amount;
        this.monthsNumber = monthsNumber;
        finalBalance = amount;
        setValuation();
        setFee();
    }

    public void setValuation() {
        if(amount < 1500000) {
            if(monthsNumber < 12) {
                valuation = 2.5f / 100; // Las tasas son porcentajes
            } else { // Caso mayor o igual 15
                valuation = 1.8f / 100;
            }
        } else if(1500000 <= amount && amount <= 3000000) { // Que el monto este entre esas cantidades
            if(monthsNumber < 12) {
                valuation = 1.9f / 100;
            } else { // Caso mayor o igual 15
                valuation = 1.7f / 100;
            }            
        } else {
            valuation = 1.5f / 100;
        }
    }

    public void setFee() {
        double formula = amount * ((Math.pow(1 + valuation, monthsNumber) * valuation)/ (Math.pow(1 + valuation, monthsNumber) - 1));
        fee = Math.round(formula);
    }
    
    public float[][] getTable(){
        float[][] table = new float[monthsNumber][5];
        
        for(int i = 0; i < monthsNumber; i++) {
            table[i][0] = finalBalance;
                        
            float interest = finalBalance * valuation;
            float payment = fee - interest;
            finalBalance -= payment;
            
            table[i][1] = interest;
            table[i][2] = fee;
            table[i][3] = payment;
            table[i][4] = finalBalance;
        }                                       
        return table;
    }
    
    public void showTable() {
    float[][] table = getTable();
    
        System.out.println("Mes \t Saldo \t Interes \t Cuota \t Abono \t Saldo Final");
    
        for(int i = 0; i < monthsNumber; i++) {
            System.out.print((i + 1) + "\t");
            
            for(int j = 0; j < 5; j++) {
               System.out.print(table[i][j] + "\t"); 
            }
            System.out.println("");
        }
    }
}


