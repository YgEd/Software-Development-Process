package com.alset.htl;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;

/**
 * Creates a file called Log.txt if it doesn't exist and writes logs to it.
 * If Log.txt already exists, it appends log messages to it.
 */
public class Logger {
  // Constant
  private static final String filename = "Log.txt";


  /**
   * Add a new log message to the log.
   * 
   * @param msg  the message to log
   * @param from the class or module the message is being logged from
   */
  public static void inLog(String msg, String from) {
    if (msg.length() >= 1023){
      msg = "LogError: Log message exceeds 1024 bytes";
    }


    LocalTime time = LocalTime.now();
    String logmsg = time + " | " + "Received from '" + from + "' | " + msg + "\n";
   
    try {
      File logFile = new File(filename);
      logFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // write all of the logs to the end of the log file
    try {
      // FileWriter second parameter 'true' makes it append instead of overwriting
      FileWriter myWriter = new FileWriter(filename, true);
      myWriter.write(logmsg);
      myWriter.close();
    } catch (IOException f) {
      f.printStackTrace();
    }
  }



  /**
   * Writes all logs to the log file, then clears the logs from memory.
   */


  /**
   * Clear the Log.txt file.
   */
  public static void clear() {
    try {
      FileWriter myWriter = new FileWriter(filename);
      myWriter.write("ALSET VEHICLE LOGS\n");
      myWriter.close();
    } catch (IOException f) {
      f.printStackTrace();
    }
  }

}
