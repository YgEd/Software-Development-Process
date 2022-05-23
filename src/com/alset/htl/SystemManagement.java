package com.alset.htl;

public class SystemManagement {
   private String systemVer;
   private String serverVer;
   
   public SystemManagement() {
       // TODO
   }

   public static boolean retrieveUpdate() {
       Logger.inLog("Event: fetching latest update from Alset Servers", "SYS");
        if (alsetServer.mostRecentVer != SensorFusion.currVer){
            Logger.inLog("Event: new update version " + alsetServer.mostRecentVer + " from Alset Servers", "SYS");
            SensorFusion.newVer = alsetServer.mostRecentVer;
            return true;

        }
        else {
        Logger.inLog("Event: no new update from Alset Servers", "SYS");
        return false;
        }
    }

   public static boolean getUpdate() {
       if (SensorFusion.currVer != SensorFusion.newVer){
        SensorFusion.currVer = SensorFusion.newVer;
        Logger.inLog("Event: new update version " + alsetServer.mostRecentVer + " from Alset Servers installed successfully", "SYS");
        return true;
       
   }
   Logger.inLog("Error: cannot do 'getUpdate()' software is already most up to date", "SYS");
   return false;
}

}
