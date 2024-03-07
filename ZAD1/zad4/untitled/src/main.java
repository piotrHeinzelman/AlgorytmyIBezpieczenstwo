import java.time.Duration;
import java.time.LocalDateTime;

public class main {

    private static LocalDateTime start;
    private static LocalDateTime end;
    private static Duration duration;

    private static int A[][];
    private static int B[][];

    public static void main(String[]args) {
        int n=10000;


        A = new int[n][n];
        B = new int[n][n];
        fill(A);
        fill(B);
        if (n<101) print(A);
        if (n<101) print(B);
        start = LocalDateTime.now();
        int[][] C = mul(A,B,n);

        end = LocalDateTime.now();
        if (n<101) print(C);

        duration = Duration.between(  start, end );
        System.out.println(  duration.getSeconds()+"[s]");
    }

    public static void print( int[][] X ){
        for ( int i=0;i<X.length ;i++ ){
            int Y[]=X[i];
            StringBuffer out=new StringBuffer();
            for ( int j=0;j<Y.length;j++ ){
                out.append( " | "+Y[j] );
            }
            System.out.println( out.toString() );
        }
    }

    public static void fill( int[][] X ){
        for ( int i=0;i<X.length ;i++ ){
            for ( int j=0;j<X.length;j++ ){
                X[i][j]=(i%5-3)+(j%4-2);
            }
        }
    }

    public static int[][] mul(int[][] A, int[][] B, int n){
        int C[][] = new int[n][n];
        for(int x = 0; x<n; x++ ){
            for (int y = 0; y<n; y++){
                int result=0;
                for ( int z=0;z<n;z++ ){
                    result+=A[z][y]*B[x][z];
                }
                C[x][y]=result;
            }
        }
        return C;
    }
}