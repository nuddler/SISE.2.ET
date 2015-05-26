package perceptronModel;

/**
 * @author Sebastian Graf
 *
 */
public class InputBlock implements PerceptronElement {
    private double[] lastInput;   

    @Override
    public double launch(double[] input) {
        this.lastInput = input;
        return input[0];
    }

}
