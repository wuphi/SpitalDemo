package spitaldemo;

import java.util.ArrayList;
import java.util.List;

import spitaldemo.persons.APatient;
import spitaldemo.persons.CAmbulanterPatient;
import spitaldemo.persons.CBehandelnderArzt;
import spitaldemo.persons.CNotarzt;
import spitaldemo.persons.CStationaerPatient;

import spitaldemo.rooms.ARoom;
import spitaldemo.rooms.CWarteraum;
import spitaldemo.rooms.CDiagnoseraum;
import spitaldemo.rooms.CNotaufnahme;
import spitaldemo.rooms.CStation;


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Master-Class: SpitalDemo
 * |-> Method: DischargePatients -> ....
 * |-> Method: MovePatient -> ...
 * |-> Method: Treat -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class SpitalDemo implements IHospitalFunctions {

    public SpitalDemo() {
        
        
    }

    //------------- DischargePatients ------------------------------------------
    @Override
    public APatient[] DischargePatients(ARoom room) {

        return room.DischargePatients();
               
    }

    
    //------------- MovePatient ------------------------------------------------
    @Override
    public void MovePatient(APatient patient, ARoom from, ARoom to) {
       
        for (int counter = 0; counter < from.getMaxAmountPatients(); counter++){
            APatient fromPatient = from.getPatient(counter);
            
                       
            if(patient.equals(fromPatient)){
                from.leaveRoom(patient);
                to.assignPatient(patient);
                return; 
            }
        }        
    }

    
    //------------- Treat ------------------------------------------------------
    @Override
    public void Treat(ARoom r) {
        r.Treat();
    }

}
