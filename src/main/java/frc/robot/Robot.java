/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Controller firstDriver;
  private Controller secondDriver;
  private Drivetrain drivetrain;
  private Intake intake;

  private int i = 0;

  @Override
  public void robotInit() {
    firstDriver = new Controller(0);
    secondDriver = new Controller(1);
    intake = new Intake(4);
    drivetrain = new Drivetrain(0, 1, 2, 3);

  }

  @Override
  public void autonomousPeriodic() {
    // Put autonomous code here
  }

  @Override
  public void teleopPeriodic() {
    // drivetrain.drive(firstDriver.getAxisLStickX() * 0.5, firstDriver.getAxisLStickY() * 0.5);

    if(firstDriver.getA()){
      intake.takeIn();
      System.out.println(i++);
    }

    if(firstDriver.getB()){
      if(drivetrain.autoAlign()){
        // Shooter.shoot()
      }
    }
  }
}
