package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * 
 * La clase Add hereda de Atrithmetics implementando todos los m�todos abstractos
 *
 */
public class Sub extends Arithmetics {

	@Override
	public String toString() {
		return "SUB";
	}

	protected void opera(CPU cpu, int n1, int n2) throws ArrayException {
		cpu.push(n1 - n2);
	}

	@Override
	protected ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("SUB"))
			return new Sub();
		else
			return null;
	}
}
