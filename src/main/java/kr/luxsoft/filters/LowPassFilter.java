package kr.luxsoft.filters;

import kr.luxsoft.app.OutputFilter;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-02
 * @version: 1.0
 */
public class LowPassFilter implements OutputFilter {
    private double alpha;
    double maxValue;

    public LowPassFilter(double alpha,double maxValue) {
        this.alpha = alpha;
        this.maxValue = maxValue;
    }

    @Override
    public double filter(double previous,   double rawOutput, double deltaTime) {

        double filteredOutput = 0.0;
        double rate = Math.abs( rawOutput / maxValue);
        if(rate> alpha){
            if(rawOutput>0) {
                filteredOutput = maxValue * alpha;
            }else{
                filteredOutput = -1*maxValue * alpha;
            }
        }else{
            filteredOutput= rawOutput;
        }

        return filteredOutput;

    }
}
