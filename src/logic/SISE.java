package logic;

import java.util.ArrayList;
import java.util.Collections;

import perceptronModel.Perceptron;
import perceptronModel.PerceptronElementData;

/**
 * @author Sebastian Graf
 *
 */
public class SISE {
	
	public static void runSISE() {
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
        dataInit[1][2] = new PerceptronElementData(w12, alpha, beta);
        dataInit[1][3] = new PerceptronElementData(w13, alpha, beta);
        dataInit[1][4] = new PerceptronElementData(w14, alpha, beta);
        dataInit[1][5] = new PerceptronElementData(w15, alpha, beta);
        dataInit[1][6] = new PerceptronElementData(w16, alpha, beta);
        dataInit[1][7] = new PerceptronElementData(w17, alpha, beta);
        dataInit[1][8] = new PerceptronElementData(w18, alpha, beta);
        dataInit[1][9] = new PerceptronElementData(w19, alpha, beta);
        
        dataInit[2] = new PerceptronElementData[1];
        dataInit[2][0] = new PerceptronElementData(w20, alpha, beta);
	    
	    Perceptron perc1 = new Perceptron(dataInit);
	    
	    // Epokowe nauczanie.
	    ArrayList<Double> epok = new ArrayList<Double>();
	    for(int i = 1; i <= 100; i++)
	    	epok.add((double)i);
	    
	    for(int i = 0; i < 30000; i++) {
	    	Collections.shuffle(epok);
	    	for(Double j : epok) {
	    		double[] var = { j.doubleValue() };
	    		double[] res = { Math.sqrt(j.doubleValue()) };
	    		
	    		perc1.launchWithLearning(var, res);
	    	}
	    }
	    System.out.println("end");
	}
}



