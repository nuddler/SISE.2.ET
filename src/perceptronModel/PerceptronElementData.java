package perceptronModel;

/**
 * @author Sebastian Graf
 *
 */
public class PerceptronElementData {
    private double[] weights;
    public double[] getWeights() {
        return weights;
    }
    private double alpha;
    public double getAlpha() {
        return alpha;
    }
    private double beta;
    public double getBeta() {
        return beta;
    }
    
    public PerceptronElementData(double[] weights, double alpha, double beta) {
        this.weights = weights;
        this.alpha = alpha;
        this.beta = beta;
    }
}
