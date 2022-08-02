package Clase07_07.tercero.modelo;

import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;

import Clase07_07.tercero.logica.Cotizador;



public class Cotizacion implements  Serializable{
    public static final long serialVersionUID = 1L;
    private int numero;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Archivo> listaArchivos;
    private double cotizacionDolares;
    private double cotizacionPesos;
    private String tiempo;
    private String tipo;
    private double TRM;
    private int totalArchivos;
    private int totalPalabras;
    
    public Cotizacion(int numero, Funcionario funcionario, String tipo, 
        String tiempo, double TRM){
        this.numero = numero;
        this.funcionario = funcionario;
        this.TRM = TRM;
        this.tiempo = tiempo;
        this.tipo = tipo;
        listaArchivos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public double getTRM(){
        return TRM;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }   

    public double getCotizacionDolares() {
        return cotizacionDolares;
    }

    public void setCotizacionDolares(double cotizacionDolares) {
        this.cotizacionDolares = cotizacionDolares;
    }

    public double getCotizacionPesos() {
        return cotizacionPesos;
    }

    public void setCotizacionPesos(double cotizacionPesos) {
        this.cotizacionPesos = cotizacionPesos;
    }

    public int getTotalArchivos() {
        return totalArchivos;
    }

    public void setTotalArchivos(int totalArchivos) {
        this.totalArchivos = totalArchivos;
    }

    public int getTotalPalabras() {
        return totalPalabras;
    }

    public void setTotalPalabras(int totalPalabras) {
        this.totalPalabras = totalPalabras;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }            
    
    public String toString() { // Se llama cuando se imprime un objeto de este tipo
        return "Cotizacion No. " + getNumero() + "\nDolares " + getCotizacionDolares();
    }
    
    public void agregarArchivos(File[] archivos, DefaultListModel modeloLista){       
        for(File archivo : archivos) {
            if (!estaIncluido(archivo.getName(), modeloLista)){      
                try {
                    Archivo archivoSeleccionado = new Archivo(archivo);
                    archivoSeleccionado.contarPalabras();
                    listaArchivos.add(archivoSeleccionado);
                    setTotalArchivos(listaArchivos.size());
                    cotizar();
                    modeloLista.addElement(archivoSeleccionado.getArchivo().getName() + " con " 
                            + archivoSeleccionado.getCantidadPalabras() + " PALABRAS");
                } catch (IOException ex) {
                    //Logger.getLogger(Cotizador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }
   
    
    private boolean estaIncluido(String nombre, DefaultListModel modelo){
        
        boolean existe = false;
        if(modelo.size() != 0){            
            for (int i = 0; i < modelo.size(); i++){
                String nombreExistente = modelo.get(i).toString();
                StringTokenizer st = new StringTokenizer(nombreExistente);
                if (nombre.equalsIgnoreCase(st.nextElement().toString())){
                    existe = true;
                    i = modelo.size();
                }
            }            
        }        
        return existe;
    }
    
    public void actualizarCotización(){
        cotizar();
    }
    
    private void cotizar(){
        double valorPalabra = 0;
        int totalPalabras = 0;
        int totalArchivos = listaArchivos.size();
        double cotizacionDolares = 0;
        double cotizacionPesos = 0;
        if(tipo.equalsIgnoreCase("Básico")){
            if(tiempo.equalsIgnoreCase("Un día"))
                valorPalabra = 0.086; 
            else if (tiempo.equalsIgnoreCase("Entre 2 y 5 días"))
                valorPalabra = 0.076;
            else
                valorPalabra = 0.066;           
        } else{
            if(tiempo.equalsIgnoreCase("Un día"))
                valorPalabra = 0.124; 
            else if (tiempo.equalsIgnoreCase("Entre 2 y 5 días"))
                valorPalabra = 0.114;
            else
                valorPalabra = 0.11;                       
        }
        
        for(Archivo archivo : listaArchivos){
            int cantidadPalabras = archivo.getCantidadPalabras();
            totalPalabras += cantidadPalabras;
        }
        
        cotizacionDolares = totalPalabras * valorPalabra;
        cotizacionPesos = cotizacionDolares * TRM;
        setCotizacionDolares(cotizacionDolares);
        setCotizacionPesos(cotizacionPesos);
        setTotalPalabras(totalPalabras);
    }
}
