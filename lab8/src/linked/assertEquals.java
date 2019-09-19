package linked;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class assertEquals {

	@Test
	public void testAppend() {
		DNALinkedList list = new DNALinkedList("ACGTGTA");
		assertEquals("DNALinkedList: ACGTGTA", list.toString());
	}

	@Test
	public void testTransposon() {
		String chromosome = "AGATTCGA";
		DNALinkedList list = new DNALinkedList(chromosome);
		String transposon = "TCG";
		String target = "GAT";
		list.transpose(transposon, target);
		assertEquals("DNALinkedList: AGCTGATA", list.toString());
	}

}
