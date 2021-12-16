// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class SimpleTankTrapezoid extends CommandBase {
  /** Creates a new SimpleTankTrapezoid. */
  private int state;
  private double maxVelocity = 0.8;
  private double acceleration = 0.1;
  private double stoppingDistance = 1.0;
  private double targetDistance;
  private double startingPosition;
  private Drive m_drive;
  private double velocity;

  public SimpleTankTrapezoid(Drive drive, double requestedDistance) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);

    m_drive = drive;
    targetDistance = requestedDistance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    state = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (state) {
      case 0: // Get ready
        velocity = 0;
        startingPosition = m_drive.getAveragePosition();
        state++;
        break;
      case 1: // accellerate
        velocity = velocity + acceleration;
        if (velocity >= maxVelocity) {
          velocity = maxVelocity;
          state++;
        }
        break;
      case 2: // cruise
        if ((m_drive.getAveragePosition() - startingPosition) > (targetDistance - stoppingDistance)) {
          state++;
        }
        break;
      case 3: // decellerate
        velocity = velocity - acceleration;
        if (velocity <= 0.0) {
          velocity = 0.0;
          state++;
        }
        break;
      case 4: // stop
        state++;
        break;
    }

    m_drive.set(velocity, velocity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return state > 4;
  }
}
