package kr.luxsoft.filters;

import kr.luxsoft.app.OutputFilter;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-02
 * @version: 1.0
 */
public class NullFilter implements OutputFilter {

    public NullFilter( ) {

    }

    @Override
    public double filter(double previous,  double rawOutput, double deltaTime) {
        return rawOutput;
    }
}
