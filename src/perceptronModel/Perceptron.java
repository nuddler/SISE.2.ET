package perceptronModel;

import activationFunctions.*;

/**
 * @author Sebastian Graf
 *
 */
public class Perceptron {
	
	private PerceptronElement[][] neuralNetwork;

	/**
	 * Generate neural network.
	 * @param dataInit - parameters needed for neurons. 
	 *     Also used as the size of the network. 
	 */
	public Perceptron(PerceptronElementData[][] dataInit) {
	    // 1st dimension.
        PerceptronElement[][] neuralNetwork = 
                new PerceptronElement[dataInit.length][];       
        // 2nd dimension.
        for(int i = 0; i < dataInit.length; i++)
            neuralNetwork[i] = new PerceptronElement[dataInit[i].length];
        
        // 1st layer - InputBlock(s).
        for(int j = 0; j < neuralNetwork[0].length; j++) 
            neuralNetwork[0][j] = new InputBlock();
        
        // Hidden layers.
        for(int i = 1; i < dataInit.length-1; i++)
            for(int j = 0; j < neuralNetwork[i].length; j++)
                neuralNetwork[i][j] 
                        = new Neuron(dataInit[i][j], new SigmoidalActivationFunction());
        
        // Last layer.
        int lastLayerIndex = dataInit.length-1;
        for(int j = 0; j < neuralNetwork[ lastLayerIndex ].length; j++)
            neuralNetwork[ lastLayerIndex ][j] 
                    = new Neuron(dataInit[ lastLayerIndex ][j], new LinearActivationFunction());	// XXX: edit.

        // Assign neural network.
        this.neuralNetwork = neuralNetwork;
	}	
	
	/** Launch perceptron and teach it.
	 * @param input - list of input.
	 * @param expectedResult - list of expected results.
	 */
	public void launchWithLearning(double[] input, double[] expectedResult) {
       double[] lastLayerOutput = new double[ neuralNetwork[0].length ];
       
	    // 1st layer - InputBlock(s).
	    for(int j = 0; j < neuralNetwork[0].length; j++) {
	        double[] localInput = new double[1];
	        localInput[0] = input[j];
	        lastLayerOutput[j] = neuralNetwork[0][j].launch(localInput);
	    }
	    	    
	    // Other layers
	    for(int i = 1; i < neuralNetwork.length; i++) {
	        double[] localLayerOutput = 
	                new double[ neuralNetwork[i].length ];
	        for(int j = 0; j < neuralNetwork[i].length; j++) {
	            localLayerOutput[j] = neuralNetwork[i][j].launch(lastLayerOutput);
	        }
	        lastLayerOutput = localLayerOutput;
	    }
	    
	    if(lastLayerOutput[0] > 1.0) {
	    	System.out.println("Expeted :"+ expectedResult[0] + " Result: " + lastLayerOutput[0]);
	    }
	    
	    // Back Propagation
	    backPropagationAlgorithm(lastLayerOutput, expectedResult);
	    
	}
	
	public double[] launchAndReturnResult(double[] input) {
		double[] lastLayerOutput = 
	            new double[ neuralNetwork[0].length ];
	       
		    // 1st layer - InputBlock(s).
		    for(int j = 0; j < neuralNetwork[0].length; j++) {
		        double[] localInput = new double[1];
		        localInput[0] = input[j];
		        lastLayerOutput[j] = neuralNetwork[0][j].launch(localInput);
		    }
		    	    
		    // Other layers
		    for(int i = 1; i < neuralNetwork.length; i++) {
		        double[] localLayerOutput = 
		                new double[ neuralNetwork[i].length ];
		        for(int j = 0; j < neuralNetwork[i].length; j++) {
		            localLayerOutput[j] = neuralNetwork[i][j].launch(lastLayerOutput);
		        }
		        lastLayerOutput = localLayerOutput;
		    }
		
		return lastLayerOutput;
	}
	
	/**
	 * BP for square root.
	 * XXX: dziala tylko dla 2ch warstw.
	 * @param output - perceptron output (last layer output).
	 */
	private void backPropagationAlgorithm(double[] output, double[] expectedResult) {
	    double[][] delta;
	    delta = new double[neuralNetwork.length-1][];
	    for(int i = neuralNetwork.length-1; i > 0; i--) {
	        delta[i-1] = new double[neuralNetwork[i].length];
	    }
	    
	    // Output layer.
	    for(int i = 0; i < output.length; i++) {
	        Neuron lNeuron = (Neuron)neuralNetwork[neuralNetwork.length-1][i];
	        delta[ delta.length-1 ][i] = (output[i] - expectedResult[i]) 
	                * lNeuron.calculateDerivativeOfTheSigmoid();
	    }
	    
	    // next layer. XXX
	    for(int i = 0; i < delta[delta.length-2].length; i++) {
	        Neuron lNeuron = (Neuron)neuralNetwork[neuralNetwork.length-2][i];
	        double lDelta = 0;
	        
	        for(int j = 0; j < delta[delta.length-1].length; j++) {
	            Neuron nextNeuron = (Neuron)neuralNetwork[neuralNetwork.length-1][j];
	            lDelta += nextNeuron.getWeights()[i] * delta[delta.length-1][j]
	                    * lNeuron.calculateDerivativeOfTheSigmoid();
	        }
	        
	        delta[ delta.length-2 ][i] = lDelta;
	    }

	    // Weights modyfication.
	    for(int i = 0; i < delta.length; i++) {
	        for(int j = 0; j < delta[i].length; j++) {
	            Neuron lNeuron = (Neuron)neuralNetwork[i+1][j];
	            double lDelta = delta[i][j];
	            lNeuron.modyfyWeights(lDelta);
	        }
	    }
	    
	    
	    //TODO: jakos to polaczyc nad zeby dzialalo dla wszystkiego
	}
	
}
















