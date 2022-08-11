import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.swing.*;

public class toobytes{

	
	public static byte[] encryptedimage(Key key, byte[] content) {
    Cipher cipher;
    byte[] encrypted = null;
	try {
		cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    	cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = cipher.doFinal(content);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return encrypted;

    }
    public static byte[] decryptedimage(Key key, byte[] textCryp) {
    Cipher cipher;
    byte[] decrypted = null;
    try {
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        decrypted = cipher.doFinal(textCryp);
    } catch (Exception e) {
        e.printStackTrace();
    }
		return decrypted;
    }



    public static void saveFile(byte[] bytes) throws IOException {

        FileOutputStream fos = new FileOutputStream("D:\\vineet pic.jpeg");
        fos.write(bytes);
        fos.close();

    }

	public static void main(String[] args) throws IOException
	{
	try{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(null);
			File file = fileChooser.getSelectedFile();

			FileInputStream fi = new FileInputStream(file);
			byte[] bytes = new byte[fi.available()];
			fi.read(bytes);
			System.out.println(bytes.length);
			/*for(byte b:bytes)
			{
				System.out.print(b);
			}*/

			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        	keyGenerator.init(128);
        	Key key = keyGenerator.generateKey();
        	System.out.println(key);

        	byte[] encrypted = encryptedimage(key, bytes);
         	System.out.println(encrypted);

        	byte[] decrypted = decryptedimage(key, encrypted);
        	System.out.println(decrypted);

        	saveFile(encrypted);
        	System.out.println("Done");

        	saveFile(decrypted);
        	System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}
}	