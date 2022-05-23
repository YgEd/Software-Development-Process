package com.alset.htl;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class SensorFusion {
    // Sensor data

    private static boolean isObjectDetected;
    private int objectDist;
    private boolean blinker;
    static int currSpeed;
    static String currGear;
    private Object currState; // create "state" interface/enum/class
    public static double newVer = 1.0;
    public static double currVer = 1.0;
    private String destLoc;
    private String currLoc;
    public static double fDist;
    public static double rDist;
    public static double lDist;
    public static double bDist;
    public static double speedlimit = 50.0;
    static Calendar cal = GregorianCalendar.getInstance();
    public static int time = cal.get(Calendar.HOUR_OF_DAY);

    // Linked objects
    private static OnBoardCam cameras = new OnBoardCam();

    // Constants
    static final String SFU = "SFU";
    static final double LONG_THRESHOLD = 30.0; // threshold for object detection in front/behind vehicle
    static final double LAT_THRESHOLD = 15.0; // threshold for object detection on sides of vehicle


    public SensorFusion() {
        SensorFusion.isObjectDetected = false;
        
    }

    public static int getSpeed(){
        currSpeed = VehicleControl.currSpeed;
        return currSpeed;
    }

    public static String getGear(){
        currGear = VehicleControl.currGear;
        return currGear;
    }

    public static boolean rainyWeather(){
        return alsetServer.isWeatherRainy;
    }

    public static double getCurrSpeedLimit(){
        return speedlimit;
    }

   

    public static void getCamData() {
        fDist = OnBoardCam.getDist(Direction.FORWARD);
        rDist = OnBoardCam.getDist(Direction.RIGHT);
        lDist = OnBoardCam.getDist(Direction.LEFT);
        bDist = OnBoardCam.getDist(Direction.BACKWARD);
    }

    

   
}
