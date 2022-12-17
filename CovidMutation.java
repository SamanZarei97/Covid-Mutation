/**
 * Name: Saman Zarei
 * This program is a simulator of covid treatment.The nucleobases in covid are
 * Adenine, Guanine, Thymine, Cytosine, Uracil. What this program does, is
 * breaking every k number of nucleobases in chunk size of k and reverse them.
 * By doing this, covid nucleobases will be weak and breakable.
 */
import java.util.Scanner;

/**
 * This class has designed to break down every k number of nucleobases in
 * chunk size of k and reverse them.
 * Adenine(A), Thymine(T), Cytosine(C), Guanine(G),
 * @author Saman Zarei
 */
public class CovidMutation{

  /**
   * This method, gets the sequence of Covid nucleobases as input, breaks down
   * every k number of nucleobases in chunk size of k and reverse them.
   * @param args the command line arguments
   */
  public static void main(String[] args){

    Scanner gg = new Scanner(System.in);
    // The covid sequence of nucleobases.
    String input = gg.nextLine();
    // Chunk size of nucleobases to reverse together.
    int k = gg.nextInt();
    // showing the reversed covid sequence of nucleobases.
    String reverse = "";
    // Sequence length
    int size = input.length();

    // If chunkSize is 0 or negative, it does reverse.
    if(k <= 0){
      reverse = input;
    }

    // If ChunkSize is greater than sequence length.
    else if(k > size){
      // The whole sequence will reverse.
      for(int i = size - 1; i >= 0; i--){
        reverse = reverse + input.charAt(i);
      }
    }

    // If the sequence length is divisible by ChunkSize.
    else if(size % k == 0){
      // Reverse the group of chunkSize nucleobases together.
      for(int i = 0; i < size; i += k){
        for(int j = (k-1) + i; j >= i; j--){
          reverse = reverse + input.charAt(j);
        }
      }
    }

    // If the sequence length is not divisible by ChunkSize.
    else if(size % k != 0){
      // Reverse the group of chunkSize nucleobases together.
      for(int i = 0; i < size - size % k; i += k){
        for(int j = (k-1) + i; j >= i; j--){
          reverse = reverse + input.charAt(j);
        }
      }
      // Reverse remained nucleobases together and add them into reverse.
      for(int i = size - 1; i >= size - size % k; i-- ){
        reverse = reverse + input.charAt(i);
      }
    }

    // Print the reverse sequence
    System.out.println(reverse);
  }
}
