package dna;

//

// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//
// class FastqRecord use interface DNARecord
public class FastqRecord implements DNARecord {
	//
	// declare 3 instance variables: defline sequence and quality
	String defline;
	String sequence;
	String quality;

	// build constructor with 3 parameter: defline, sequence and quality
	// and add throws RecordFormatException
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {

		char first = defline.charAt(0);

		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;

		// if defline is null, throw RecordFormatException with message
		if (defline == null) {
			// it needs new to declare RecordFormatException
			throw new RecordFormatException("An empty or null string");
			// if first character is not '@', throw RecordFormatException with message
		} else if (first != '@') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw X, expected @");
		}

	}

	//
	//
	// Build equals() method.
	// use deep equality method.
	// if statement helps to compare defline, sequence and quality variables
	// from this object, and another object in parameter
	// if these variables are not equal, it return false
	public boolean equals(Object x) {
		FastqRecord that = (FastqRecord) x;

		if (this.defline.equals(that.defline) == true) {
			if (this.sequence.equals(that.sequence) == true)
				return this.quality.equals(that.quality) == true;
		}

		return false;
	}

	//
	// if quality contains at least one '!' char or at least one ‘#’ char.
	// it returns true, or returns false
	public boolean qualityIsLow() {

		if ((quality.contains("!")) || (quality.contains("#")))
			return true;
		else
			return false;
	}

	//
	// Provide the 2 methods that satisfy the interface.
	// getter method to return variables: defline and sequence
	//
	public String getDefline() {
		return this.defline;
	}

	public String getSequence() {
		return this.sequence;
	}

	//
	// Provide a hashCode() (int type) method that returns the sum of the hashcode()
	// of
	// defline and sequence.
	//
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode() + this.quality.hashCode();
	}
}
