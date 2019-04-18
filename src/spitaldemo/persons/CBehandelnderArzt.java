package spitaldemo.persons;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: BehandelnderArzt 
 * |-> Sublass of AArzt
 * |-> Method: BehandelnderArzt -> ....
 * |-> Method: equals -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CBehandelnderArzt extends AArzt {

    //------------- BehandelnderArzt -------------------------------------------
    public CBehandelnderArzt(String name, int year) {
        super(name, year);
    }
    
    
    //------------- equals -----------------------------------------------------
    @Override
    public boolean equals (Object o){
         CBehandelnderArzt a = (CBehandelnderArzt)o;
        if (this.name.equals(a.getName())&&year==a.getYear())
            return true;
        else
            return false;
    }
}
