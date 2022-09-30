package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Getter
public class NeuronNetwork implements Neuron {

    private final Neuron mainNeuron;

    private final List<Neuron> neurons;

    public double process(List<Double> synapseInput) {
        if (neurons.isEmpty()){
            return mainNeuron.process(synapseInput);
        }
        return mainNeuron.process(
                neurons.stream().map(neuron -> neuron.process(synapseInput)).toList());
    }

    public static NeuronNetwork of(Neuron mainNeuron,List<Neuron> neurons){
        return new NeuronNetwork(mainNeuron, List.copyOf(neurons));
    }
}
