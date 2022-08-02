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

public class Video188_ {
    public static void main(String[] args) {
        // La clase String implementa la interfaz Comparable y esta a su vez el metodo compareTo (en orden alfabetico)
        TreeSet<Article> articles = new TreeSet<>(); 
            
        articles.add(new Article("CPrimer articulo", 1));
        articles.add(new Article("BSegundo articulo", 20));
        articles.add(new Article("ATercer articulo", 3));
       
        for (Article article:articles) {
            System.out.println(article.getDescription());
        }
        
        //ArticleComparator articleComparator = new ArticleComparator();
        TreeSet<Article> articles2 = new TreeSet<>((Article o1, Article o2) -> { // Clase interna anonima
            String articleDescription1 = o1.getDescription();
            String articleDescription2 = o2.getDescription();
        
            return articleDescription1.compareTo(articleDescription2);
        });
        
        articles2.add(new Article("CPrimer articulo", 1));
        articles2.add(new Article("BSegundo articulo", 20));
        articles2.add(new Article("ATercer articulo", 3));
        
        for (Article article:articles2) {
            System.out.println(article.getDescription());
        }        
    }
}

class Article implements Comparable<Article> { 
    private String description;
    private int ID;
     
    public Article() {
        
    }
    
    public Article(String description, int ID) {
        this.description = description;
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }
            
    @Override
    public int compareTo(Article o) {     
        return ID - o.ID;       
    }
}

class ArticleComparator implements Comparator<Article> { // Creamos una clase aparte porque no siempre
    // la clase del propio objeto implementa un Comparator
    
    public int compare(Article o1, Article o2) {
        String articleDescription1 = o1.getDescription();
        String articleDescription2 = o2.getDescription();
        
        return articleDescription1.compareTo(articleDescription2);
    }    
}