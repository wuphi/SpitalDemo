package spitaldemo.rooms;

import spitaldemo.persons.CStationaerPatient;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: Notaufnahme 
 * |-> Subclass of ABehandlungsraum
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CNotaufnahme extends ABehandlungsraum {

    public CNotaufnahme(String name) {
        super(name, 3, 3);
    }

    
    @Override
    public int getNumberOfTreatablePatients(){
        return this.getNumberOfSizeDoctors();
    }
}
