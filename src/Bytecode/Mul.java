package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Mul hereda de Atrithmetics implementando todos los métodos
 * abstractos
 *
 */
public class Mul extends Arithmetics {

	@Override
	public String toString() {
		return "MUL";
	}

	protected void opera(CPU cpu, int n1, int n2) throws ArrayException {
		cpu.push(n1 * n2);
	}

	@Override
	protected ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("MUL"))
			return new Mul();
		else
			return null;
	}
}
