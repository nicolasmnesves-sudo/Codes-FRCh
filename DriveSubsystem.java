package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase{

        // Motors
        private final WPI_VictorSPX front_R  = new WPI_VictorSPX(DriveConstants.FRONT_RIGHT_ID);
        private final WPI_VictorSPX back_R = new WPI_VictorSPX(DriveConstants.BACK_RIGHT_ID);
        private final WPI_VictorSPX front_L = new WPI_VictorSPX(DriveConstants.FRONT_LEFT_ID);
        private final WPI_VictorSPX back_L = new WPI_VictorSPX(DriveConstants.BACK_LEFT_ID);        

        public DriveSubsystem() {

            front_L.setInverted(true);
            back_L.setInverted(true);
            front_R.setInverted(false);
            back_R.setInverted(false);
        }

        public void arcadeDrive(double speed, double turn){

            double maxSpeed = DriveConstants.MAX_SPEED;
        
            double leftSpeed = (speed + turn) * maxSpeed;
            double rightSpeed = (speed - turn) * maxSpeed;

            front_R.set(rightSpeed);
            back_R.set(rightSpeed);
            front_L.set(leftSpeed);
            back_L.set(leftSpeed);
        }

        public void stop() {
            arcadeDrive(0, 0);
  }


}
