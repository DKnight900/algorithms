/**
 *
 * @author DKnight900
 */
public class InsertionSort 
{
    public static void main(String[] args) 
    {
        int A[] = {5, 2, 4, 6, 1, 3};
        insertion_sort(A);
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + ",");
        
    }
    public static void insertion_sort(int A[])
    {
        int key;
        int i;
        
        for(int j = 1; j < A.length; j++)
        {
            key = A[j];
            i = j - 1;
            while(i >= 0 && A[i] > key)
            {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }
}
