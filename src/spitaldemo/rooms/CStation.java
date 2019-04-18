package spitaldemo.rooms;

import spitaldemo.persons.CAmbulanterPatient;
import spitaldemo.persons.CStationaerPatient;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: Station 
 * |-> Subclass of ABehandlungsraum
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CStation extends ABehandlungsraum {

    public CStation(String name) {
        super(name, 4, 2);
    }

    
    @Override
    public int getNumberOfTreatablePatients(){
        return this.getNumberOfSizeDoctors()*2;
    }

}
