package rsa;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class TestRsaEncodeAndDecode {

	/** */
	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 245;

	/** */
	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 256;
	
	/**
	 * java cipher使用的算法
	 */
	private static final String cipherAlg = "RSA/ECB/PKCS1Padding";
	//private static final String cipherAlg = "RSA";

	// 服务器公钥
	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Dw9nwjBmDD/Ca1QnRGy"
			+ "GjtLbF4CX2EGGS7iqwPToV2UUtTDDemq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5q"
			+ "iUwXbbEaAXPPZFmT5svPH6XxiQgsiaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNt"
			+ "IeSwUSaH2YZfwNgFWqj+y/0jjl8DUsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskd"
			+ "N6uPUj9Ga/IKnwUIv+wL1VWjLNlUjcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUH"
			+ "rZrJsKkauqnwJsYbijQU+a0HubwXB7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoE"
			+ "vQIDAQAB";

	// 服务器私钥
	private static final String serverPrvKey = "MIIEpAIBAAKCAQEA6Dw9nwjBmDD/Ca1QnRGyGjtLbF4CX2EGGS7iqwPToV2UUtTD"
			+ "Demq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5qiUwXbbEaAXPPZFmT5svPH6XxiQgs"
			+ "iaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNtIeSwUSaH2YZfwNgFWqj+y/0jjl8D"
			+ "UsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskdN6uPUj9Ga/IKnwUIv+wL1VWjLNlU"
			+ "jcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUHrZrJsKkauqnwJsYbijQU+a0HubwX"
			+ "B7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoEvQIDAQABAoIBAQDT+9kLyARfFapX"
			+ "fPquxS5bv3AzdQSZZ4kXh7KkBBQzoaX4jfmWQ4sfRRs+VjIsqsJRm4NSrlqoAa80"
			+ "TDkwhjbdKLXiDNz+ImZW5WWaMMPZ0bHOMcXlyTUI2CAtpme+cemz+13ZeJKNwfZo"
			+ "i66qZLFjVMqU6KTsrDnPX+BTRxt9utBDGs1Wl0QgCGqU5XFKXMLkQdR0+Deoii+T"
			+ "M5N282ny8X8WxgoE2IkUDXkcoVzpw3iaMeuG+UJBYyp9huugeURWSEPlfqzhrEBJ"
			+ "QDG1veY5dFaMVLOqeWjRHuo04EcwE5KjNr/ALNBlousqIEJbJ0dFgZ9c7YIF04IU"
			+ "LNog2dGJAoGBAPy8wuUPE9eStmzPzSt4ISAwXJQfvi8P8StXjjU1zfqQQalUBE7R"
			+ "d8Mcuj4i1ej6SU/ySD9u0PVW7TPVBd5XqVumdN1S6hFWaNH3VVcqfKB6r9yPFaOC"
			+ "RTwQ1cRYns8oHGv3a7RjKHHtMC1qrm15VJkJY/j021yTM+FU17j5dXHrAoGBAOs7"
			+ "uZNQ7Hz6JXK98uyvV6c5MAa0/y+yxBIlBmCL4AJIiLWtjQzvwSD3bKujn5DHcnAM"
			+ "JFhYhqye/1YFPoX3yGcI2XrK+B0LgtAD7KrVK5Nssfn992W60t/YHJv0kw5FXqXq"
			+ "NXbJNgzKe4gmsbbWLTLqs9wTRMH0UpCMiroz+ZH3AoGBANTdr1D5t/6TRS60ftuj"
			+ "3FKeKPthGO/Of5O/tLjATnJBWexiJRa1eidNZNe8w2nslB7Ps2Yp0bkxs6s6Oi0g"
			+ "rDXTJw7aLObZXoOpy6kU0c7gRop/wPvsVp/WlhU/htJ3uCh/Ramy8neyDCfUeIEf"
			+ "9c7Hh/pBURjRqpqYuPDEutRtAoGAXDwZ4sKLR+HJhzklpFqIUwBgbXDQ0oIU0UyF"
			+ "OJv/5MVOHXaEZPspTeTWTmKk8V7S505LffyQKeVaFv+NaXgjswrMQ5KMQM8/ppKz"
			+ "XLSjFnY7PtuvAsuDXdPeO+RlOOZIW2P/PKlesRs/3r3VVuyZ4moWxgckIazMJvOE"
			+ "fchdZjcCgYAiCWThafcVdvfeyGPN0oWmwf2EhW32cqI1flRQUZeLnOjgqV3bUmM5"
			+ "rGkXDIzeiJJ+zG/c4ER0fJj5rW1X4wfFuldR9ijj35/ywDO2dKsNDFuI4pgYX4Z+"
			+ "B2N9AEOhniJm9jqjrod0QW3rrg/u5i6RWQvcxoIH/UStz36inqt9Kg==";

	// 服务器私钥
	private static final String serverPrvKeyPkcs8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDoPD2fCMGYMP8J"
			+ "rVCdEbIaO0tsXgJfYQYZLuKrA9OhXZRS1MMN6arr0/wT5YniflbsiWfemAr7fbLX"
			+ "0HihPmqJTBdtsRoBc89kWZPmy88fpfGJCCyJp5m3BCNjrWoOBrpQfaZganQZus/e"
			+ "L1OM820h5LBRJofZhl/A2AVaqP7L/SOOXwNSw3a0gVVI2k1Nk1D9VfgOWfRnkME8"
			+ "rWZKyR03q49SP0Zr8gqfBQi/7AvVVaMs2VSNwQexQT5gTYU3TdWdYMn9UeztR0eF"
			+ "rh3+dQetmsmwqRq6qfAmxhuKNBT5rQe5vBcHsFgyUqi+KTA2l0xLf6UHONLkoi7q"
			+ "ZG/UagS9AgMBAAECggEBANP72QvIBF8Vqld8+q7FLlu/cDN1BJlniReHsqQEFDOh"
			+ "pfiN+ZZDix9FGz5WMiyqwlGbg1KuWqgBrzRMOTCGNt0oteIM3P4iZlblZZoww9nR"
			+ "sc4xxeXJNQjYIC2mZ75x6bP7Xdl4ko3B9miLrqpksWNUypTopOysOc9f4FNHG326"
			+ "0EMazVaXRCAIapTlcUpcwuRB1HT4N6iKL5Mzk3bzafLxfxbGCgTYiRQNeRyhXOnD"
			+ "eJox64b5QkFjKn2G66B5RFZIQ+V+rOGsQElAMbW95jl0VoxUs6p5aNEe6jTgRzAT"
			+ "kqM2v8As0GWi6yogQlsnR0WBn1ztggXTghQs2iDZ0YkCgYEA/LzC5Q8T15K2bM/N"
			+ "K3ghIDBclB++Lw/xK1eONTXN+pBBqVQETtF3wxy6PiLV6PpJT/JIP27Q9VbtM9UF"
			+ "3lepW6Z03VLqEVZo0fdVVyp8oHqv3I8Vo4JFPBDVxFiezygca/drtGMoce0wLWqu"
			+ "bXlUmQlj+PTbXJMz4VTXuPl1cesCgYEA6zu5k1DsfPolcr3y7K9XpzkwBrT/L7LE"
			+ "EiUGYIvgAkiIta2NDO/BIPdsq6OfkMdycAwkWFiGrJ7/VgU+hffIZwjZesr4HQuC"
			+ "0APsqtUrk2yx+f33ZbrS39gcm/STDkVepeo1dsk2DMp7iCaxttYtMuqz3BNEwfRS"
			+ "kIyKujP5kfcCgYEA1N2vUPm3/pNFLrR+26PcUp4o+2EY785/k7+0uMBOckFZ7GIl"
			+ "FrV6J01k17zDaeyUHs+zZinRuTGzqzo6LSCsNdMnDtos5tleg6nLqRTRzuBGin/A"
			+ "++xWn9aWFT+G0ne4KH9FqbLyd7IMJ9R4gR/1zseH+kFRGNGqmpi48MS61G0CgYBc"
			+ "PBniwotH4cmHOSWkWohTAGBtcNDSghTRTIU4m//kxU4ddoRk+ylN5NZOYqTxXtLn"
			+ "Tkt9/JAp5VoW/41peCOzCsxDkoxAzz+mkrNctKMWdjs+268Cy4Nd09475GU45khb"
			+ "Y/88qV6xGz/evdVW7JniahbGByQhrMwm84R9yF1mNwKBgCIJZOFp9xV2997IY83S"
			+ "habB/YSFbfZyojV+VFBRl4uc6OCpXdtSYzmsaRcMjN6Ikn7Mb9zgRHR8mPmtbVfj"
			+ "B8W6V1H2KOPfn/LAM7Z0qw0MW4jimBhfhn4HY30AQ6GeImb2OqOuh3RBbeuuD+7m"
			+ "LpFZC9zGggf9RK3PfqKeq30q";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// 测试加密
			//String content = "{cityId:\"110000\"}";
			String content = "{cityId:\"110100\"}";
			//String content = "常说的非对称加密。加密解密密钥不一致，它们是成对出现，本工具密钥生成是PEM格式。公钥加密的私钥解密，私钥加密的要公钥解密。往往私钥是不公开的，公钥是大家共享的。相同内容，相同私钥每次加密后结果还会不一样。RSA已被ISO推荐为公钥数据加密标准，能够阻击各种破解方案。 本工具提供公钥加密，解密功能。 通过公钥加密结果，必须私钥解密。 同样私钥加密结果，公钥可以解密。RSA加密也是块加密，因此一样存在填充模式。默认填充方式是pkcs#1。另外 私钥加密解密模块，可以看这里RSA私钥加密解密 生成RSA密钥对。 感谢你的使用，有任何问题欢迎给我消息！ ";
			String requestBody = getPubKeyEncryptString(content, serverPubKey);
			
			//测试解密
			//String mingwen = getPrvKeyDecryptString(requestBody, serverPrvKeyPkcs8);

			// 测试zuul解密
//			HttpHeaders headers = new HttpHeaders();
//			MediaType type = MediaType
//					.parseMediaType("application/json; charset=UTF-8");
//			headers.setContentType(type);
//			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//			RestTemplate restTemplate = new RestTemplate();
//			String toUrl = "http://localhost:8500/my-app/";

			// 传byte数组
			// HttpEntity<byte[]> httpEntity = new
			// HttpEntity<byte[]>(encodeBytes, headers);
			// restTemplate.postForEntity(toUrl, httpEntity, byte[].class);

			// 传string对象
//			HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody,
//					headers);
//			restTemplate.postForEntity(toUrl, httpEntity, String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 公钥加密数据(经过base64加密)
	public static String getPubKeyEncryptString(String data, String pubKeyStr) {

		KeyFactory kf;
		String encodeToString = null;
		System.out.println("明文的内容：" + data);

		try {
			kf = KeyFactory.getInstance("RSA");

			// Cipher cipher = Cipher.getInstance("RSA");
			Cipher cipher = Cipher.getInstance(cipherAlg);
			Base64 base64 = new Base64();
			byte[] serverPubKeyBytes = base64.decode(pubKeyStr);

			// 生成公钥
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(
					serverPubKeyBytes);
			PublicKey pubKey = kf.generatePublic(pubSpec);
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);

			//分段加密
			byte[] bytes = data.getBytes();
			int inputLen = bytes.length;
			System.out.println("明文的字节长度: " + inputLen);
			int offLen = 0;// 偏移量
			int i = 0;
			byte[] cache;
			ByteArrayOutputStream bops = new ByteArrayOutputStream();
			while (inputLen - offLen > 0) {
				if (inputLen - offLen > MAX_ENCRYPT_BLOCK) {
					cache = cipher.doFinal(bytes, offLen, MAX_ENCRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(bytes, offLen, inputLen - offLen);
				}

				bops.write(cache);
				i++;
				offLen = MAX_ENCRYPT_BLOCK * i;
			}

			bops.close();
			byte[] encryptedData = bops.toByteArray();
			System.out.println("密文的字节长度: " + encryptedData.length);
			byte[] base64EncodeBytes = base64.encode(encryptedData);
			System.out.println("base64编码密文后的字节长度: " + base64EncodeBytes.length);
			encodeToString = new String(base64EncodeBytes, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("密文的内容: " + encodeToString);
		return encodeToString;
	}
	
	//私钥解密数据
	public static String getPrvKeyDecryptString(String encryptStr, String prvKeyStr) {

		KeyFactory kf;
		String decodeToString = null;
		System.out.println("密文的内容: " + encryptStr);

		try {
			kf = KeyFactory.getInstance("RSA");

			// Cipher cipher = Cipher.getInstance("RSA");
			Cipher cipher = Cipher.getInstance(cipherAlg);
			Base64 base64 = new Base64();
			
			// 生成私钥
			byte[] serverPrvKeyBytes = base64.decode(prvKeyStr);
			PKCS8EncodedKeySpec prvSpec =new PKCS8EncodedKeySpec(serverPrvKeyBytes);
			PrivateKey prvKey = kf.generatePrivate(prvSpec);
			
			//分段解密
			cipher.init(Cipher.DECRYPT_MODE, prvKey);
	        
			byte[] encryptBytes = encryptStr.getBytes();
			System.out.println("密文的字节长度: " + encryptBytes.length);
			byte[] base64DecodeBytes = base64.decode(encryptBytes);
			System.out.println("base64解码密文后的字节长度: " + base64DecodeBytes.length);
			
	        int inputLen = base64DecodeBytes.length;
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int offSet = 0;
	        byte[] cache;
	        int i = 0;
	        // 对数据分段解密
	        while (inputLen - offSet > 0) {
	            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
	                cache = cipher.doFinal(base64DecodeBytes, offSet, MAX_DECRYPT_BLOCK);
	            } else {
	                cache = cipher.doFinal(base64DecodeBytes, offSet, inputLen - offSet);
	            }
	            out.write(cache, 0, cache.length);
	            i++;
	            offSet = i * MAX_DECRYPT_BLOCK;
	        }
	        
	        byte[] decryptedData = out.toByteArray();
	        out.close();
	        System.out.println("明文的字节长度: " + decryptedData.length);
	        
	        decodeToString = new String(decryptedData, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("明文的内容: " + decodeToString);
		return decodeToString;
	}

}
