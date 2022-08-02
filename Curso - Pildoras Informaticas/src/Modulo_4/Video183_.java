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

package Modulo_4;

import java.util.*;

public class Video183_ {
    public static void main(String[] args) {
        Client client1 = new Client("Antonio Banderas", "0001", 5000);
        Client client2 = new Client("Penelope Cruz", "0002", 5500);
        Client client3 = new Client("Julio Iglesias", "0003", 7000);
        Client client4 = new Client("Antonio Banderas", "0001", 5000);
        // Analziando el caso escogemos el tipo de coleccion que vamos a usar, en nuestro caso
        // no vamos a repetir clientes, y por ahora no pensamos ordenarlos, asi que nos conviene
        // usar una coleccion del tipo Set
        
        Set<Client> bankClients = new HashSet<Client>();
        
        bankClients.add(client1);
        bankClients.add(client2);
        bankClients.add(client3);
        bankClients.add(client4); // Como esta repetido no lo agrega
        /*
        for (Client bankClient:bankClients) {
            System.out.println(bankClient.getName() + " " + bankClient.getAccountNumber()
            + " " + bankClient.getBalance());
        }
        */
        Iterator<Client> it = bankClients.iterator();
        
        while(it.hasNext()) { // Mientras haya cosas que recorrer
            Client currentClient = it.next(); // Hacemos que salte, para que retorne el objeto
            
            String name = currentClient.getName(); 
            String accountNumber = currentClient.getAccountNumber();
            double balance = currentClient.getBalance();
            /* // Una forma de remover un cliente dado un nombre
            if(name.equals("Penelope Cruz")) {
                it.remove();
            }
            */ // Cosa que no podemos hacer en el for each porque nos salta la excepcion de
            // ConcurrentModificationException (no podemos recorrer y modificar al mismo tiempo)
            System.out.println(name + " " + " " + accountNumber + " " + balance);
            
        }
        
        if(client1.equals(client4)) { // Equals no esta preparado para discernir entre los objetos
            // que hemos creado
            System.out.println("Son el mismo cliente");
        } else {
            System.out.println("No son el mismo cliente");
        }
        /*
        // hashCodes diferentes
        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());
        
        client1 = client4; // Hacemos que los identificadores hagan referencia al mismo objeto
        */
        // hashCodes iguales
        System.out.println(client1.hashCode());
        System.out.println(client4.hashCode());
        
    }
}

class Client {
    private String name;
    private String accountNumber;
    private double balance;
    
    public Client(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    /*
    public boolean equals(Object obj) { // Con esto ya
        if(obj instanceof Client other) {          
            return (accountNumber.equals(other.getAccountNumber())); // Son iguales si tienen el mismo
            // numero de cuenta
        } else {
            return false;
        }
    }
    */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.accountNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        return Objects.equals(this.accountNumber, other.accountNumber);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}