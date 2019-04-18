package spitaldemo.rooms;

import java.util.Random;
import spitaldemo.persons.AArzt;
import spitaldemo.persons.APatient;
import spitaldemo.persons.CStationaerPatient;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Sub-Class: ABehandlungsraum 
 * |-> Masterclass: ARoom
 * 
 * |-> Method: ABehandlungsraum -> ...
 * |-> Method: AArzt -> ...
 * |-> Method: getDoctor -> ...
 * |-> Method: assignDoctor -> ...
 * |-> Method: toString -> ...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
abstract class ABehandlungsraum extends ARoom {
    
    // Attribute
    protected int maxDoctors;
    protected AArzt[] doctors; 
    
    
    // Konstruktor
    public ABehandlungsraum(String name, int maxPatients, int maxDoctors) {
        super(name, maxPatients);
        this.maxDoctors = maxDoctors;
        
         doctors = new AArzt[maxDoctors];
        // to assure that every index pointer is definitly null
        for (int counter = 0; counter < doctors.length; counter++) {
            doctors[counter] = null;            
        }
        
    } 
    
    public int getNumberOfSizeDoctors(){
        int numberOfSizeDoctors = 0;
        for(int i=0; i < this.maxDoctors; i++){
            if(doctors[i] != null){
                numberOfSizeDoctors++;
            }
        }
        return numberOfSizeDoctors;
    }
    
    //------------- getDoctor --------------------------------------------------
    public AArzt getDoctor(int index) {
        
        //negative Eingabe -> Falsche Eingabe
        if(index < 0){
            System.out.println("|-> Bitte geben Sie einen gültigen Index ein.");
            return null;
        } 
        
        //Es wurde die maximale Anzahl von Ärzte erreicht
        if(index >= doctors.length){
            System.out.println("|-> Dieser Raum kann maximal " + doctors.length + " Ärzte enthalten.");
            return null;
        }
        
        
        int numberOfSizeDoctors = 0;
        for(int i=0; i < doctors.length; i++){
            if(doctors[i] != null){
                numberOfSizeDoctors += 1;
            }
        }
        
        //1 Arzt-Sitzplatz belegt
        if(numberOfSizeDoctors == 1){
            System.out.println("|-> Im " + name + " ist " + numberOfSizeDoctors + " Arzt vorhanden.");
        }
        
        //Es sind mind. 2 Ärzte-Sitzplätze belegt
        if((numberOfSizeDoctors > 1) && (numberOfSizeDoctors < doctors.length)){
            System.out.println("|-> Im " + name + " sind " + numberOfSizeDoctors + " Ärzte vorhanden.");
        }
        

        return doctors[index];
    }
    
    //------------- leavePatient -----------------------------------------------
    public void LeaveRoom(AArzt arzt){
        if(this.maxDoctors == 0){
            System.out.println("In diesem Raum sind keine Ärzte.");
            return; 
        }
        
        //find the free seat
        int arztIndex = -1; 
        for (int index = 0; index < doctors.length; index++) {
            if(doctors[index].getName() == arzt.getName()){
                arztIndex = index; 
            }            
        }
        
        // no free seat was found
        if(arztIndex == -1){
            System.out.println("Arzt <" + arzt.getName() 
                    + "> ist nicht im Raum.");
            return;
        }
                
        // patient leaves the room - seat is now free (null) again
        patients[arztIndex] = null; 
        
        
    }
    
    
    
    //------------- assignDoctor -----------------------------------------------
    public void assignDoctor(AArzt doctor){
        if(this.maxDoctors == 0){
            System.out.println("Dieser Raum kann keine Ärzte enthalten.");
            return; 
        }
    
        for(int i = 0; i < this.maxDoctors; i++){
            if(this.doctors[i] == null){
                this.doctors[i] = doctor;
                return; 
            }
            
        }
        
        System.out.println(doctor.getName() + " kann Raum " + this.name 
                + " nicht zugeordnet werden, weil kein Platz frei ist");
        
    }
     
    //------------- toString ---------------------------------------------------
    @Override
    public String toString(){
        String s = null;
        s = "\nKlassenname: " + getClass().getName() + "\n|-> Name: " + name
                + "\n|-> maximale Patientenanzahl: " + patients.length + 
                "\n|-> maximale Ärzteanzahl: " + doctors.length;
        
        System.out.println(s);
        
                return s;
    }
    
    //------------- Treat ------------------------------------------------------
    @Override
    public void Treat(){
        
        if(this.getNumberOfSizeDoctors() == 0){
            System.out.println("In diesen " + name + " ist kein Arzt vorhanden. "
                    + "Behandlung nicht möglich");
            return;
        }
            
        int numberOfTreatablePatients = this.getNumberOfTreatablePatients(); 
        System.out.println(name + " können " + numberOfTreatablePatients + " Patienten behandelt werden.");

        for(int i=0; i<patients.length; i++){
            if(patients[i] == null){
                continue;
            }
            
            if(numberOfTreatablePatients == 0){
                continue;
            }
            
            if(patients[i].getDuration() >= 1){
                patients[i].setDuration(patients[i].getDuration()-0.5); //-1 wegen einen Tag
                numberOfTreatablePatients--;  
                continue;
            }
            
            if( (patients[i].getDuration() > 0) && (patients[i].getDuration() < 1)){
                patients[i].setDuration(0); 
                numberOfTreatablePatients--;   
                continue;

            }
            
        }
    }
    
    public int getNumberOfTreatablePatients(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
