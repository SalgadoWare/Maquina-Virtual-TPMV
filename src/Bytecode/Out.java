package Bytecode;

import Cpu.CPU;
import Excepciones.ArrayException;

/**
 * La clase Out hereda de ByteCode implementando todos los métodos abstractos
 *
 */
public class Out implements ByteCode {

	@Override
	public void execute(CPU cpu) throws ArrayException {
		Integer n = cpu.pop();
		System.out.println("Consola: " + n);
		cpu.increaseProgramCounter();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else
			return null;
	}

	@Override
	public String toString() {
		return "OUT";
	}

}
