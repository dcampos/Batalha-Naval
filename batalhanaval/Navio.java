package batalhanaval;

import java.awt.Point;
import java.io.Serializable;

/**
 * Classe abstrata básica de um navio.
 * 
 * @author
 * 
 */
public abstract class Navio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;

	private String nome;
	private int tamanho;
	private int id;

	private Jogador jogador;
	private Point posicao;
	private int orientacao;

	public Navio(String nome, int tamanho, int identificador, Jogador jogador) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.id = identificador;

		this.jogador = jogador;
		this.posicao = null;
		this.orientacao = HORIZONTAL;
	}

	public String getNome() {
		return nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getId() {
		return id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public Point getPosicao() {
		return posicao;
	}
	
	/**
	 * Gera um array de pontos a partir da primeira posição
	 * do navio.
	 * 
	 * @return
	 * @throws NullPointerException Se o navio ainda não estiver posicionado.
	 */
	public Point[] getArrayPosicao() throws NullPointerException {
		Point[] arrayPos = new Point[tamanho];
		int i = posicao.x;
		int j = posicao.y;
		int k = 0;
		
		while(k < tamanho) {
			arrayPos[k++] = new Point(i, j);
			if (orientacao == VERTICAL)
				j++;
			else
				i++;	
		}
		return arrayPos;
	}

	public int getOrientacao() {
		return orientacao;
	}

	public void setPosicao(Point pos) {
		posicao = pos;
	}
	
	public void setOrientacao(int orientacao) {
		this.orientacao = orientacao;
	}

	public boolean estaDestruido() {
		for (Point p: getArrayPosicao()) {
			if (jogador.getTabuleiro().getPosicao(p.x, p.y) > 0) {
				return false;
			}
		}
		return true;
	}
}
