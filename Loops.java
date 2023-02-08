import java.util.Arrays;
public class Loops {

  // static methods go here
  public static void nHellos(int n) {
    for (int i = 1; i <= n; i++) {
      if (i/10 == 1) System.out.println(i + "th Hello");
      else if (i%10 == 1) System.out.println(i + "st Hello");
      else if (i%10 == 2) System.out.println(i + "nd Hello");
      else if (i%10 == 3) System.out.println(i + "rd Hello");
      else System.out.println(i + "th Hello");
      
    }
  }

  public static double nRandoms(int n){
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      double r = Math.random();
      System.out.println(r);
      sum += r;
    }
    return sum / n;
  }

  public static boolean isPrime(int n) {

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        System.out.println(n%i);
        return false;
      }
    }
    return true;
  }

  public static int[] getFactors(int n) {
    //get factors of n in an array
    int[] factors = new int[n];
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        factors[count] = i;
        count++;
      }
    }
    int[] factors2 = new int[count];
    for (int i = 0; i < count; i++) {
      factors2[i] = factors[i];
    }
    return factors2;
  }

  private static int rollDie() {
    int result = (int)(Math.random() * 6) + 1;
    return result;
  }

  public static void pepysSumulation() {
    int counter12 = 0; 
    int counter6  = 0;
    final int N = 1000000;
    for (int j = 1; j <= N; j++) {
      //roll dice 12 times
      for (int i = 1; i <= 12; i++) {
        int roll = rollDie();
        if (roll == 1) counter12++;
      }
      //roll dice 6 times
      for (int i = 1; i <= 6; i++) {
        int roll = rollDie();
        if (roll == 1) counter6++;
      }
    }
    System.out.println(N + " rolls of 12 dice: " + counter12 + " ones");
    System.out.println(N + " rolls of 6 dice: " + counter6 + " ones");
    System.out.println("Probability of 2 1's in 12 dice: " + ((double)counter12 / N) / 2);
    System.out.println("Probability of 1's in 6 dice: " + ((double)counter6 / N));
    }


    public static void montyHallSimulation(int n) {
      final int Ntrials = n;
      int switchWins = 0;
      int stayWins = 0;
      //monty hall simulation
      for (int i = 1; i <= Ntrials; i++) {
        int prize = (int)(Math.random() * 3) + 1;
        int guess = (int)(Math.random() * 3) + 1;
        int reveal = (int)(Math.random() * 3) + 1;
        while (reveal == prize || reveal == guess) {
          //reveal cannot be the prize or the guess
          reveal = (int)(Math.random() * 3) + 1;
        }
        int switchGuess = (int)(Math.random() * 3) + 1;
        while (switchGuess == guess || switchGuess == reveal) {
          //switch guess cannot be the guess or the reveal
          switchGuess = (int)(Math.random() * 3) + 1;
        }
        if (switchGuess == prize) switchWins++;
        if (guess == prize) stayWins++;
      }



      System.out.println("Switch wins: " + switchWins + "/"+ Ntrials);
      System.out.println("Stay wins: " + stayWins+ "/"+ Ntrials);
      System.out.println("Switch win rate: " + (int)(((double)switchWins / Ntrials) * 100) + "%");

      }

    






  public static void main(String[] args) {

    // testing of static methods goes here
    System.out.println("-----nHellos-----");
    nHellos(22);
    System.out.println("-----nRandoms-----");
    System.out.println("\n"+nRandoms(10));
    System.out.println("-----IsPrime-----\n"+isPrime(57));
    System.out.println("-----getFactors-----");
    System.out.println(Arrays.toString(getFactors(24)));
    System.out.println("-----pepysSumulation-----");
    pepysSumulation();
    System.out.println("-----montyHallSimulation-----");
    montyHallSimulation(100);

  }
}