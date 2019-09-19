package dna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileConverter {

	// declare two instance variables(file type) for fastq and fasta
	private File fastq;
	private File fasta;

	// pass two instance variables into parameter of constructor
	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;

	}

	// build convert method in void type with 'throws IOException'.
	// Writes a fasta file consisting of conversion of all records from the fastq
	// with
	// sufficient quality and unique defline.
	//

	public void convert() throws IOException {
		// Build chain of file readers.
		// initialize FileReader assigning fastq in
		// sequently initialize Buffereader and FastqReader

		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		// initialize FileWriter assigning fasta in
		// sequently initialize Printwriter and fastawriter
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.
		// declare boolean done
		boolean done = false;

		// build while loop to read existed fast q with try catch
		while (!done) {
			try {
				// assign readed file into fqrec calling readRecord().
				FastqRecord fqrec = fqr.readRecord();

				// If fqrec is null, change 'done' into true
				if (fqrec == null) {
					done = true;
				} else {

					// if fqrec quality is not low, write file calling writeRecord method,
					if (!fqrec.qualityIsLow()) {
						FastaRecord farr = new FastaRecord(fqrec);
						faw.writeRecord(farr);
					}
				}
				// Catches the RecordFormatException
			} catch (RecordFormatException x) {
				// System.out.println("Some sort of error occured: " + x.getMessage());

			}
		}

		// Close file functions fr, br, fw, and pw in reverse order
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		System.out.println("Starting");
		try {

			File fastq = new File("data/HW5.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW5.fasta");

			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
