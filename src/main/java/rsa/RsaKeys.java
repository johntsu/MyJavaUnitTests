package rsa;

/**
 * rsa加解密用的公钥和私钥
 * @author Administrator
 *
 */
public class RsaKeys {
	
	//服务器公钥
	private static final String serverPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6Dw9nwjBmDD/Ca1QnRGy"
											 + "GjtLbF4CX2EGGS7iqwPToV2UUtTDDemq69P8E+WJ4n5W7Iln3pgK+32y19B4oT5q"
											 + "iUwXbbEaAXPPZFmT5svPH6XxiQgsiaeZtwQjY61qDga6UH2mYGp0GbrP3i9TjPNt"
											 + "IeSwUSaH2YZfwNgFWqj+y/0jjl8DUsN2tIFVSNpNTZNQ/VX4Dln0Z5DBPK1mSskd"
											 + "N6uPUj9Ga/IKnwUIv+wL1VWjLNlUjcEHsUE+YE2FN03VnWDJ/VHs7UdHha4d/nUH"
											 + "rZrJsKkauqnwJsYbijQU+a0HubwXB7BYMlKovikwNpdMS3+lBzjS5KIu6mRv1GoE"
											 + "vQIDAQAB";
	
	//服务器私钥
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
	
	//服务器私钥
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
			 								 
	
	//客户端公钥
	private static final String appPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyFTnjbQun5iByxPFFssK"
			 							  + "JDro0mk63j2+fXOlCl1CI8b2y/5p/Cigl8iK/DL8RFzbE7W59yI7mUkpQArv17ir"
			 							  + "ucHPXVfNGidRjlRlxh8Kd7x3MNctUn+QkDR74RVYdgUT1ddeXeeqqMmBslHEuk+q"
			 							  + "Dcn63rgzOwN/hL9YM3trXjzE5m+00NIH0rrQdHZdHQKqY/mxvHSgSjWqcDSlTmwH"
			 							  + "rUTWIycsSPab50BG4iDnw6UdHmvu3Ibv9vGhgDTvu8y7JzuiTmrt7JgbD4F0iIbU"
			 							  + "dApvMD54Fy/hq7fBydw3UZxjeg4Y6K+OoL6UZk0gQb3X5+Pjt4zCAp4TxHBXfMc+"
			 							  + "sQIDAQAB";
	
	//客户端私钥
	private static final String appPrvKey = "MIIEowIBAAKCAQEAyFTnjbQun5iByxPFFssKJDro0mk63j2+fXOlCl1CI8b2y/5p"
			 							  + "/Cigl8iK/DL8RFzbE7W59yI7mUkpQArv17irucHPXVfNGidRjlRlxh8Kd7x3MNct"
			 							  + "Un+QkDR74RVYdgUT1ddeXeeqqMmBslHEuk+qDcn63rgzOwN/hL9YM3trXjzE5m+0"
			 							  + "0NIH0rrQdHZdHQKqY/mxvHSgSjWqcDSlTmwHrUTWIycsSPab50BG4iDnw6UdHmvu"
			 							  + "3Ibv9vGhgDTvu8y7JzuiTmrt7JgbD4F0iIbUdApvMD54Fy/hq7fBydw3UZxjeg4Y"
			 							  + "6K+OoL6UZk0gQb3X5+Pjt4zCAp4TxHBXfMc+sQIDAQABAoIBAGqHS8K8x/YyQQLe"
			 							  + "dnXSbogpk1kggB9iMgPAFUlXoi4oRWDg3zcp24wbJl1KN3+a6RyoDEXwvESc9QSL"
			 							  + "TFMobpkPCNgYMobv1ZycIKqkIwrc+3zLT9yI3TTx09YzZaEMvil+pz3ETaoHzaIn"
			 							  + "fTed2U4P1AnPZd7B03Oh1KM7xDKNp/xB9wcX38qejXXyj52UAf+mj22T+VFLzW5L"
			 							  + "eRQGYDvKlA8d687s3Trczpm1htNR4Moh68GJ39D9vix8/IzIG8Txbsn5W8011na3"
			 							  + "rvKwCwq+UiRscwTpxJhdY9fgylToJqZvLM2dUgHTfdfga+JsqiGYwd7XbSW2JxaP"
			 							  + "hCUbe0kCgYEA+xeyACwdfBQM73F6F2cldAZrUUSCISYp8gmK5FDC6UWVfm4qouxE"
			 							  + "Ckneh5Ucch7J7LWWZm/rsRIoczRzMZ8l8DCoEP++9iM8khNXt7rN99fU95u1xMYN"
			 							  + "q3M3/2hQGsKV0laNPCW2W2Y9uUcWR8+E280Uue1zIjAAZrw+OUupES8CgYEAzD88"
			 							  + "B1lUwCVbF3CsGpM1pNGlAjEjcTf1kyhC8nYAxD3pMu+xqWXrO6CR0mkmmUeHyNHF"
			 							  + "QWjKEoTWtAQ+nPCsyG2zhg7WAIYaNEjDfKSX3daoDfjUKQe6nFcwlchtbyCZvD1G"
			 							  + "CwT7SgG1pSKbJXe6VvSLwywJ/hrJL7U+MG8l9h8CgYB4yipYCODaOq8KVPWd4oHS"
			 							  + "8e+YdbOADOLqy4pkUTGilFXZL1gVbkFBDc4ePS4k/Ai5dZV3i+m/EfQhj57GxT+z"
			 							  + "70Q6gT01HThbMTDmctf4nXyW7PIhSgFzdAcBOAYpCWiXegmRYLb7+xBAXCEsxHiu"
			 							  + "YFbTJpZXYO4gffgVCf+4AwKBgClhjmn2wWMEroX7QANKXA3+o63kAshHjCu6doXl"
			 							  + "PpaD7KFzSs2FZrl3+NNmlnlrsqkPRyXPc1F5NH7YdU8avAcHot3AV79XbCu3qlOw"
			 							  + "jUxW10mtZl7BwB840xElwHZJZpxq1awZ4EfIPOMuNbzLmydO+JocbBHdn3FZCTaK"
			 							  + "7mgFAoGBAOtmg7ez2LjPpDJWzyKJDmnXFd/bPf480ekr+bAHpgxrzmGiMi5Kt/o4"
			 							  + "Z0wcMwJuRDh1omLKKfmM7CC5SCOaZtRFGbi+mrPSTj7lakIq/FBDSBkcV7Rf/gc1"
			 							  + "JgkVxS3bjXNaNsApAW3eR+aMQ1BjSeu8xsxCW40M0iI1R6b18Fp1";

	public static String getServerPubKey() {
		return serverPubKey;
	}

	public static String getServerPrvKey() {
		return serverPrvKey;
	}

	public static String getApppubkey() {
		return appPubKey;
	}

	public static String getAppprvkey() {
		return appPrvKey;
	}

	public static String getServerPrvKeyPkcs8() {
		return serverPrvKeyPkcs8;
	}
	
}
