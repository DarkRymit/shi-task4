package org.example.model;

import lombok.Value;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public record NeuronConfig(List<Double> inputWeightsCoefficients, Function<Double, Double> activateFunction) {
    public NeuronConfig(List<Double> inputWeightsCoefficients, Function<Double, Double> activateFunction) {
        this.inputWeightsCoefficients = List.copyOf(inputWeightsCoefficients);
        this.activateFunction = activateFunction;
    }
}
