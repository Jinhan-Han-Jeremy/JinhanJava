package dna;

import java.io.BufferedReader;
import java.io.IOException;

//
// Reads lines from a BufferedReader and builds a FastqRecord.
//

public class FastqReader {
	// declare BufferedReader variables named theBufferedReader
	private BufferedReader theBufferedReader;

	// build constructor with parameter typed BufferedReader
	public FastqReader(BufferedReader theBufferedReader) {
		this.theBufferedReader = theBufferedReader;
	}

	// Returns next record in the file, or null if EOF (end-of-file).
	// build readRecord() with throws IOException and RecordFormatException
	public FastqRecord readRecord() throws IOException, RecordFormatException {

		// Read the defline from the BufferedReader. and assign in string type
		// Return null if you read null,

		// indicating end of file.

		String def = theBufferedReader.readLine();
		if (def == null) {
			return null;
		}

		// Read the sequence from the BufferedReader. and assign in string type
		String seq = theBufferedReader.readLine();

		// use readline() once more to jump dummy line
		theBufferedReader.readLine();

		// Read the quality from the BufferedReader. and assign in string type
		String qual = theBufferedReader.readLine();

		// initialize FastqRecord with def, seq and qual
		FastqRecord r = new FastqRecord(def, seq, qual);

		// return initialized FastqRecord
		return r;

	}
}
