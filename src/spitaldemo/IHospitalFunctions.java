package spitaldemo;

import spitaldemo.persons.APatient;
import spitaldemo.rooms.ARoom;


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * INTERFACE - IHospitalFunctions
 * |-> Method: MovePatient -> ...
 * |-> Method: Treat -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public interface IHospitalFunctions {
    APatient[] DischargePatients(ARoom r);
    
    void MovePatient(APatient p, ARoom from, ARoom to);
    void Treat(ARoom r);
    
    
    
}
