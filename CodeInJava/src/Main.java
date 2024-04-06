import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {


        if (false) {
            Cwiczenie2 C = new Cwiczenie2();
            C.run();

        }
        else {


            Zad3 zad3 = new Zad3();
        /*
        char[] datagram=new char[28];
            datagram="SchowalemKluczPodWycieraczka".toCharArray(); // dont use UTF-8

        char[] key=new char[28];
            key="@1To2JesT3Moj4TajnY5Klucz6@!".toCharArray();

        char[] zaszyfrowany = zad3.vernam(  datagram, key );

        char[] cos = zad3.vernam(  datagram, zaszyfrowany );

        System.out.println(  zaszyfrowany  ); // R< E+	9x!	N9 V"	L+@
        System.out.println( cos ); //@1To2JesT3Moj4TajnY5Klucz6@!  coś = klucz

        */
            String fileName = "myFile.txt";
            char[] chars = zad3.fileToCharAry(fileName);
            char[] key = "ADMIN".toUpperCase().toCharArray();

            char[] C = zad3.Vigenere(chars, key);

            String fileNameOut = "myFile.out";
            zad3.charAryToFile(fileNameOut, C );
        }
    }

















}