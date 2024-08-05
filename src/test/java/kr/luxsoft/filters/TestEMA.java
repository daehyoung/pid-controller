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
public class TestEMA {

    @Test
     void test(){
        ExponentialMovingAverage emaFilter = new ExponentialMovingAverage(0.5,5);

        double[] measurements = {12.1, 12.3, 12.0, 11.8, 12.2, 12.5, 12.4,12.4,12.4, 12.4,12.4,12.4, 12.4,12.4,12.4,12.4};

        for (double measurement : measurements) {
            long start = System.nanoTime();
            double filteredValue = emaFilter.update(measurement);
            long end = System.nanoTime();
//            log.info("Time taken: {} ns",  (end - start) );
            log.info("Filtered value: {}", filteredValue);
        }
     }
}
