package br.com.cobello.service;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

/**
 * Service
 * @author Felipe
 *
 */
@Service
public class AESService 
{
	/**
	 * SALT é usado para que um mesmo dado criptografado tenha valores diferentes,
	 * é recomendado que seja um valor aleatorio para cada operação, porem deve ser o mesmo valor usado
	 * ao encriptar e descriptar um dado
	 */
	static String SALT = "EC2034B6C01D6A62";
	/**
	 * Password para geração da chave AES Derivada
	 */
	static String SECRET = "MYSECRETKEY";
	
	/**
	 * Criptografa
	 * @param data
	 * @return
	 */
	public String encrypt(String data) 
	{
	    try
	    {
	        IvParameterSpec ivspec = new IvParameterSpec("0000000000000000".getBytes());
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 65536, 256);
	        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	/**
	 * Descriptografa
	 * @param data
	 * @return
	 */
	public String decrypt(String data) 
	{
	    try
	    {
	        IvParameterSpec ivspec = new IvParameterSpec("0000000000000000".getBytes());
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 65536, 256);
	        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
}
