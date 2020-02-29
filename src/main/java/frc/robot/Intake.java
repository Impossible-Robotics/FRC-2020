package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Controls the intake motor
 */
class Intake{

    private PWMVictorSPX intakeMotor;

    /**
     *  Instantiates the intakeMotor object with the given port
     * @param port
     */
    public Intake(int port){
        intakeMotor = new PWMVictorSPX(port);
    }

    /**
     * Takes the balls in
     */
    public void takeIn(){
        intakeMotor.set(0.6);
    }

    /**
     * Take out?? Probably not a really good name...
     */
    public void takeOut(){
        intakeMotor.set(0.6);

    }

}