/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Drive_With_Joysticks;
import oi.limelightvision.limelight.frc.LimeLight;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private LimeLight _limelight;
  private WPI_TalonSRX motorLeft;
  private WPI_TalonSRX motorRight;
  private DifferentialDrive differentialDrive1;


  public DriveTrain() {

      _limelight = new LimeLight();

      motorLeft = new WPI_TalonSRX(0);
      motorRight = new WPI_TalonSRX(1);
      
      differentialDrive1 = new DifferentialDrive(motorLeft, motorRight);
      
      differentialDrive1.setSafetyEnabled(true);
      differentialDrive1.setExpiration(0.1);
      differentialDrive1.setMaxOutput(1.0);

      
  }

  @Override
  public void initDefaultCommand() {

      setDefaultCommand(new Drive_With_Joysticks());


      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
      // Put code here to be run every loop

  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void My_DriveArchade(double xSpeed, double zRotation) {
      differentialDrive1.arcadeDrive(xSpeed, zRotation);
  }

  public LimeLight gLimeLight(){
      return _limelight;
  }
}