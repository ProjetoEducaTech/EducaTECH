package br.senac.educatech.util.hash;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Hash {
	
	public static byte[] gerarSal() {
		
		SecureRandom random = new SecureRandom();
		byte[] sal = new byte[16];
		random.nextBytes(sal);
		
		return sal;
	}

	public static String gerarHash(byte[] sal, String senha) throws InvalidKeySpecException, NoSuchAlgorithmException {
		
		KeySpec spec = new PBEKeySpec(senha.toCharArray(), sal, 65536, 128);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		byte[] hash = factory.generateSecret(spec).getEncoded();
		
		return converterParaHexadecimal(hash);
	}

	private static String converterParaHexadecimal(byte[] hash) {
		return new String(Hex.encodeHex(hash));
	}
}