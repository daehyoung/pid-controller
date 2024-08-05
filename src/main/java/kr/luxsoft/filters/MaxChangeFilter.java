package kr.luxsoft.filters;

import kr.luxsoft.app.OutputFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// 최대 변동폭 필터 구현
public class MaxChangeFilter implements OutputFilter {
    private double maxChange;

    public MaxChangeFilter(double maxChange) {
        this.maxChange = maxChange;
    }

    @Override
    public double filter( double previous, double change, double deltaTime) {

        log.info("change :: {}",change);
        if (Math.abs(change) > maxChange) {
            if (change > 0) {
                return   maxChange;
            } else {
                return  - maxChange;
            }
        }
        return change;
    }
}