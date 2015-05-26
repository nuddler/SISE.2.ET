package perceptronModel;

/**
 * @author Sebastian Graf
 *
 */
public interface PerceptronElement {

	/**
	 * The method shows a behavior of the element at the given input.
	 * @param input - What element receives as input.
	 * @return - What element give as output.
	 */
	public abstract double launch(double[] input);
	
}
