package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends Command{

    private final DriveSubsystem drive;
    private final CommandXboxController controller;

    public ArcadeDriveCommand(DriveSubsystem drive, CommandXboxController driver){
        this.drive = drive;
        this.controller = driver;
        addRequirements(drive);
    }

    @Override
        public void execute(){
            double speed = controller.getLeftY();
            double turn = controller.getLeftX();
            drive.arcadeDrive(speed, turn);
        }
    
    @Override
        public void end(boolean interrupted){
                drive.stop();
        }
}
