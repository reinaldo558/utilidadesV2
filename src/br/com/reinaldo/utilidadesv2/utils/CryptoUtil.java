/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.utils;

import br.com.reinaldo.utilidadesv2.constantes.Constantes;
import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 *
 * @author desenv
 */
public class CryptoUtil {
    
    private static CryptoUtil INSTANCE = null;
    
    private CryptoUtil() {}
    
    public static final CryptoUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CryptoUtil();
        }
        return INSTANCE;
    }
    
    
    Cipher ecipher;
    Cipher dcipher;
    // 8-byte Salt
    byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    // Iteration count
    int iterationCount = 19;
    
    
    public String encrypt(String secretKey, String plainText)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException,
            NoSuchPaddingException,
            InvalidKeyException,
            InvalidAlgorithmParameterException,
            UnsupportedEncodingException,
            IllegalBlockSizeException,
            BadPaddingException {
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

        //Enc process
        ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        String charSet = "UTF-8";
        byte[] in = plainText.getBytes(charSet);
        byte[] out = ecipher.doFinal(in);
        String encStr = new String(Base64.getEncoder().encode(out));
        return encStr;
    }

    
    public String decrypt(String secretKey, String encryptedText)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException,
            NoSuchPaddingException,
            InvalidKeyException,
            InvalidAlgorithmParameterException,
            UnsupportedEncodingException,
            IllegalBlockSizeException,
            BadPaddingException,
            IOException {
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        //Decryption process; same key will be used for decr
        dcipher = Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        byte[] enc = Base64.getDecoder().decode(encryptedText);
        byte[] utf8 = dcipher.doFinal(enc);
        String charSet = "UTF-8";
        String plainStr = new String(utf8, charSet);
        return plainStr;
    }    
    
    
    
    public static void mainX(String[] args) throws Exception {
        CryptoUtil cryptoUtil = new CryptoUtil();
        
        /*String key="XeaS2sDaWeqA55DfeeewWqweQpkA";   
        
        String plain="This is an important message";
        
        String enc=cryptoUtil.encrypt(key, plain);
        
        System.out.println("Original text: "+plain);
        System.out.println("Encrypted text: "+enc);
        
        String plainAfter=cryptoUtil.decrypt(key, enc);
        System.out.println("Original text after decryption: "+plainAfter);*/
        System.out.println(cryptoUtil.decrypt("r47S3RKWS7cuZa3KStK33yfaYB4zNOli", "N+F4PrSowLk="));
    }
    
    public String getHashRandom() {
        return getHashRandom(32);
    }
    
    public String getHashRandom(int pSize) {
        final StringBuilder sb = new StringBuilder();
        final int size = (pSize > 0) ? pSize : 32;
        
        for (int i = 0; i < size ; i++) {
            sb.append(String.valueOf(VariaveisComuns.ALPHANUM.charAt(Constantes.RANDOM.nextInt(70))));
        }
        
        return sb.toString();
    }

    
}
