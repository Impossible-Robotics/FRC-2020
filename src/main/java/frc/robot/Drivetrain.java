package frc.robot;

import java.util.Hashtable;
import edu.wpi.first.wpilibj.PWMVictorSPX;


/**
 * This class drives all the motors from the drivetrain
 */
class Drivetrain{

    private PWMVictorSPX leftFrontMotor, rightFrontMotor, rightBackMotor, leftBackMotor;
    private double leftFrontCorrection = 1;
    private double rightFrontCorrection = 1.2;
    private double leftBackCorrection = 1.3;
    private double rightBackCorrection = 1;
    private Vision vision;
    
    /**
     * This constructor instantiates the motor objects
     * @param leftFrontMotor
     * @param leftBackMotor
     * @param rightFrontMotor
     * @param rightBackMotor
     */
    public Drivetrain(int leftFrontMotor, int leftBackMotor, int rightFrontMotor, int rightBackMotor){

        this.leftFrontMotor = new PWMVictorSPX(leftFrontMotor);
        this.leftBackMotor = new PWMVictorSPX(leftBackMotor);
        this.rightBackMotor = new PWMVictorSPX(rightBackMotor);
        this.rightFrontMotor = new PWMVictorSPX(rightFrontMotor);
        vision = new Vision();
    }

    /**
     * Drive the robot with the given speeds
     * @param leftSpeed
     * @param rightSpeed
     */
    public void drive(double leftSpeed, double rightSpeed){
        this.leftFrontMotor.set(leftSpeed * leftFrontCorrection);
        this.leftBackMotor.set(leftSpeed * leftBackCorrection);
        this.rightFrontMotor.set(-rightSpeed * rightFrontCorrection);
        this.rightBackMotor.set(-rightSpeed * rightBackCorrection);
    }

    /**
     * This function aligns the robot based on the given variables from getMotorSpeeds() from the Vision class
     * @return true if the robot is align, otherwise returns false
     */
    public boolean autoAlign(){
        Hashtable<String, Double> speeds = new Hashtable<String, Double>();
        speeds = this.vision.getMotorSpeeds();
        drive(speeds.get("left"), speeds.get("right"));
        return speeds.get("left") == 0;
    }


}