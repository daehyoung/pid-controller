package kr.luxsoft.app;

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
    public double filter(double previousOutput, double rawOutput, double deltaTime) {
        return rawOutput;
    }
}
