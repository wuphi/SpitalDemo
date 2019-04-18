package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: AmbulanterPatient 
 * |-> Sublass of APatient
 * |-> Method: equals -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CAmbulanterPatient extends APatient {


    public CAmbulanterPatient(String name) {
        super(name);
    }
    
    //------------- equals -----------------------------------------------------
    @Override
    public boolean equals (Object o){
        if(o==null){
            return false;
        }
        CAmbulanterPatient a = (CAmbulanterPatient)o;
        if (this.name.equals(a.getName()))
            return true;
        else
            return false;
        
    }
}
