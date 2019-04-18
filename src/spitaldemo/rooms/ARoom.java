package spitaldemo.rooms;

import java.util.ArrayList;
import spitaldemo.persons.AArzt;
import spitaldemo.persons.APatient;
import spitaldemo.persons.CStationaerPatient;


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Master-Class: ARoom
 * |-> Method: getName -> ...
 * |-> Method: getPatient -> ...
 * |-> Method: assignPatient -> ...
 * |-> Method: leaveRoom -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
abstract public class ARoom{
    
    // Atributte
    protected String name;
    protected int maxPatients;
    protected APatient[] patients;
        

    //Konstruktor
    ARoom(String name, int maxPatients) {

        this.name = name;
        this.maxPatients = maxPatients; 
        patients = new APatient[maxPatients];
        
        // -> erzeugt soviele Arrays wie es Patientenplätze gibt
        // -> für jedes Array ist ein Speicherplatz reserviert (null)
        for (int counter = 0; counter < patients.length; counter++) {           
            patients[counter] = null;            
        }
    }

    
    //------------- getName ----------------------------------------------------
    public String getName() {
        return name;
    }
    
    
    //------------- getPatient -------------------------------------------------
    public APatient getPatient(int index) {
        
        //negative Eingabe -> Falsche Eingabe
        if(index < 0){
            System.out.println("|-> Bitte geben Sie einen gültigen Index ein.");
            return null;
        } 
        
        //Es wurde die maximale Anzahl von Patienten-Sitzplätzen erreicht
        if(index >= patients.length){
            System.out.println("|-> Dieser Raum kann maximal " + patients.length + " Patienten-Sitzplätze.");
            return null;
        }
        
        
        int numberOfSizePatients = 0;
        for(int i=0; i < patients.length; i++){
            if(patients[i] != null){
                numberOfSizePatients += 1;
            }
        }
        
        //1 Patienten-Sitzplatz belegt
        if(numberOfSizePatients == 1){
            System.out.println("|-> Im " + name + " ist " + numberOfSizePatients + " Patienten-Sitzplatz belegt.");
        }
        
        //Es sind mind. 2 Patienten-Sitzplätze belegt
        if((numberOfSizePatients > 1) && (numberOfSizePatients < patients.length)){
            System.out.println("|-> Im " + name + " sind " + numberOfSizePatients + " Patienten-Sitzplätze belegt.");
        }
        

        return patients[index];
        
    }
    
   
    //------------- assignPatient ----------------------------------------------
    public void assignPatient(APatient patient){
        
        int freeSeatIndex = 0;
        
        //wieviele Patientensitzplätze sind frei
        for(int i = 0; i < patients.length; i++){
            if(patients[i] == null){
                freeSeatIndex = freeSeatIndex + 1;
            }
        }
        
        //wenn freie Plätze vorhanden sind dann teile den Patienten einen Patienten-Sitzplatz zu
        if(freeSeatIndex > 0)
        {
            for(int i = 0; i < patients.length; i++){
                if(patients[i] == null){
                    patients[i] = patient;
                    System.out.println(patient.getName() + " hat den Sitzplatz " + (i+1) + " im " + name);
                    return;
                }
            }
        }else{
            System.out.println("Im " + name + " sind keine freien Sitzeplätze mehr frei");
        }
        
    }
    
   
    //------------- leavePatient -----------------------------------------------
    public void leaveRoom(APatient patient){
        
        boolean patientInRoom = false;   
        
        //Patient im Raum suchen
        for(int i = 0; i < maxPatients; i++){
            
            if(patients[i]==null){
                continue;
            }
            
            //Patient befindet sich im Raum
            if(patients[i].getName().equals(patient.getName())){
                patients[i] = null;     //Sitzplatz wird frei
                System.out.println(patient.getName() + " verlässt den Sitzplatz " + (i+1) + " im " + name);
                patientInRoom = true;   //Patient ist im Raum vorhanden
                return;
            }
        }

        //gesuchte Patient ist nicht im Raum
        if(patientInRoom == false){
            System.out.println("Der Patient " + patient + "befindet sich nicht im " + name);
            return;
        }

        
    }
    
    
    //------------- toString ---------------------------------------------------
    public String toString(){
        String s = null; 
        
        s = "\nKlassenname: " +getClass().getName() + "\n|-> Name: "+ name
                + "\n|-> maximale Patientenanzahl des Raumes: " + patients.length;
        
        System.out.println(s);
        return s;
    }

    
    //------------- getMaxAmountPatients ---------------------------------------
    public int getMaxAmountPatients() {
        return this.maxPatients;
    }
    
    
    //------------- Treat ------------------------------------------------------
    public void Treat(){
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    
    //------------- DischargePatients ------------------------------------------
    public APatient[] DischargePatients() {

        ArrayList<APatient> patientsToDischarge = new ArrayList<>(); 
        
        for (int counter = 0; counter < this.getMaxAmountPatients(); counter++){
            APatient patient = this.getPatient(counter);
            
            if(patient == null){
                continue;
            }
            
            if(patient instanceof CStationaerPatient){
                CStationaerPatient statPatient = (CStationaerPatient)patient;
                
                if(statPatient.getDuration() == 0){
                    patientsToDischarge.add(patient);
                    this.leaveRoom(patient);
                }

            }
            
        }
        
        return (APatient[]) patientsToDischarge.toArray(); 
               
    }
}
