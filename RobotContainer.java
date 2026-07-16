package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.ArmPositionCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;


public class RobotContainer {
  // DriveSubsystem
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  // Controller
  CommandXboxController driver = new CommandXboxController(0);
  // Arm
  ArmSubsystem armSubsystem = new ArmSubsystem();

  
  // --- == ---

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, driver));
    configureButtonBindings();
  }

  private void configureButtonBindings() {

    driver.a().onTrue(new ArmPositionCommand(armSubsystem, ArmConstants.POSICAO_BAIXO));

    driver.x().onTrue(new ArmPositionCommand(armSubsystem, ArmConstants.POSICAO_MEDIO));

    driver.b().onTrue(new ArmPositionCommand(armSubsystem, ArmConstants.POSICAO_CIMA));

  }


  public Command getAutonomousCommand(){return null;};
}
