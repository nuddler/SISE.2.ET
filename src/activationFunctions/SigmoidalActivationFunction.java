package activationFunctions;

public class SigmoidalActivationFunction extends ActivationFunction {

    @Override
    public double calculate(double formula, double beta) {
        return 1.0 /  (1.0 + Math.exp(-beta * formula));
    }
}
