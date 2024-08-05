package kr.luxsoft.app;


public class PIDController {

    /***
     * proportional gain
     */
    private double kP;
    /***
     *  integral gain
     */
    private double kI;
    /***
     *  derivative gain
     */
    private double kD;

    /**
     * Set point
     * 설정값
     */
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

    /**
     *
     * @param currentValue - 현재 값
     * @param deltaTime - 시간 간격
     * @return
     */
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