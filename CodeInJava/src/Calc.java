
import java.math.BigInteger;


public class Calc{


	public BigInteger bigMul(  BigInteger x , BigInteger n, BigInteger m ){
		BigInteger y = BigInteger.ONE;
		BigInteger kw = x;
		int i=0;
		for (;i<999999;i++) {
			if (n.testBit(1)) { y = y.multiply(kw.mod(m)); }
				kw = kw.multiply(kw.mod(m));
				n = n.divide(BigInteger.TWO);
				if ( n.bitLength()==0 ) break;
			}
		System.out.println( "i:" + i + " : " + y.toString() );
		return y;
	}




	public void test(){
		System.out.println( "10" );
		BigInteger x=new BigInteger("123");
		BigInteger n=new BigInteger("123456789");
		BigInteger m=new BigInteger("128294029");
//		bigMul( x,n,m ) ;

		System.out.println( "20" );
		 n=new BigInteger("123456123456789789");
		 m=new BigInteger("128212345678994029");
		// bigMul( x,n,m ) ;

		System.out.println( "50" );
		 n=new BigInteger("123456111234567892345678923123456789456789789");
		 m=new BigInteger("128212311234567892345678912345678945678994029");
		//bigMul( x,n,m ) ;

		System.out.println( "100" );
		 n=new BigInteger("123451234561112345678923456789231234567894567897896111234567892345678923123456789456789789");
		 m=new BigInteger("123456111234567892123456111234567892345678923123456789456789789345678923123456789456789789");
		bigMul( x,n,m ) ;


	}

/*
https://pl.wikipedia.org/wiki/Logarytm_dyskretny

Logarytm dyskretny elementu {\displaystyle b}{\displaystyle b} przy podstawie {\displaystyle a}{\displaystyle a} w danej grupie skończonej – liczba całkowita {\displaystyle c,}{\displaystyle c,} dla której zachodzi równość (w notacji multiplikatywnej):

{\displaystyle a^{c}=b.}{\displaystyle a^{c}=b.}
Logarytm dyskretny nie zawsze istnieje, a jeśli istnieje, może nie być jednoznaczny.
Np. w ciele skończonym {\displaystyle \mathbb {Z} _{11}}{\displaystyle \mathbb {Z} _{11}} logarytmem przy podstawie 4 z elementu 9 jest liczba 3 (ale też 8). W tym ciele nie istnieje logarytm przy podstawie 4 z elementu 7.

Znalezienie logarytmu dyskretnego jest zaskakująco trudnym problemem.
O ile potęgowanie wymaga {\displaystyle O\left(\log c\right)}{\displaystyle O\left(\log c\right)} operacji – liczymy {\displaystyle a,a^{2},a^{4},a^{8},\dots ,}{\displaystyle a,a^{2},a^{4},a^{8},\dots ,} po czym wymnażamy te z nich, dla których bity c są równe 1, to jedyną prostą metodą rozwiązywania problemu logarytmu dyskretnego jest przeszukanie wszystkich możliwych {\displaystyle c.}{\displaystyle c.} Istnieją efektywniejsze metody, jednak żadna z ogólnych metod nie ma złożoności wielomianowej wobec ilości bitów wejścia (istnieją takie dla pewnych specyficznych klas liczb pierwszych, których należy więc w kryptografii unikać). Najszybszy algorytm (sito ciała liczbowego) obliczania logarytmu dyskretnego w GF(p) ma złożoność czasową:

{\displaystyle e^{c\cdot \log _{2}^{\frac {1}{3}}(p)\cdot \log _{2}^{\frac {2}{3}}\left(\log _{2}(p)\right)},}{\displaystyle e^{c\cdot \log _{2}^{\frac {1}{3}}(p)\cdot \log _{2}^{\frac {2}{3}}\left(\log _{2}(p)\right)},}
gdzie c jest pewną stałą. Jedną z metod obliczania logarytmu dyskretnego w GF(p) jest redukcja Pohliga-Hellmana.

Trudność znalezienia logarytmu dyskretnego jest podstawą istnienia wielu algorytmów kryptograficznych, takich jak ElGamal i protokół Diffiego-Hellmana czy kryptografia oparta na krzywych eliptycznych.

 */
	public Integer log4( Integer x ){
		Integer ret=4;
		for (int i=1; i<x; i++  ){
			ret=ret*4;
		}
		return ret;
	}

	public Integer log5( Integer x ){
		Integer ret=5;
		for (int i=1; i<x; i++  ){
			ret=ret*5;
		}
		return ret;
	}

	public Integer pot2( Integer y ){
		Integer Out=2;
		for ( Integer i=1;i<y;i++){
			Out=Out*2;
		}
		return Out;
	}

	public Integer Z_5( Integer x ){ return x%5; }
	public Integer Z_7( Integer x ){ return x%7; }
	public Integer Z_11( Integer x ){ return x%11; }
	public Integer Z_12( Integer x ){ return x%12; }
	public Integer Z_13( Integer x ){ return x%13; }
	public Integer Z_17( Integer x ){ return x%17; }
	public Integer Z_19( Integer x ){ return x%19; }
	public Integer Z_60( Integer x ){ return x%60; }
	public Integer Z_55( Integer x ){ return x%55; }
	public Integer Z_91( Integer x ){ return x%91; }
	public Integer Z_49( Integer x ){ return x%49; }


	public void test2(){

		//  Znaleźć  logarytm dyskretny log58  w  Z*13     i  w Z*19 .
		// log5 8 =
		//System.out.println( log4( 2 ) );
		//System.out.println( Z_11 ( log4( 2 )));

		//     8       x
		// log5  -> 8=5
		if (true){
		for (int i=0;i<100;i++){
			if ( Z_19( log5( i ))==8) { System.out.println( "log5 8 = " + Z_19(i) + " w Z19" ); break; }
		}
		for (int i=0;i<100;i++){
			if ( Z_13( log5( i ))==8) { System.out.println( "log5 8 = " + Z_13(i) + " w Z13" ); break; }
		}}

		//https://www.youtube.com/watch?v=x12La1oBKhM
		// https://www.youtube.com/watch?v=TMTlpmObuQY


		if (false){
		// odwrotnosc
		int a=13;
		for ( int i=0;i<1000;i++){
			//if ( Z_13(a*i)==1 ) { System.out.println( "8^-1 Z13 = " + i  ); break; }
			if ( Z_60(a*i)==1 ) { System.out.println( a+"^-1 Z60 = " +i + " : " + Z_60(i) ); break; }
		}}

		if (false) {
		int a=247 ; //, 13, 19 , 133,
		for ( int i=1;i<100;i++){
			if ( a%i==0 ){ System.out.println( i ); }
		}}
		//1729

		if (false){
			for (int i=0;i<1000;i++){
				if ( (Z_5(i)==4) && (Z_11(i)==7) ){ System.out.println( i ); }
			}}

		if (true){
			for (int i=0;i<1000000;i++){
				if ( (Z_7(i)==6) && (Z_13(i)==7) && (Z_5(i)==4) && (Z_11(i)==7) ){ System.out.println( i ); }
			}}

		if (false) {
			int i=1294;
				System.out.println(Z_91(i));
				System.out.println(Z_55(i));
				System.out.println(Z_7(20));
				System.out.println(Z_13(20));
				System.out.println(Z_5(29));
				System.out.println(Z_11(29));
		}

		if ( false ){
			for ( int i=0;i<100;i++ ){
				System.out.println( i + " : mod49 " + Z_49( pot2( i ) ) );
			}
		}

	}


















}