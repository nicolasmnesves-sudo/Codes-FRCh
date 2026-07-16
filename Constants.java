package frc.robot;

public final class Constants {

  public static final class DriveConstants {
    // Motors IDs Constants 
    public static final int FRONT_LEFT_ID = 3;
    public static final int BACK_LEFT_ID = 4;
    public static final int FRONT_RIGHT_ID = 1;
    public static final int BACK_RIGHT_ID = 2;

    // Sensor Constant
     public static final int SENSOR_CHANNEL = 9;

    // Velocidade máxima do robô (0 a 1)
    public static final double MAX_SPEED = 0.2;

   // public static final double SENSOR_SLOW_SPEED = 0.05;
  }

  // ArmConstants
  public static final class ArmConstants {
    public static final int MOTOR_ID = 3;

    // Ganhos do PID
    public static final double kP = 0.07;
    public static final double kI = 0.00;
    public static final double kD = 0.007;

    // Ganhos do Feedforward (ks = atrito, kg = gravidade, kv = velocidade)
    public static final double kS = 0.0;
    public static final double kG = 0.05;
    public static final double kV = 0.0;

    // Posições do braço
    public static final double POSICAO_BAIXO = -0.350;
    public static final double POSICAO_MEDIO = 1.150;
    public static final double POSICAO_CIMA = 2.900;

    // Limite de potência do motor do braço
    public static final double MAX_OUTPUT = 0.4;

    // Tolerância para considerar que o braço chegou no setpoint
    public static final double POSITION_TOLERANCE = 0.05;
  }
  
  // AutoConstants 
  public static final class AutoConstants {
    public static final double AUTO_DRIVE_TIME = 3.0;
    public static final double AUTO_DRIVE_SPEED = 0.1;
  }
}
