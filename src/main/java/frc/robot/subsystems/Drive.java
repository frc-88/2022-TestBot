// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  private TalonFX m_left, m_right;

  public Drive() {
    m_left = new TalonFX(Constants.leftMotorControllerID);
    m_right = new TalonFX(Constants.rightMotorControllerID);
  }

  public void set(double left, double right) {
    m_left.set(TalonFXControlMode.PercentOutput, left);
    m_right.set(TalonFXControlMode.PercentOutput, right);
  }

  public double getAveragePosition() {
    return ( m_left.getSelectedSensorPosition() + m_right.getSelectedSensorPosition() ) / 2.0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
