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
public class TestCircularQueue {

    @Test
    void test(){
         CircularQueue queue = new CircularQueue(5);
         double[] measurements = {12.1, 12.3, 12.0, 11.8, 12.2, 12.2, 12.2,12.2,12.2 };

         for (double measurement : measurements) {
             queue.enqueue(measurement);
             log.info("{}", queue.ema(0.5));
         }

         for (double value : queue) {
             System.out.println("Queue value: " + value);
         }


     }
}
