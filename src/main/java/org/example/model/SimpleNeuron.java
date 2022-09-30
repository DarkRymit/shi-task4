package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Getter
public class SimpleNeuron implements Neuron{


    private final NeuronConfig config;

    @Override
    public double process(List<Double> synapseInput){
        List<Double> weight = config.inputWeightsCoefficients();
        Double sum = IntStream.range(0,weight.size()).mapToDouble(i-> weight.get(i) * synapseInput.get(i)).sum();
        return config.activateFunction().apply(sum);
    }

    public static SimpleNeuron of(NeuronConfig config){
        return new SimpleNeuron(config);
    }
}
