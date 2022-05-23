package com.alset.htl;

import java.util.Random;

public class PlanningModule {
    private boolean isWeatherRainy;
    private int currSpeed;
    private boolean userPerm;
    private boolean hasArrived;
    
    public PlanningModule() {
        // TODO
    }

    public static double getSafeSpeed() {
        double safeSpeed;
        safeSpeed = Math.floor(0.66*SensorFusion.getCurrSpeedLimit());
        return safeSpeed;
    }

    //returns an int of 1's and 0's 
    //with 1 meaning turn right and 0 meaning turn left
   public static int getDirs(String dest){
        int output = 0;
        Random rand = new Random();
        int amount = rand.nextInt(8);
        if (amount == 0){
            amount++;
        }
        System.out.println(amount);
        for (int i=0; i<=amount; i++){
            int perCent = rand.nextInt(10);
            if (perCent <= 5){
                output++;
                output *= 10;
            }
            else{
                output *=10;
            }
        }
        Logger.inLog("Event: directions calculated for '" + dest + "'", "PLN");
        return output;
   }

    public static boolean turnleft(){
        SensorFusion.getCamData();
        if (SensorFusion.lDist <= 85){
            return true;
        }
        else return false;
    }

    public static boolean turnright(){
        SensorFusion.getCamData();
        if (SensorFusion.rDist <= 85){
            return true;
        }
        else return false;
    }

    // public static void main(String[] args) {
    //     // TODO: replace with business logic
        
    //     System.out.println(PlanningModule.getDirs());
    // }
}
