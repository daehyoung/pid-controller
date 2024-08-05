package kr.luxsoft.filters;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-05
 * @version: 1.0
 */
@Slf4j
public class ExponentialMovingAverage {
    private double alpha; // Smoothing factor
    private CircularQueue window; // Circular queue to store the latest 10 measurements

    public ExponentialMovingAverage(double alpha, int windowSize) {
        this.alpha = alpha;
        this.window = new CircularQueue(windowSize);
    }

    public double update(double measurement) {
        window.enqueue(measurement);
        return window.ema(alpha);
    }

    public double ema(){
        return window.ema(alpha);
    }
}

