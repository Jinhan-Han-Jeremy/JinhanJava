package dna;

import java.io.IOException;
import java.io.PrintWriter;

//
// Writes a fasta record to a print writer.
//

public class FastaWriter {
	// initialize instance variable in PrintWriter type
	private PrintWriter thePrintWriter;

	// build constructor with parameter in PrintWriter type
	// and assign it
	public FastaWriter(PrintWriter thePrintWriter) {
		this.thePrintWriter = thePrintWriter;
	}

	//
	// build writerecord method with parameter rec in FastaRecord type.
	// add put throw IOException end of method name
	// write something 2 lines to show defline and sequence, use the println()
	// method of
	// PrintWriter.
	public void writeRecord(FastaRecord rec) throws IOException {

		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());

	}
}
