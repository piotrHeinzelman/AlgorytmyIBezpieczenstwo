import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RSA {
    private final Integer e=65537;
    private final BigInteger d;
    private final BigInteger n;




    public  RSA (){
        BigInteger p =  ( BigInteger.TWO.pow( 2000 ).multiply( BigInteger.valueOf(new Random().nextInt(0,1000))));
                   p = p.nextProbablePrime();
        BigInteger q =  ( BigInteger.TWO.pow( 2000 ).multiply( BigInteger.valueOf(new Random().nextInt(0,1000))));
                   q = q.nextProbablePrime();
    BigInteger CDofN = ( p.subtract(BigInteger.ONE).multiply( q.subtract(BigInteger.ONE)));
                   n = p.multiply(q);
        BigInteger be = BigInteger.valueOf( e );
                   d = be.modInverse( CDofN );

        System.out.println("p:"+p);
        System.out.println("q:"+q);
        System.out.println("CDofN: "+CDofN);
        System.out.println("n: "+n);
        System.out.println("d:"+d);
        System.out.println("e:"+e);
        System.out.println( d.multiply(be).mod( n ).toString());

    }

    public BigInteger encrypt ( String s ) {
        BigInteger svalue=BigInteger.ZERO;
        char[] chars = s.toCharArray();
        for ( int i=0;i<chars.length;i++ ){
            svalue=svalue.multiply( BigInteger.valueOf(256L)).add( BigInteger.valueOf( chars[i] ));
        }
        System.out.println( "SVal:" + svalue );
        BigInteger C = svalue.modPow( BigInteger.valueOf(e), n ); //  .pow( e ).mod(n);
        return C;
    }

    public String decrypt ( BigInteger C ) {
        BigInteger m = C.modPow( d, n );
        StringBuffer out=new StringBuffer();

        System.out.println( "SVal:" + m );
        byte[] bary = m.toByteArray();
        for ( int i=0;i<bary.length ; i++ ){
          out.append( (char) (128+bary[i]) );
        }
        return out.toString();
    }

}
