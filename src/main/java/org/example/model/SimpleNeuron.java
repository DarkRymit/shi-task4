package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Getter
public class Neuron {


    private final NeuronConfig config;

    public double process(List<Double> synapseInput){
        List<Double> weight = config.inputWeightsCoefficients();
        Double sum = IntStream.range(0,weight.size()).mapToDouble(i-> weight.get(i) * synapseInput.get(i)).sum();
        return config.activateFunction().apply(sum);
    }

    public static Neuron of(NeuronConfig config){
        return new Neuron(config);
    }
}
