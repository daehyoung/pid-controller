package kr.luxsoft.app;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-02
 * @version: 1.0
 */
public interface OutputFilter {
   default double filter(double previous,  double rawOutput, double deltaTime){
         return rawOutput;
   }
}
