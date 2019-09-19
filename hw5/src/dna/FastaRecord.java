package dna;

public class FastaRecord implements DNARecord {

	// declare two instance variables in string type to aassign lines from file
	private String defline;
	private String sequence;

	//
	// Add throw RecordGFormatException at end of method
	// if the 1st char of the defline is not '>', throws RecordFormatException with
	// notice messages
	// You will have to change the 2 instance variables assigning variables from
	// parameter
	//
	public FastaRecord(String defline, String sequence) throws RecordFormatException {

		if (defline.charAt(0) != '>') {

			throw new RecordFormatException(
					"Bad 1st char in defline in fasta record: Saw " + defline.charAt(0) + " expected >");
		}

		this.defline = defline;
		this.sequence = sequence;

	}

	// Initialize defline and sequence from the input record.
	// defline of the fastq record starts with a '>' in the first position
	// instead of original first char
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();
	}

	//
	// Build equals() method.
	// use deep equality method.
	// if statement helps to compare defline and sequence variables
	// from this object, and another object in parameter
	//

	public boolean equals(Object x) {

		FastaRecord that = (FastaRecord) x;

		if (this.defline.equals(that.defline) == true)
			return this.sequence.equals(that.sequence);
		else
			return false;
	}

	//
	// Provide the 2 methods that satisfy the interface.
	// getter method to return variables: defline and sequence
	//
	public String getDefline() {
		return defline;
	}

	public String getSequence() {
		return sequence;
	}

	//
	// Provide a hashCode() (int type) method that returns the sum of the hashcode()
	// of
	// defline and sequence.
	//
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode();
	}

}
