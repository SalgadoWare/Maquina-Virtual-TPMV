package Bytecode;


/**
 * 
 * Este salto condicional hereda de ConditionalJumps e implementa todos sus
 * métodos abstractos
 *
 */
public class Ifeq extends ConditionalJumps {

	public Ifeq(int n) {
		super(n);
	}

	public Ifeq() {
	}

	@Override
	protected ByteCode parseAux(String w1, String w2) {
		if (w1.equalsIgnoreCase("IFEQ")) {
			int n = Integer.parseInt(w2);
			return new Ifeq(n);
		} else
			return null;
	}

	@Override
	protected boolean compare(int n1, int n2) {
		return n1 == n2;
	}

	@Override
	protected String toStringAux() {
		return "IFEQ";
	}
}
