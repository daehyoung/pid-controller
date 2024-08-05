package kr.luxsoft.app;

import kr.luxsoft.filters.LowPassFilter;
import kr.luxsoft.filters.MaxChangeFilter;
import kr.luxsoft.filters.NullFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestPIDController {

    @Test
    void test0(){
        // Example usage with MaxChangeFilter
        OutputFilter filter = new NullFilter(); //
        PIDController pid = new PIDController(1, 0.0, 0.00, filter);
        pid.setSetPoint(10);

        double currentValue = 170.0;
        double deltaTime = 1.0; // Fixed control interval of 1 second

        // Initialize previous output to the current value
        pid.initializeOutput(0);
        double controlValue = 0.0;

        for (int i = 0; i < 200; i++) {
            double output = pid.calculate(currentValue, deltaTime);
            controlValue = currentValue+output;
            currentValue =  currentValue + output; // Update current value for demonstration purposes
            log.info("Step " + i + ", Output: " + output + ", Current Value: " + currentValue +", control Value: " + controlValue);
        }



    }

    @Test
    void test1(){
        // Example usage with MaxChangeFilter
        OutputFilter filter = new MaxChangeFilter(10.0); // maxChange = 10 units
//        OutputFilter filter = new NullFilter(); //
        PIDController pid = new PIDController(1, 0.0, 0.00, filter);
        pid.setSetPoint(10);

        double currentValue = 170.0;
        double deltaTime = 1.0; // Fixed control interval of 1 second

        // Initialize previous output to the current value
        pid.initializeOutput(0);
        double controlValue = 0.0;

        for (int i = 0; i < 200; i++) {
            double output = pid.calculate(currentValue, deltaTime);
            controlValue = currentValue+output;
            currentValue =  currentValue + output; // Update current value for demonstration purposes
            log.info("Step " + i + ", Output: " + output + ", Current Value: " + currentValue +", control Value: " + controlValue);
        }



    }

    @Test
    void test2(){

        double currentValue = 100.0;
        double deltaTime = 1.0; // Fixed control interval of 1 second

        OutputFilter lowPassFilter = new LowPassFilter(0.05,170.0); // alpha = 0.1

        PIDController pid = new PIDController(1.0, 0, 0, lowPassFilter);
        pid.setSetPoint(10);
        pid.initializeOutput(0);
        double controlValue = 0.0;
        for (int i = 0; i < 100; i++) {
            double output = pid.calculate(currentValue, deltaTime);
            controlValue = currentValue + output;
            currentValue =  currentValue + output;
            log.info("Step " + i + ", Output: " + output + ", Current Value: " + currentValue +", control Value: " + controlValue);

        }
    }
}
