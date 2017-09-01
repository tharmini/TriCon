package TriCon.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * The Class KeyUtil is used to read the private and public key
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class KeyUtil {

	/** The Constant ALGORITHM. */
	private static final String ALGORITHM = "RSA";

	/**
	 * Gets the key data.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the key data
	 */
	private static byte[] getKeyData(String filePath)
	{
		File file = new File(filePath);
		byte[] buffer = new byte[(int) file.length()];
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			fis.read(buffer);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (fis != null)
				try
				{
					fis.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return buffer;
	}

	/**
	 * Gets the stored private key.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the stored private key
	 */
	public static PrivateKey getStoredPrivateKey(String filePath)
	{
		PrivateKey privateKey = null;
		byte[] keydata = getKeyData(filePath);
		PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(keydata);
		KeyFactory keyFactory = null;
		try
		{
			keyFactory = KeyFactory.getInstance(ALGORITHM);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		try
		{
			privateKey = keyFactory.generatePrivate(encodedPrivateKey);
		}
		catch (InvalidKeySpecException e)
		{
			e.printStackTrace();
		}

		return privateKey;
	}

	/**
	 * Gets the stored public key.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the stored public key
	 */
	public static PublicKey getStoredPublicKey(String filePath)
	{
		PublicKey publicKey = null;
		byte[] keydata = getKeyData(filePath);
		KeyFactory keyFactory = null;
		try
		{
			keyFactory = KeyFactory.getInstance(ALGORITHM);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		X509EncodedKeySpec encodedPublicKey = new X509EncodedKeySpec(keydata);
		try
		{
			publicKey = keyFactory.generatePublic(encodedPublicKey);
		}
		catch (InvalidKeySpecException e)
		{
			e.printStackTrace();
		}
		return publicKey;
	}
}