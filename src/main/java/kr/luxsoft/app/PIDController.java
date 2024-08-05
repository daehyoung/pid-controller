package kr.luxsoft.app;


public   class PIDController {
    private double kP, kI, kD;
    private double setpoint;
    private double previousError;
    private double integral;
    private double previousOutput;
    private OutputFilter filter;

    public PIDController(double kP, double kI, double kD, OutputFilter filter) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.setpoint = 0.0;
        this.previousError = 0.0;
        this.integral = 0.0;
        this.filter = filter;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double calculate(double currentValue, double deltaTime) {
        // Calculate error
        double error = setpoint - currentValue;

        // Calculate raw PID output
        double rawOutput = kP * error; // Only proportional term is used

        // Apply filter to the output
        double filteredOutput = filter.filter(previousOutput, rawOutput, deltaTime);

        // Update previous values
        previousError = error;
        previousOutput = filteredOutput;

        return filteredOutput;
    }

    public void initializeOutput(double initialValue) {
        this.previousOutput = initialValue;
    }
}