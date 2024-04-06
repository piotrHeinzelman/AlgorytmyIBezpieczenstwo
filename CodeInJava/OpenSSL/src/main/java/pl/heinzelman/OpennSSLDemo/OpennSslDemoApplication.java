package pl.heinzelman.OpennSSLDemo;


import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;

public class OpennSslDemoApplication {

	public static void main(String[] args) throws Exception {

	// run with Git term
	//  # Generate private key with pkcs1 encoding
	//  openssl genrsa -out c:\temp\private_key_rsa_4096_pkcs1.pem 4096

	// # Convert private key to pkcs8 encoding
	//	openssl pkcs8 -topk8 -in c:\temp\private_key_rsa_4096_pkcs1.pem -inform pem -out c:\temp\private_key_rsa_4096_pkcs8-exported.pem -outform pem -nocrypt
	//	Path C:\Users\John\Desktop\AlgorytmyIBezpieczenstwo\CodeInJava\OpenSSL\

    //# Export public key in pkcs8 format
	//openssl rsa -pubout -outform pem -in private_key_rsa_4096_pkcs8-generated.pem -out public_key_rsa_4096_pkcs8-exported.pem
	//	openssl rsa -pubout -outform pem -in private_key_rsa_4096_pkcs1.pem -out public_key_rsa_4096_pkcs1

	//  https://www.javacodegeeks.com/2020/04/encrypt-with-openssl-decrypt-with-java-using-openssl-rsa-public-private-keys.html



		Rsa4096	rsa = new Rsa4096( "C:\\Users\\John\\Desktop\\AlgorytmyIBezpieczenstwo\\CodeInJava\\OpenSSL\\private_key_rsa_4096_pkcs8-generated.pem", "C:\\Users\\John\\Desktop\\AlgorytmyIBezpieczenstwo\\CodeInJava\\OpenSSL\\public_key_rsa_4096_pkcs8-exported.pem" );


		String expected = getFileAsString("C:\\Users\\John\\Desktop\\AlgorytmyIBezpieczenstwo\\CodeInJava\\OpenSSL\\file_unencrypted.txt");
		String encryptedAndEncoded = getFileAsString("C:\\Users\\John\\Desktop\\AlgorytmyIBezpieczenstwo\\CodeInJava\\OpenSSL\\file_encrypted_and_encoded.txt");

		System.out.println( rsa.encryptToBase64(expected) );
		//String actual = rsa.decryptFromBase64( encryptedAndEncoded );
		}

		public static String getFileAsString( String classPathResourceLocation )
			throws Exception {
				InputStream is = new FileInputStream( classPathResourceLocation );
				byte[] bytes = is.readAllBytes();
				is.close();
				return new String(bytes);
		}
}

