package spitaldemo.rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import spitaldemo.persons.APatient;
import spitaldemo.persons.CAmbulanterPatient;
import spitaldemo.persons.CStationaerPatient;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: Diagnoseraum 
 * |-> Subclass of ARoom
 * |-> Method: assignDiagnosis
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CDiagnoseraum extends ARoom {

    // Konstruktor
    public CDiagnoseraum(String name) {
        super(name, 3);
    }
    
    
    //------------- Treat ------------------------------------------------------
    @Override
    public void Treat(){
        for(int i=0; i<patients.length; i++){
            if(patients[i] == null){
                continue;
            }
            
            if(patients[i].getKrankheit() == null){
                
                if(patients[i] instanceof CAmbulanterPatient){
                    patients[i].setKrankheit("ambulante KR");
                    
                    patients[i].setDuration(0.5);
                    
                    System.out.println(patients[i].getName() 
                            + " hat die Krankheit " 
                            + patients[i].getKrankheit() 
                            + " mit der Aufenthaltsdauer " 
                            + patients[i].getDuration());
                    return;
                }
                
                if(patients[i] instanceof CStationaerPatient){
                    patients[i].setKrankheit("stationäre KR");
                   
                    
                    patients[i].setDuration(this.getRandomDuration());
                    
                    System.out.println(patients[i].getName() 
                            + " hat die Krankheit " 
                            + patients[i].getKrankheit() 
                            + " mit der Aufenthaltsdauer " 
                            + patients[i].getDuration());
                    
                    return;
                }
            }
            
        }
        
    }
    
    //------------- DischargePatients ------------------------------------------
    @Override
    public APatient[] DischargePatients() {

        List<APatient> patientsToDischarge = new ArrayList<>(); 
        
        for (int counter = 0; counter < this.getMaxAmountPatients(); counter++){
            APatient patient = this.getPatient(counter);
            
            
            if(patient == null){
                continue;
            }
            
            
            if(patient.getKrankheit() != null){
                patientsToDischarge.add(patient);
                this.leaveRoom(patient);
            }

        }
        
       APatient[] toArray = patientsToDischarge.toArray(new APatient[0]);
        return toArray; 
               
    }
    
    public double getRandomDuration(){
        
        //generator -zufall - es wird gewürfelt und es kommt eine zahl zwischen 2 und 4
        //https://mein-javablog.de/java-zufallszahl/
        Random generator = new Random();
        double duration = generator.nextInt(3)+2; //3 -> zwischen 0 und 2
        return duration;
    }

}
