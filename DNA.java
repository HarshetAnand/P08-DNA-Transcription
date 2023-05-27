//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 DNA Transcription: DNA Class
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class uses a linked queue to implement DNA transcription. DNA transcription is performed by
 * first transcribing a string of DNA characters to their mRNA complements, and then translating
 * those mRNA characters in groups of three (called "codons") to corresponding amino acids, which
 * finally fold up into proteins. To make this happen, you'll begin with a String containing a
 * sequence of DNA characters (A, C, G, and T) and use this to create a LinkedQueue of Characters.
 * Then, you'll write a method to traverse that LinkedQueue (without an iterator! gasp!) and create
 * a NEW LinkedQueue of mRNA characters (A->U, T->A, C->G, G->C). Finally, given that LinkedQueue of
 * mRNA, you'll use the provided mRNAtoProteinMap to traverse the queue three letters at a time and
 * find the associated amino acid - or if you've found a STOP codon, end your translation and return
 * the string of amino acids.
 */

public class DNA extends Object {

  protected LinkedQueue<Character> DNA; // The queue containing the original DNA sequence
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}}; // A two-dimensional array
                                                                   // containing the mRNA codons in
                                                                   // index 0 and the corresponding
                                                                   // amino acid (or STOP) in index
                                                                   // 1


  /**
   * Creates the DNA queue from the provided String. Each Node contains a single Character from the
   * sequence.
   * 
   * @param sequence - a String containing the original DNA sequence
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    for (int j = 0; j < sequence.length(); j++) {
      DNA.enqueue(sequence.charAt(j));
    }
  }


  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is
   * done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNA = new LinkedQueue<Character>();
    for (int j = 0; j < DNA.size(); j++) {
      char character = this.DNA.dequeue();
      if (character == 'A') {
        mRNA.enqueue('U');
      } else if (character == 'T') {
        mRNA.enqueue('A');
      } else if (character == 'C') {
        mRNA.enqueue('G');
      } else if (character == 'G') {
        mRNA.enqueue('C');
      } else {
      }
      this.DNA.enqueue(character);
    }
    return mRNA;
  }


  /**
   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters. The
   * translation is done three characters at a time, according to the static mRNAtoProteinMap
   * provided above. Translation ends either when you run out of mRNA characters OR when a STOP
   * codon is reached (i.e. the three-character sequence corresponds to the word STOP in the map,
   * rather than a single amino acid character).
   * 
   * @param mRNA - a queue containing the mRNA sequence corresponding to the stored DNA sequence
   * @return the queue containing the amino acid sequence corresponding to the provided mRNA
   *         sequence
   */
  public LinkedQueue<String> mRNATranslate(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> aminoAcids = new LinkedQueue<String>();
    int current = mRNA.size();
    for (int j = 0; j < current; j++) {
      String string = "";
      if (mRNA.size() >= 3) {
        for (int k = 0; k < 3; k++) {
          Character character = mRNA.dequeue();
          string = string + character;
        }
        for (int l = 0; l < mRNAtoProteinMap.length; l++) {
          if (mRNAtoProteinMap[l][0].equals(string)) {
            if (mRNAtoProteinMap[l][1].equals("STOP")) {
              return aminoAcids;
            } else {
              aminoAcids.enqueue(mRNAtoProteinMap[l][1]);
            }
          }
        }
      }
    }
    return aminoAcids;
  }


  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using the
   * other two methods in this class.
   * 
   * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence,
   *         via its mRNA transcription
   */
  public LinkedQueue<String> translateDNA() {
    LinkedQueue<Character> transcribeDNA = transcribeDNA();
    LinkedQueue<String> mRNATranslate = mRNATranslate(transcribeDNA);
    return mRNATranslate;
  }
}
