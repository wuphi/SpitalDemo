package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: Notarzt
 * |-> Sublass of AArzt
 * |-> Method: Notarzt -> ...
 * |-> Method: equals -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CNotarzt extends AArzt {

    //------------- Notarzt ----------------------------------------------------
    public CNotarzt(String name, int year) {
        super(name, year);
    }

    
    //------------- equals -----------------------------------------------------
    @Override
    public boolean equals(Object o) {
        CNotarzt a = (CNotarzt) o;
        if (this.name.equals(a.getName()) && year == a.getYear()) {
            return true;
        } else {
            return false;
        }
    }
}
