package pl.lodz.p.ftims.sise.main;

import java.util.ArrayList;
import java.util.Collections;

import pl.lodz.p.ftims.sise.perceptronModel.Perceptron;
import pl.lodz.p.ftims.sise.perceptronModel.PerceptronElementData;

public class SISE2 {
	static int epochAmount = 30000;
	
	public static void run() {
		// Inicjalizacja perceptronu 1-10-1.
        double[] w00 = {1};
        
        double[] w10 = {1};
        double[] w11 = {0.1};
        double[] w12 = {-0.1};
        double[] w13 = {0.2};
        double[] w14 = {0.3};
        double[] w15 = {0.5};
        double[] w16 = {-0.2};
        double[] w17 = {-0.3};
        double[] w18 = {-0.4};
        double[] w19 = {0};
        
        double[] w20 = {0.5, 0.2, 0.0, -0.4, -0.1, 
                        0.1, 0.9, 0.5, -0.9, 1.2};
        double alpha = 0.3;
        double beta = 0.5;
        
        PerceptronElementData[][] dataInit = new PerceptronElementData[3][];
        dataInit[0] = new PerceptronElementData[1];
        dataInit[0][0] = new PerceptronElementData(w00, alpha, beta);
        
        dataInit[1] = new PerceptronElementData[10];
        dataInit[1][0] = new PerceptronElementData(w10, alpha, beta);
        dataInit[1][1] = new PerceptronElementData(w11, alpha, beta);
        dataInit[1][3] = new PerceptronElementData(w13, alpha, beta);
        dataInit[1][2] = new PerceptronElementData(w12, alpha, beta);
        dataInit[1][4] = new PerceptronElementData(w14, alpha, beta);
        dataInit[1][5] = new PerceptronElementData(w15, alpha, beta);
        dataInit[1][6] = new PerceptronElementData(w16, alpha, beta);
        dataInit[1][7] = new PerceptronElementData(w17, alpha, beta);
        dataInit[1][8] = new PerceptronElementData(w18, alpha, beta);
        dataInit[1][9] = new PerceptronElementData(w19, alpha, beta);
        
        dataInit[2] = new PerceptronElementData[1];
        dataInit[2][0] = new PerceptronElementData(w20, alpha, beta);
	    
	    Perceptron perceptron = new Perceptron(dataInit);
	    
	    ArrayList<Double> epoch = new ArrayList<Double>();
	    for(int i = 1; i <= 100; i++){
	    	epoch.add((double)i);
	    }
	    
		for(int i = 0; i < epochAmount; i++) {
	    	Collections.shuffle(epoch);
	    	for(Double e : epoch) {
	    		double[] input = { e.doubleValue() };
	    		double[] expected = { Math.sqrt(e.doubleValue()) };
	    		perceptron.launchWithLearning(input, expected);
	    	}
	    }
	    System.out.println("Koniec");
	}
}



