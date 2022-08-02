package Clase07_07.tercero.logica;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

import Clase07_07.tercero.modelo.Archivo;
import Clase07_07.tercero.modelo.Cotizacion;
import Clase07_07.tercero.modelo.Funcionario;

public class Cotizador implements Serializable {
    public static final long serialVersionUID = 1L;
    private int consecutivo;
    private double TRM;
    private Funcionario funcionario;
    private ArrayList<Cotizacion> listaCotizaciones;
    
    public Cotizador(Funcionario funcionario, double TRM) {
        this.TRM = TRM;
        consecutivo = 0;
        this.funcionario = funcionario;
        listaCotizaciones = new ArrayList<>();
    }

    public int getConsecutivo() {
        return consecutivo;
    }
    
    public Cotizacion getCotizacion(int numero) {
        return listaCotizaciones.get(numero - 1);
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    public int getCantidadCotizaciones() {
        return listaCotizaciones.size();
    }
    
    
    public Funcionario getFuncionario(){
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public double getTRM() {
        return TRM;
    }
    
    public void setTRM(double TRM){
        this.TRM = TRM;
    }
    
    public void agregarCotizacion(Cotizacion cotizacion) throws IOException{
        listaCotizaciones.add(cotizacion);
        grabarCotizacion(cotizacion);
    }
    
    private void grabarCotizacion(Cotizacion cotizacion) throws IOException{
        Calendar fecha = new GregorianCalendar();
        String dia = Integer.toString(fecha.get(Calendar.DATE));
        String mes = Integer.toString(fecha.get(Calendar.MONTH));
        String annio = Integer.toString(fecha.get(Calendar.YEAR));
        DecimalFormat formato ;
        formato= new DecimalFormat("#,###,##0.00");
        FileWriter archivoTexto = new FileWriter("src/archivos/cotizacion_" + 
                cotizacion.getNumero() + ".txt");
        
        PrintWriter pw = new PrintWriter(archivoTexto);
        
        pw.println("Numero Cotizacion  : " + cotizacion.getNumero());
        pw.println("Fecha Realización  : " + dia + "-" + mes + "-" + annio);
        pw.println("Funcionario .....  : " + cotizacion.getFuncionario().getNombre());
        pw.println("Cliente .........  : " + cotizacion.getCliente().getNombre());
        pw.println("Email  ..........  : " + cotizacion.getCliente().getEmail());
        pw.println("Cantidad Archivos  : " + cotizacion.getTotalArchivos());
        pw.println("Tipo de Documento  : " + cotizacion.getTipo());
        pw.println("Tipo de Entega     : " + cotizacion.getTiempo());
        pw.println("Cotización Dolares : " + formato.format(cotizacion.getCotizacionDolares()));
        pw.println("Cotización Pesos   : " + formato.format(cotizacion.getCotizacionPesos()));
        pw.println("Lista de Archivos  : " + cotizacion.getTotalArchivos());
        ArrayList<Archivo> listaArchivos = cotizacion.getListaArchivos();
        for(Archivo archivo : listaArchivos){
            pw.println("\t" + archivo.getArchivo().getName() + " con " +
                    formato.format(archivo.getCantidadPalabras()) + " Palabras");
        }
                
        try {
           if ( archivoTexto != null)
              archivoTexto.close();
        } catch (IOException e2) {
              e2.printStackTrace();
        }
        
    }
        
}
