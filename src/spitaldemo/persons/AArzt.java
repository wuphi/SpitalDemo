package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: AArzt 
 * |-> Masterclass: APerson
 * |-> Methods: AArzt() -> ...
 * |-> Method: getYear() -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
abstract public class AArzt extends APerson {

    // Attribute
    int year; // medizinischer Abschluss

    // Konstruktor
    public AArzt(String name, int year) {
        super(name);
        this.year = year;
    }

    //------------- getYear ----------------------------------------------------
    protected int getYear() {
        return year;

    }
    
    //------------- toString ---------------------------------------------------
    @Override
    public String toString(){
        String s = null;
        s = "\nKlassenname: " + getClass().getName() + "\n|-> Name: "+ name 
                + "\n|-> Ausbildungsjahr: " + year ;
        
        System.out.println(s);
        
                return s;
    }
}
