package org.example;

import org.example.model.Neuron;
import org.example.model.NeuronNetwork;
import org.example.model.SimpleNeuron;
import org.example.model.NeuronConfig;
import org.example.util.NeuronUtil;

import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<List<Double>> inputs3 = List.of(
                List.of(0.0, 0.0, 0.0),
                List.of(0.0, 1.0, 0.0),
                List.of(1.0, 0.0, 0.0),
                List.of(1.0, 1.0, 1.0)
        );
        List<List<Double>> inputs2 = List.of(
                List.of(0.0, 0.0),
                List.of(0.0, 1.0),
                List.of(1.0, 0.0),
                List.of(1.0, 1.0)
        );

        List<List<Double>> inputs1 = List.of(
                List.of(0.0),
                List.of(1.0)
        );

        SimpleNeuron andSimpleNeuron = SimpleNeuron.of(
                new NeuronConfig(List.of(1.0, 1.0), NeuronUtil.thresholdActivateFunction(1.5)));
        SimpleNeuron orSimpleNeuron = SimpleNeuron.of(
                new NeuronConfig(List.of(1.0, 1.0), NeuronUtil.thresholdActivateFunction(0.5)));
        SimpleNeuron notSimpleNeuron = SimpleNeuron.of(
                new NeuronConfig(List.of(-1.5), NeuronUtil.thresholdActivateFunction(-1.0)));

        System.out.println("And SimpleNeuron");
        inputs2.forEach(printResults(andSimpleNeuron));
        System.out.println("Or SimpleNeuron");
        inputs2.forEach(printResults(orSimpleNeuron));
        System.out.println("Not SimpleNeuron");
        inputs1.forEach(printResults(notSimpleNeuron));

        System.out.println("Xor NeuronNet");
        Neuron neuronNet = NeuronNetwork.of(
                SimpleNeuron.of(new NeuronConfig(List.of(1.0, 1.0), NeuronUtil.thresholdActivateFunction(0.5))),
                List.of(
                        SimpleNeuron.of(new NeuronConfig(List.of(1.0, -1.0),
                                NeuronUtil.thresholdActivateFunction(0.5))),
                        SimpleNeuron.of(
                                new NeuronConfig(List.of(-1.0, 1.0), NeuronUtil.thresholdActivateFunction(0.5)))
                ));
        inputs2.forEach(printResults(neuronNet));

        System.out.println("Custom SimpleNeuron");
        Neuron customNeuronNet = NeuronNetwork.of(
                SimpleNeuron.of(new NeuronConfig(List.of(1.0, 1.0), NeuronUtil.thresholdActivateFunction(0.5))),
                List.of(
                        SimpleNeuron.of(new NeuronConfig(List.of(-1.5, 0.0,  0.0),
                                NeuronUtil.thresholdActivateFunction(-1.0))),
                        SimpleNeuron.of(
                                new NeuronConfig(List.of(0.0, 0.0, 1.0), NeuronUtil.thresholdActivateFunction(1.0)))
                ));
        inputs3.forEach(printResults(customNeuronNet));
    }

    private static Consumer<List<Double>> printResults(Neuron neuron) {
        return i -> {
            var result = neuron.process(i);
            System.out.printf("For input %s result is %s%n", i, result);
        };
    }
}
