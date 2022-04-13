package br.com.supplyradar.usuario.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	private static String hexDigits = "0123456789abcdef";

	private static MessageDigest getMD() throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("MD5");
	}

	public static String md5(String str) throws NoSuchAlgorithmException {
		StringBuffer sbuffer = new StringBuffer();
		MessageDigest md = getMD();

		byte b[];
		md.reset();
		b = md.digest( str.getBytes() );
		for (int i = 0; i < 16; i++) {
			int j = (b[i]) & 0xFF;
			sbuffer.append(hexDigits.charAt(j / 16));
			sbuffer.append(hexDigits.charAt(j % 16));
		}

		return sbuffer.toString();
	}

	public static String md5(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
		String output = null;

		byte[] buffer = new byte[8192];
		MessageDigest md = getMD();
		int read = 0;

		while( (read = inputStream.read(buffer)) > 0) {
			md.update(buffer, 0, read);
		}

		byte[] md5sum = md.digest();
		BigInteger bigInt = new BigInteger(1, md5sum);
		output = bigInt.toString(16);

		return output;
	}

	public static String md5(File file) throws NoSuchAlgorithmException, IOException {
		String output = null;
		InputStream is = null;
		try {

			is = new FileInputStream(file);
			output = md5(is);

		} finally {

			try	{
				if (is != null) {
					is.close();
				}
			} catch(IOException e) {
				throw new RuntimeException("Não foi possivel fechar o arquivo", e);
			}

		}

		return output;
	}
}
