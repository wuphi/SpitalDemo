/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spitaldemo;

import spitaldemo.persons.APatient;
import spitaldemo.persons.CAmbulanterPatient;
import spitaldemo.persons.CBehandelnderArzt;
import spitaldemo.persons.CNotarzt;
import spitaldemo.persons.CStationaerPatient;
import spitaldemo.rooms.CDiagnoseraum;
import spitaldemo.rooms.CNotaufnahme;
import spitaldemo.rooms.CStation;
import spitaldemo.rooms.CWarteraum;

/**
 *
 * @author bianc
 */
public class SpitalDemoWorker {
    
    //------------- MAIN -------------------------------------------------------
    public static void main(String[] args) {
        
        SpitalDemo spitalDemo = new SpitalDemo();
        
        System.out.println("----------------------------------------------------");
        System.out.println("Ist-Zustand der Patienten");
        System.out.println("----------------------------------------------------");
        
        // -->> Anlegen ambulante Patienten
        //----------------------------------
        CAmbulanterPatient aPat1 = new CAmbulanterPatient ("Anna1");
        aPat1.getName();
        aPat1.toString();
        
        CAmbulanterPatient aPat2 = new CAmbulanterPatient ("Anna2");
        aPat2.getName();
        aPat2.toString();
        
        CAmbulanterPatient aPat3 = new CAmbulanterPatient ("Anna3");
        aPat3.getName();
        aPat3.toString();
        
        CAmbulanterPatient aPat4 = new CAmbulanterPatient ("Anna4");
        aPat4.getName();
        aPat4.toString();

        
        // -->> Anlegen stationäre Patienten
        //-----------------------------------
        CStationaerPatient sPat1 = new CStationaerPatient ("Bernd1");
        sPat1.toString();
        
        CStationaerPatient sPat2 = new CStationaerPatient ("Bernd2");
        sPat2.toString();
        
        CStationaerPatient sPat3 = new CStationaerPatient ("Bernd3");
        sPat3.toString();
       
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Ist-Zustand der Ärzte");
        System.out.println("----------------------------------------------------");
        
        // -->> Anlegen ambulante Ärzte
        //------------------------------
        CNotarzt aArzt1 = new CNotarzt("Joseph", 2003);
        aArzt1.getName();
        aArzt1.toString();
        
        // -->> Anlegen stationäre Ärzte
        //-------------------------------
        CBehandelnderArzt sArzt1 = new CBehandelnderArzt("Rudolf", 1997);
        sArzt1.getName();
        sArzt1.toString();
        
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Ist-Zustand der Räume");
        System.out.println("----------------------------------------------------");        
        
        // -->> WARTERAUM
        //----------------
        CWarteraum warteraum = new CWarteraum("Warteraum");
        warteraum.getName();
        warteraum.toString();
        warteraum.getPatient(1);        // max. 6 Patienten in diesen Raum möglich  -> 0 bis 6
                                        // keine Äzte in diesen Raum möglich -> deswegen auch kein getDocotor() möglich (laut Tutor)
        //warteraum.getPatient(-1); 
        //warteraum.getPatient(7);

        // -->> Diagnoseraum
        //-------------------
        CDiagnoseraum diagnoseraum = new CDiagnoseraum("Diagnoseraum");
        diagnoseraum.getName();
        diagnoseraum.toString();
        diagnoseraum.getPatient(2);     // max. 3 Patienten in diesen Raum möglich  -> 0 bis 2
                                        // keine Äzte in diesen Raum möglich -> deswegen auch kein getDocotor() möglich (laut Tutor)          
        //diagnoseraum.getPatient(5); 
        //diagnoseraum.getPatient(-1);
        
        // -->> Notaufnahme
        //------------------
        CNotaufnahme notaufnahme = new CNotaufnahme("Notaufnahmeraum");
        notaufnahme.getName();
        notaufnahme.toString();
        notaufnahme.getPatient(1);      // max 3 Patienten in diesen Raum möglich  -> 0 bis 3
        notaufnahme.getDoctor(2);       // max 3 Ärzte in diesen Raum möglich -> 0 bis 3
        //notaufnahme.getPatient(7); 
        //notaufnahme.getPatient(-1);

        // -->> Station
        //--------------
        CStation station = new CStation("Stationsraum");
        station.getName();
        station.toString();
        station.getPatient(2);          // max 4 Patienten in diesen Raum möglich  -> 0 bis 4
        station.getDoctor(0);           // max 2 Ärzte in diesen Raum möglich -> 0 bis 2
        //diagnoseraum.getPatient(7); 
        //diagnoseraum.getPatient(-1);
        
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Patienten nach Krankheit in Räume definieren");
        System.out.println("----------------------------------------------------");
        
        warteraum.assignPatient(aPat1);
        warteraum.assignPatient(aPat2);
        warteraum.assignPatient(sPat1);
        warteraum.assignPatient(aPat3);
        warteraum.assignPatient(aPat4);
        warteraum.assignPatient(sPat2);
        //warteraum.assignPatient(sPat3);
        
        //warteraum.leaveRoom(aPat1);
        //warteraum.leaveRoom(aPat2);
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Krankheit der Patienten diagnostizieren");
        System.out.println("----------------------------------------------------");
        
        spitalDemo.MovePatient(aPat1, warteraum, diagnoseraum);
        spitalDemo.MovePatient(aPat2, warteraum, diagnoseraum);
        spitalDemo.MovePatient(sPat1, warteraum, diagnoseraum);
        
        spitalDemo.Treat(diagnoseraum);
        spitalDemo.Treat(diagnoseraum);
        spitalDemo.Treat(diagnoseraum);
        spitalDemo.Treat(diagnoseraum);
        spitalDemo.Treat(diagnoseraum);
        
        APatient[] dischargePatients = spitalDemo.DischargePatients(diagnoseraum);
        
        for(int i = 0; i < dischargePatients.length; i++){
            if(dischargePatients[i] instanceof CStationaerPatient){
                station.assignPatient(dischargePatients[i]);
                
            }
            if(dischargePatients[i] instanceof CAmbulanterPatient){
                notaufnahme.assignPatient(dischargePatients[i]);
            }
        }
        
        spitalDemo.Treat(station);
        spitalDemo.Treat(notaufnahme);
        
        notaufnahme.assignDoctor(aArzt1);
        spitalDemo.Treat(notaufnahme);
        
        
        station.assignDoctor(sArzt1);
        spitalDemo.Treat(station);
    }
}
