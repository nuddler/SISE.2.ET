package pl.lodz.p.ftims.sise.perceptronModel;

public class PerceptronElementData {
    private double[] weights;
    private double alpha;
    private double beta;
    
    public PerceptronElementData(double[] weights, double alpha, double beta) {
    	this.weights = weights;
    	this.alpha = alpha;
    	this.beta = beta;
    }
    
    public double[] getWeights() {
        return weights;
    }
    
    public double getAlpha() {
        return alpha;
    }
    
    public double getBeta() {
        return beta;
    }
}
