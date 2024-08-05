package kr.luxsoft.app;


public class PIDController {
    private double kP, kI, kD;
    private double setPoint;
    private double previousError;
    private double integral;
    private double previousOutput;
    final private OutputFilter filter;

    public PIDController(double kP, double kI, double kD, OutputFilter filter) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.setPoint = 0.0;
        this.previousError = 0.0;
        this.integral = 0.0;
        this.filter = filter;
    }

    public void setSetPoint(double setPoint) {
        this.setPoint = setPoint;
    }

    public double calculate(double currentValue, double deltaTime) {

        // Calculate error
        double error = setPoint - currentValue;

        // Calculate integral
        integral += error * deltaTime;

        // Calculate derivative
        double derivative = (error - previousError) / deltaTime;

        // Calculate raw PID output
        double rawOutput = kP * error + kI * integral + kD * derivative;

        // Apply filter to the output
        double filteredOutput = filter.filter(previousOutput,rawOutput, deltaTime);

        // Update previous values
        previousError = error;
        previousOutput = filteredOutput;

        return filteredOutput;
    }

    public void initializeOutput(double initialValue) {
        this.previousOutput = initialValue;
    }
}