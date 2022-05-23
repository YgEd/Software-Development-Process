package com.alset.htl;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class VehicleControl {
   private Object driverInput; // create input state class?
   private int safeSpeed;
   static final String VCS = "VCS";
   Logger log = new Logger(); // object for logging
   private static int brakeAmount = 5;
   public static int currSpeed;
   static public String currGear = "Park";
   static final String gears[] = {"Park", "Reverse","Neutral","Forward"};
   private static boolean wheelLocked = false;
   private boolean wheelLockedinlast15seconds = false;
   





public static boolean turnleft(){
    if (PlanningModule.turnleft()){
        if (wheelLocked){
            Logger.inLog("Event: Wheel is unlocked", VCS);
            wheelLocked = false;
            }
        Logger.inLog("Event: Vehilce turned left", VCS);
        return true;
    }
    requestWheelLock();
    Logger.inLog("Error: object too close to car to turn left", VCS);
    return false;
}

public static boolean turnright(){
    if (PlanningModule.turnleft()){
        if (wheelLocked){
        Logger.inLog("Event: Wheel is unlocked", VCS);
        wheelLocked = false;
        }
        Logger.inLog("Event: Vehilce turned right", VCS);
        return true;
    }
    requestWheelLock();
    Logger.inLog("Error: object too close to car to turn right", VCS);
    return false;
}



public static void setSpeed(int inspeed){
    if (inspeed <= 150 && inspeed >= 0){
        if (currGear == gears[1] || currGear == gears[3]){
        currSpeed = inspeed;
        Logger.inLog("Event: setting speed to " + inspeed, VCS);
        return;
        }
        Logger.inLog("Error: cannot set speed when vehilce is in gear: '" + currGear + "'", VCS);
        return;
    }
    Logger.inLog("Error: '" + inspeed + "' is not a valid speed!", VCS);
 
}

public void setbrakeAmount(int amount){
    if (amount >= 1 && amount <= 10){
        brakeAmount = amount;
        return;
    }
    Logger.inLog("Event: Setting Brake amount to " + brakeAmount, VCS);

}

public static void brake(){
    if (currSpeed >= brakeAmount){
    setSpeed(currSpeed -= brakeAmount);
    Logger.inLog("Event: Braking by " + brakeAmount + " currSpeed: " + currSpeed, VCS);
    return;
    }
    Logger.inLog("Event: Braking by " + currSpeed + " currSpeed: " + 0, VCS);
    currSpeed = 0;
}

public static void fullbrake(){
    currSpeed = 0;
    Logger.inLog("Event: Fully Braking", VCS);

}

public static void setGear(String ingear){
    //log set gear to whatever
   for(int i=0; i<gears.length; i++){
       if (ingear == gears[i]){
           currGear = ingear;
           Logger.inLog("Event: setting gear to '" + ingear + "'", VCS);
           return;
       }
   }
   
   //this will be put in log
   Logger.inLog("Error: '" + ingear + "' is an invalid gear!", VCS);

}

public static boolean startCruiseControl(int speed){
    if (currGear == "Forward"){
        if (speed <=150 && speed >= 0){
            Logger.inLog("Event: Cruise Control enabled", VCS);
            setSpeed(speed);
            return true;
        }
        
        Logger.inLog("Error: Cannot enable curise control with invalid speed: '" + speed + "'", VCS);
        return false;
    }
    
     Logger.inLog("Error: Cannot enable cruise control while in '" + currGear + "'", VCS);
    return false;
}

public static void stopCruiseControl(){
    Logger.inLog("Event: Cruise Control disabled", VCS);
}



   public static boolean requestWheelLock() {
       // TODO
       Logger.inLog("Event: Wheel is locked", VCS);
       wheelLocked = true;
        return true;
   } 

   public static boolean adaptiveLights(){
        if (SensorFusion.time >= 17 && SensorFusion.time <= 5){
            Logger.inLog("Event: headlights set to Night Mode", VCS);
            return true;
        }
        Logger.inLog("Event: headlights set to Default Mode", VCS);
        return false;

   }

   public static boolean smartWeather(){
       if (SensorFusion.rainyWeather()){
           Logger.inLog("Event: Rainy Weather detected", "SFU");
           double safespeed = PlanningModule.getSafeSpeed();
           if (SensorFusion.getSpeed() > safespeed && SensorFusion.getGear() == "Forward"){
            Logger.inLog("Event: setting speed to safety speed " + safespeed, VCS);
            setSpeed((int)safespeed);
           }
           return true;
       }
           Logger.inLog("Event: Rain Weather not detected", "SFU");
           return false;
   }

   public boolean requestAutomaticBreak() {
      // TODO
      Logger.inLog("Event: Automatic Break initiated", VCS);
      fullbrake();
      return true;
   }

   public void inputDirs() {
      // TODO
   }

   public static void main(String args[]){
    Calendar cal = GregorianCalendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
       System.out.println(hour);
   }


}



