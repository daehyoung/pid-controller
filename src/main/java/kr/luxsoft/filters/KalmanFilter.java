package kr.luxsoft.filters;

/**
 *  x, 추정 오차 공분산 p, 프로세스 노이즈 공분산 q, 측정 노이즈 공분산 r, 그리고 칼만 이득 k를 포함합니다.
 */
public class KalmanFilter {
    /**
     * 프로세스 노이즈 공분산 q
     */
    private double q; // process noise covariance

    /**
     * 측정 노이즈 공분산 r
     */
    private double r; // measurement noise covariance

    /**
     * 상태 변수 x
     */
    private double x; // value
    /**
     * 추정 오차 공분산 p
     */
    private double p; // estimation error covariance

    /**
     * 칼만 이득 k
     */
    private double k; // kalman gain

    public KalmanFilter(double q, double r, double initialValue) {
        this.q = q;
        this.r = r;
        this.x = initialValue;
        this.p = 1.0;
    }

    public void setProcessNoiseCovariance(double q) {
        this.q = q;
    }

    public void setMeasurementNoiseCovariance(double r) {
        this.r = r;
    }

    public double update(double measurement) {
        // Prediction update
        p = p + q;

        // Measurement update
        k = p / (p + r);
        x = x + k * (measurement - x);
        p = (1 - k) * p;

        return x;
    }


}

