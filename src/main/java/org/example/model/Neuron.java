package org.example.model;

import java.util.List;


public interface Neuron {
    double process(List<Double> synapseInput);
}
