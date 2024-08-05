package kr.luxsoft.app;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-02
 * @version: 1.0
 */
public class LowPassFilter implements OutputFilter {
    private double alpha;

    public LowPassFilter(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double filter(double previousOutput, double rawOutput, double deltaTime) {
        return alpha * rawOutput + (1 - alpha) * previousOutput;
    }
}
