import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DKnight900
 * 
 * Given a matrix of m x n elements (m rows, n columns), return 
 * all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5]. 
 */
public class SpiralMatrix 
{
    public static void main(String[] args) 
    {           
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{2,3}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3,4,5},{5,4,8,1,2},{4,3,9,2,1},{3,1,10,3,3},{2,2,11,4,4}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public List<Integer> spiralOrder(int[][] matrix) 
    {   
        List<Integer> results=new ArrayList<>();
        if(matrix!=null && matrix.length>0)
        {
            int rows=matrix.length;
            int columns=matrix[0].length;
            int i=0,j;
            int x=rows,y=columns,w=0,z=1,prints=0;            
            while(true){            
                for(j=w;j<y;j++)
                {                   
                    results.add(matrix[i][j]);
                    prints++;
                }      
                if(prints==columns*rows)
                    break;
                j--;
                y--;
                for(i=z;i<x;i++)
                {
                    results.add(matrix[i][j]);
                    prints++;
                }
                if(prints==columns*rows)
                    break;
                i--;
                x--;
                for(j = y - 1; j >= w; j--)
                {
                    results.add(matrix[i][j]);
                    prints++;
                }
                if(prints==columns*rows)
                    break;
                j++;
                w++;
                for(i = x - 1; i>=z; i--)
                {
                    results.add(matrix[i][j]);
                    prints++;
                }
                if(prints == columns * rows)
                    break;
                z++;            
                i++;
            }
        }
        return results;        
    }
    
}
