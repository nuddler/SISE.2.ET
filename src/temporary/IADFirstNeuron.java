package temporary;

/**
 * @author Sebastian Graf
 * 
 */
public class IADFirstNeuron {
	private double w0 = 1;
	public double getW0() {
		return w0;
	}	
	private double w1 = 1;
	public double getW1() {
		return w1;
	}	
	private double w2 = 0;
	public double getW2() {
		return w2;
	}
	
	private double alpha = 0.3;	
	private double beta = 0.5;
	
	/** Main operation for neuron.
	 * @param x0, x1 - y and x
	 * @param con - is point over or under straight line {-1,1}
	 * @return - true if neuron learns something
	 */
	public boolean mainOperation(double x0, double x1, int con) {
		double deltaL = 0;
		double formula;
		
		formula = calculateFormula(x0, x1);
		
		if(formula * con < 0) {
			deltaL = calculateDeltaL(con, formula);
			double dSigm = calculateDerivativeOfTheSigmoid(formula);
			
			w0 = w0 + 	alpha * deltaL * x0 * dSigm;
			w1 = w1 + 	alpha * deltaL * x1 * dSigm;
			w2 = w2 +   alpha * deltaL      * dSigm;
			
			return true;
		}
		else 
			return false;
	}
	
	
	/** Calculate formula.
	 * @param x0, x1 - y and x
	 * @return - result of the equation
	 */
	public double calculateFormula(double x0, double x1) {
		return w0*x0 +  w1*x1 + w2*1.0;
	}	
	/** Calculate delta l for formula.
	 * @param con - is point over or under straight line {-1,1}
	 * @param formula - result of the formula
	 * @return - result of the equation
	 */
	public double calculateDeltaL(int con, double formula) {
		return con + calculateSigmoid(formula);
	}
	/** Calculate sigmoid. 
	 * @param sign - result of the formula
	 * @return - result of the equation (-1,1)
	 */
	public double calculateSigmoid(double sign) {
		return 1.0 /  (1.0 + Math.exp(-beta * sign));
	}	
	public double calculateDerivativeOfTheSigmoid(double sign) {
		return ( beta * Math.exp(beta * sign)) / Math.pow(1.0 + Math.exp(beta * sign), 2.0 );
	}
	/** Reset weights in Neuron.
	 * 
	 */
	public void resetWeights() {
		w0 = 1;
		w1 = 1;
		w2 = 0;
	}
	
}