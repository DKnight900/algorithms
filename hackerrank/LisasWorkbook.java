package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DKnight900
 *
 */
public class LisasWorkbook {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt(); // Number of chapters
        int k = s.nextInt(); // Max problems per page
        int problemsPerChapter[] = new int[n];
        int numberOfPagesPerChapter = 0;
        int indexes = 1;
        Map<Integer,List<Integer>> dataRecording= new HashMap<>();        
                
        for(int i = 0;i < n; i++)
        {
            problemsPerChapter[i] = s.nextInt();
            if (problemsPerChapter[i] < k) {
                numberOfPagesPerChapter = 1;
            }
            else {
                numberOfPagesPerChapter = (problemsPerChapter[i] / k) + (problemsPerChapter[i] % k);
            }
            List<Integer> indexesPerChapter = new LinkedList<>();
            for(int j = 1; j <= numberOfPagesPerChapter; j++)
            {
                indexesPerChapter.add(indexes);
                indexes++;                
            }
            dataRecording.put(problemsPerChapter[i], indexesPerChapter);
        }
    }
}
