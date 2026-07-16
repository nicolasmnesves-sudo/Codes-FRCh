package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ArmPositionCommand extends Command {

  private final ArmSubsystem arm;
  private final double targetPosition;

  public 
  ArmPositionCommand(ArmSubsystem arm, double targetPosition) {
    this.arm = arm;
    this.targetPosition = targetPosition;
    addRequirements(arm);
  }

  @Override
  public void initialize() {
    arm.setSetpoint(targetPosition);
  }

  @Override
  public boolean isFinished() {
   
    return arm.atSetpoint();
  }
}
