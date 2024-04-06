import java.io.*;
import java.nio.CharBuffer;

public class Zad3 {



    public char[] Vigenere( char[] datagram, char[] key ) throws Exception {
        char[] chars = new char[ datagram.length ];
        for (int i=0;i<datagram.length;i++) {
            int A=datagram[i];
            int K=key[i];
            chars[i] = (char) (A^K);
        }
        return chars;
    }



    public char[] vernam( char[] datagram, char[] key ) throws Exception {
        if ( datagram.length!=key.length ) throw new Exception("niezgodne długości");
        char[] chars = new char[ datagram.length ];
        for (int i=0;i<datagram.length;i++) {
            int A=datagram[i];
            int K=key[i];
            chars[i] = (char) (A^K);
        }
    return chars;
    }

    String bytesToString ( char[] chars ){
        return String.valueOf(chars);
    }

    public char[] fileToCharAry( String fileName ){
        try {
            File f = new File( fileName );
            int len = (int) f.length();
            char[] buf = new char[len];
            FileReader fr = new FileReader( fileName );
            fr.read( buf );
            fr.close();
            return buf;
        } catch (Throwable e) { throw new RuntimeException(e); }
    }

    public void charAryToFile( String fileName , char[] buf ){
        try {
            FileWriter fw = new FileWriter( fileName );
            fw.write( buf );
            fw.close();
        } catch (Throwable e) { throw new RuntimeException(e); }
    }

}
