package frc.robot;

import java.util.Hashtable;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * This class communicates from the Raspberry Pi with serial communication
 */
class Vision {
    
    private SerialPort vision;
    
    /**
     * This constructor calls the constructor of the SerialPort class to start the communication with the RPi.
     */
    public Vision(){
        vision = new SerialPort(9600, SerialPort.Port.kMXP);
    }

    /**
     * This function return the motorspeeds based on the rotation of the robot.
     * @return a Hashtable containing the motorspeeds
     */
    public Hashtable<String, Double> getMotorSpeeds(){
        Hashtable<String, Double> speeds = new Hashtable<String, Double>();
        int rotation = 0;
        try{
            rotation = Integer.parseInt(vision.readString());
        }
        catch (Exception e){
            System.out.println("Not an integer.....");
        }

        if(Math.abs(rotation) > 50){
            if(rotation < 0){
                speeds.put("left", 0.2);
                speeds.put("right", -0.2);
            }
            else{
                speeds.put("left", -0.2);
                speeds.put("right", 0.2);
            }
        }
        else{
            speeds.put("left", 0.0);
            speeds.put("right", 0.0);
        }

        return speeds;
    }
}