package encryption;

import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class CustomJasyptEncryptor {
	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		// create an instance of Scanner class   
        Scanner sc = new Scanner(System.in);
        String inputStr ="";
        while  (inputStr.equals("")) {
	        System.out.print("Enter an expression to encrypt: \n");   
	        inputStr = sc.nextLine();
        }
        String password ="";
        while  (password.equals("")) {
        System.out.print("Enter an encryption Password: \n");
        password =sc.nextLine();
        }
		encryptor.setPassword(password);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		String encryptedText = encryptor.encrypt(inputStr);
		System.out.println("Encrypted value is: \n".concat(encryptedText));
		
		System.out.println("Remember to include this to your Spring project:");
		System.out.println("In the POM.XML add this dependency: \n"
		+"<dependency>\r\n"
		+ "    <groupId>com.github.ulisesbocchio</groupId>\r\n"
		+ "    <artifactId>jasypt-spring-boot</artifactId>\r\n"
		+ "    <version>2.0.0</version>\r\n"
		+ "</dependency>\r\n"
		+ "\r\n"
		+ " And the Encrypted property as ENC("+encryptedText+")");
		
		
		
		
	}
}
