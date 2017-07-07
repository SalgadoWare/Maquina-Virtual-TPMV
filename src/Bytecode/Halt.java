package Bytecode;

import Cpu.CPU;

/**
 * La clase Halt hereda de ByteCode implementando todos los métodos
 * abstractos
 *
 */
public class Halt implements ByteCode {

	@Override
	public void execute(CPU cpu) {
		cpu.halt();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else
			return null;
	}

	@Override
	public String toString() {
		return "HALT";
	}

}
