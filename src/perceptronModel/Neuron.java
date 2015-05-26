package perceptronModel;

import activationFunctions.ActivationFunction;

/**
 * @author Sebastian Graf
 * 
 */
public class Neuron implements PerceptronElement {
    private double[] weights;
    public double[] getWeights() {
        return weights;
    }
    
    private double[] lastInput;
    private double alpha;
    private double beta;
    
    private ActivationFunction activationFunction;
    
    /**
     * Constructor that initialize weights and constants for neurone.
     * @param dataInit - contains weights, alpha and beta.
     */
    public Neuron(PerceptronElementData dataInit) {
        this.weights = dataInit.getWeights();
        this.alpha = dataInit.getAlpha();
        this.beta = dataInit.getBeta();
    }
    
    /**
     * Constructor that initialize weights, constants and activation function '
     * for neurone.
     * @param dataInit - contains weights, alpha and beta.
     * @param actvFnc - chosed activation function.
     */
    public Neuron(PerceptronElementData dataInit, ActivationFunction actvFnc) {
        this.weights = dataInit.getWeights();
        this.alpha = dataInit.getAlpha();
        this.beta = dataInit.getBeta();
        this.activationFunction = actvFnc;
        
    }
    
    @Override
    public double launch(double[] input) {
        this.lastInput = input;
        double formula = calculateFormula(input);
//      double sigmoidalOutput = calculateSigmoid(formula);
        double output = activationFunction.calculate(formula, beta);
        return output;
    }
    
    private double calculateFormula(double[] input) {
        double result = 0;
        for(int i = 0; i < weights.length; i++)
            result += weights[i] * input[i];        
        return result;
    }

    public double calculateDerivativeOfTheSigmoid() {
        double formula = calculateFormula(lastInput);
        return ( beta * Math.exp(beta * formula)) 
                / Math.pow(1.0 + Math.exp(beta * formula), 2.0 );
    }

    public void modyfyWeights(double delta) {
        for(int i = 0; i < weights.length; i++)
            weights[i] = weights[i] - ( alpha * delta * calculateDerivativeOfTheSigmoid() * lastInput[i] );
    }
}
/*
 * XXX: name for Formula.
 * XXX: name for Sigmoid Exit.
 */