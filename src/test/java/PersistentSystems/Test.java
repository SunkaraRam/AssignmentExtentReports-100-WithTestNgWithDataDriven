package PersistentSystems;

public class Test {

	 public static void main(String[] args) {
	     Candidate candidate = new Candidate();
	     
	     System.out.println("Start Test");
	     
	     System.out.println("\nTest 1 - Candidate can Override");
	     test(candidate.toString() == null);
	     
	     System.out.println("\nTest 2 - Candidate can Throw");
	     test(candidateCanThrow(candidate));
	     
	     System.out.println("\nTest Finished");
	}

	 public static void test(boolean condition) {
	     if (condition == true) {
	         System.out.println("Test Passed");
	         return;
	     }
	     
	     System.out.println("Test Failed");
	}

	 public static boolean candidateCanThrow(Candidate candidate) {
	     try {
	         candidate.throwRuntime();
	         return false;
	     } catch (NullPointerException e) {
	         return true;
	     }
	}

// Do not Edit Above this line
// Edit Below this line

 public static class Person {}

 public static class Candidate extends Object{

	 @Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}
	 
  public static int throwRuntime() {

	  String name =null;
	  return name.length();
  
 }

  public static class Associate {}
}
 
}
