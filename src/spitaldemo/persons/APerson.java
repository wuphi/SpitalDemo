package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Master-Class: APerson
 * |-> Method: getName -> ...
 * |-> Method: toString -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
abstract public class APerson {

    // Atributte
    protected String name;

    
    //Konstruktor
    APerson(String name) {

        this.name = name;
    }

    
    //------------- getName ----------------------------------------------------
    public String getName() {

        return name;
    }
    
    //------------- toString ---------------------------------------------------
    @Override
    public String toString(){
        String s;
        s = "\nKlassenname: " +getClass().getName() + "\n|-> Name: "+ name;
                
        System.out.println(s);
        
        return s;
    }
}
