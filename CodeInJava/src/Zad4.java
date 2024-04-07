import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Zad4 {

    public void run(){
        /*
        1. Wybieramy losowo liczbę pierwszą q o długości ≈160 bitów (stosuje się do tego generator
liczb losowych i algorytm testujący pierwszość liczby).

2. Wybieramy 2-gą liczbę pierwszą p>q o długości 512 ≤ L ≤ 1024 bitów taką, że
p ≡ 1(mod q) czyli co oznacza , że p-1 jest podzielne przez q .
(przyjmujemy na ogół, że
p −1 ≡ 0 (mod q)
64 L , czyli L jest wielokrotnością 64 ale nie jest to istotne przy
dowodzie poprawności DSS).
         */


        //System.out.println( generatorBBC( 100 ) );
        //System.out.println( Miller_Rabbin_isPrime ( 4 , BigInteger.valueOf( 2L ) ,  10L ) );
    }


    ArrayList<BigInteger> generatorBBC ( int len ) {
        return generatorBBC( 11L,17L,3L,len );
    }

    ArrayList<BigInteger> generatorBBC ( Long p, Long q, Long s, int len ){

        BigInteger p1=BigInteger.valueOf( p ); // p=11
        BigInteger q1= BigInteger.valueOf( q ); // q=23
        BigInteger ziarno = BigInteger.valueOf( s ); // s=3
        BigInteger n = p1.multiply( q1 );
        ArrayList<BigInteger> myList = new ArrayList<>();

        for ( int i=0;i<len;i++ ){
            ziarno = (( ziarno.multiply( ziarno )).mod( n ));
            if ( myList.contains( ziarno ) ) {
                System.out.println("petla! i="+i );
                return myList;
            }
            myList.add( ziarno );
        }
        return  myList;
    }





    public boolean Miller_Rabbin_isPrime ( Integer s , BigInteger r , Long t ){
        BigInteger n = BigInteger.TWO.pow( s ).multiply( r ).add( BigInteger.ONE );
        return Miller_Rabbin_isPrime( BigInteger.valueOf(s), r , t , n );
    }

    public boolean Miller_Rabbin_isPrime ( BigInteger s , BigInteger r , Long t , BigInteger n ){
        for ( Long i=0L; i<t ; i++){
            BigInteger a;
            BigInteger j;
            BigInteger y;
                //a = generatorBBC(11).get(0).add(BigInteger.TWO);
                Random rand = new Random();
                a=BigInteger.valueOf( rand.nextInt() );
                System.out.println( a.toString() );
            BigInteger m=( n.subtract( BigInteger.ONE ).divide( BigInteger.TWO ) );
            j=s;
               while( j.toString().indexOf("-")==-1 ){
                   y = a.modPow( m, n ).mod( n );
                   if ( y.mod(n).compareTo( BigInteger.ONE )!=1L && y.compareTo(  ( n.subtract(BigInteger.ONE)).mod(n)  )!=0 ){
                       System.out.println("n jest liczba złożoną");
                       return false;
                   }
                   if ( y.compareTo(  ( n.subtract(BigInteger.ONE)).mod(n)  )==0  ){
                       j=BigInteger.ZERO;
                   } else {
                       j=j.subtract(BigInteger.ONE);
                       m=m.divide(BigInteger.TWO);
                   }
               }
        }
        System.out.println("n jest liczba pierwszą" + n.toString());
        return true;
    }










}
