package test2;

import javax.swing.JLabel;

public class Piece {

	JLabel jl;
	private int tX, tY, chX, chY, cbX, cbY;
	
	public Piece(JLabel jl, int tX, int tY, int chX, int chY, int cbX, int cbY) {
		this.jl = jl;
		this.tX = tX;
		this.tX = tX;
		this.chX = chX;
		this.chY = chY;
		this.cbX = cbX;
		this.cbY = cbY;
	}

	public JLabel getJl() {
		return jl;
	}

	public void setJl(JLabel jl) {
		this.jl = jl;
	}

	public int gettX() {
		return tX;
	}

	public void settX(int tX) {
		this.tX = tX;
	}

	public int gettY() {
		return tY;
	}

	public void settY(int tY) {
		this.tY = tY;
	}

	public int getChX() {
		return chX;
	}

	public void setChX(int chX) {
		this.chX = chX;
	}

	public int getChY() {
		return chY;
	}

	public void setChY(int chY) {
		this.chY = chY;
	}

	public int getCbX() {
		return cbX;
	}

	public void setCbX(int cbX) {
		this.cbX = cbX;
	}

	public int getCbY() {
		return cbY;
	}

	public void setCbY(int cbY) {
		this.cbY = cbY;
	}
	
	
	
}
