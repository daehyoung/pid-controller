package kr.luxsoft.filters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-05
 * @version: 1.0
 */
@Slf4j
public class TestKalmanFilter {
    @Test
   void test(){
       KalmanFilter kf = new KalmanFilter(0.1, 0.1, 25.0); // Initial values

       double[] measurements = {23.0, 24.5, 22.0, 23.5, 24.0, 25.0, 26.5, 27.0};

       for (double measurement : measurements) {
           double filteredValue = kf.update(measurement);
           log.info("Filtered value: {}", filteredValue);
       }
   }


   @Test
   void test2(){
       KalmanFilter kf = new KalmanFilter(0.1, 0.1, 25.0); // Initial values
       // Experiment with different q and r values
       kf.setProcessNoiseCovariance(0.2);
       kf.setMeasurementNoiseCovariance(0.05);

       double[] measurements = { 23.0, 24.5, 22.0, 23.5, 24.0, 25.0, 26.5,27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0, 27.0};

       for (double measurement : measurements) {
           double filteredValue = kf.update(measurement);
           log.info("Filtered value: {}", filteredValue);
       }

   }
}
