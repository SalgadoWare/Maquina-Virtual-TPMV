package Instrucciones.Term;

import Bytecode.ByteCode;
import Bytecode.CompilerB;
import Bytecode.Push;

public class Number implements Term {

	private int n;

	public Number(int n) {
		this.n = n;
	}

	public Number() {
	}

	@Override
	public Term parse(String term) {

		try {
			int n = Integer.parseInt(term);
			return new Number(n);
		} catch (NumberFormatException e) {
			return null;
		}

	}

	public String toString() {
		return (this.n + "");
	}

	@Override
	public ByteCode compile(CompilerB compiler) {
		return new Push(this.n);
	}

}
