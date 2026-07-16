
    package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {


  // Spark max
    private SparkMax armMotor = new SparkMax(ArmConstants.MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder armEncoder = armMotor.getEncoder();
  
  // PID
    private final PIDController armPID = new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD);

  // ArmFeedfoward
    private final ArmFeedforward armFeedforward = new ArmFeedforward(ArmConstants.kS, ArmConstants.kG, ArmConstants.kV);

  // Define posição media quando inicia o robo
    private double setpoint = ArmConstants.POSICAO_MEDIO;



  public ArmSubsystem() {
    // Config
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kBrake);

    armMotor.configure(config,
    ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
  }



  public void setSetpoint(double newSetpoint) {
    this.setpoint = newSetpoint;
  }

  public double getSetpoint() {
    return setpoint;
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  public boolean atSetpoint() {
    return Math.abs(getPosition() - setpoint) < ArmConstants.POSITION_TOLERANCE;
  }
  


  @Override
  public void periodic() {

    double currentPosition = getPosition();
    double pidOutput = armPID.calculate(currentPosition, setpoint);
    double ffOutput = armFeedforward.calculate(currentPosition, 0);

    double totalOutput = pidOutput + ffOutput;

    armMotor.set(totalOutput);
  }
}
