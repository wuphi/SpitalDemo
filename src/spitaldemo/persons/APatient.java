package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: APatient
 * |-> Masterclass: APerson
 * |-> Method: APatient -> ....
 * |-> Method: setKrankheit -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
abstract public class APatient extends APerson {

    protected double duration; 
    
    // Attribute
    private String krankheit;

    // Konstruktor
    public APatient(String name) {
        super(name);

    }

    //------------- setKrankheit -----------------------------------------------
    public void setKrankheit(String krankheit) {

        this.krankheit = krankheit;

    }

    //------------- getKrankheit -----------------------------------------------
    public String getKrankheit() {

        return krankheit;
    }
    
    //------------- getDuration ------------------------------------------------
    public double getDuration() {
        return this.duration; 
    }

    
    //------------- setDuration ------------------------------------------------
    public void setDuration(double duration) {
        this.duration = duration; 
        System.out.println(name + " muss noch " + this.duration + " Tage behandelt werden.");
    }
    
    
}

