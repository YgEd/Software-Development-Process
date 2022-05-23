package com.alset.htl;

import java.util.Optional;
import java.util.Random;

import javafx.util.converter.PercentageStringConverter;

/**
 * Represents a direction of one of the four sides of the car
 * that a mounted camera can exist.
 */
enum Direction {
    RIGHT,
    LEFT,
    FORWARD,
    BACKWARD
}

public class OnBoardCam {
    private Optional<Double> rDist, lDist, bDist, fDist;

    public OnBoardCam() {
        rDist = null;
        lDist = null;
        bDist = null;
        fDist = null;
    }

    private static  int getNum(){
        Random rand = new Random();
        int perCent = rand.nextInt(100);

        return perCent;
        
    }

    public static int getDist(Direction dir){
        switch(dir){
            case LEFT:
                return getNum();                
            case RIGHT:
                return getNum();  
            case FORWARD:
                return getNum();  
            case BACKWARD:
                return getNum();  
        }
        return -1;
        
    }

    

  

}


