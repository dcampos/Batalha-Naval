package batalhanaval;

/**
 * Encouraçado.
 * 
 * @author Darlan P. de Campos
 * @author Roger de  Córdova Farias
 *
 */

@SuppressWarnings("serial")
public class Encouracado extends Navio {
	
	/**
	 * Constroi um novo encouraçado.
	 * 
	 * @param jog Jogador
	 */
	public Encouracado(Jogador jog) {
		super("Encouraçado", 4, 16, jog);
	}
}

