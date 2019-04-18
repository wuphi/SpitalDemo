package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: StationaerPatient 
 * |-> Sublass of APatient
 * |-> Method: StationarPatient -> ...
 * |-> Method: getDuration -> ...
 * |-> Method: equals -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CStationaerPatient extends APatient {

    
    //------------- StationaererPatient ---------------------------------------- 
    public CStationaerPatient(String name) {
        super(name);

    }
    
 
    //------------- equals -----------------------------------------------------
    public boolean equals (Object o){
        
        if(o == null){
            return false;
        }
        
        CStationaerPatient a = (CStationaerPatient)o;
        if (this.name.equals(a.getName())&&duration ==a.getDuration())
            return true;
        else
            return false;
    }
}

