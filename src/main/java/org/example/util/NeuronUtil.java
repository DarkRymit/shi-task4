package org.example.util;

import java.util.function.Function;

public class NeuronUtil {

    public static Function<Double,Double> linearActivateFunction(double value){
        return sum -> {
            if (sum <= value) {
                return 0d;
            }
            if (sum >= value) {
                return 1d;
            }
            return sum;
        };
    }
    public static Function<Double,Double> thresholdActivateFunction(double value){
        return sum -> {
            if (sum >= value) {
                return 1d;
            }
            return 0d;
        };
    }
}
