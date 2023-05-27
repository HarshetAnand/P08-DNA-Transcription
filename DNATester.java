//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 DNA Transcription: DNATester Class
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
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {

  // TODO: verify your LinkedQueue implementation directly

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    return false;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString());
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }

  /**
   * Tests the mRNATranslate() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    // This tests whether the sequence is normal
    DNA tester1 = new DNA("GCGACCGGG");
    LinkedQueue <Character> mRNATester1 = tester1.transcribeDNA();
    if (!(tester1.mRNATranslate(mRNATester1).toString().trim().
            replaceAll(" ", "").equals("ATG"))) {
      System.out.println("Error! The mRNATranslate() method is incorrect!");
      return false;
    }

    // This tests whether the sequence is a sequence which is divisible by 3
    DNA tester2 = new DNA("GCGACCGGG");
    LinkedQueue <Character> mRNATester2 = tester2.transcribeDNA();
    if (!(tester2.mRNATranslate(mRNATester2).toString().trim().
            replaceAll(" ", "").equals("ATG"))) {
      System.out.println("Error! The mRNATranslate() method is incorrect!");
      return false;
    }

    // This tests whether the sequence is an empty sequence
    DNA tester3 = new DNA("");
    System.out.println(tester3.translateDNA().toString());
    if (!(tester3.translateDNA().toString().replaceAll(" ", "").equals(""))) {
      System.out.println("Error! The mRNATranslate() method is incorrect!");
      return false;
    }
    return true;
  }

 
  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println("mRNATranslate: " + testMRNATranslate());
  }

}
