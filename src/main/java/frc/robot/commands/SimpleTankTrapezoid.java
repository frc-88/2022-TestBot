// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SimpleTankTrapezoid extends CommandBase {
  /** Creates a new SimpleTankTrapezoid. */
  private int state;

  public SimpleTankTrapezoid() {
    // Use addRequirements() here to declare subsystem dependencies.
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
        // do stuff
        break;
      case 1: // accellerate
        // do other stuff
        break;
      case 2: // cruise
        // more stuff!!!!
        break;
      case 3: // decellerate
        // more stuff!!!!
        break;
      case 4: // stop
        break;
    }
    state++;
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
