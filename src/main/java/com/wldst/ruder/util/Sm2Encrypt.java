package com.wldst.ruder.util;

public class Sm2Encrypt {

//    private static final Logger logger = LoggerFactory.getLogger(Sm2Encrypt.class);
//
//
//
//
//    // 测试密钥对
//    private static String prvKeyHex = "7E94B2BE308639054B1714A758C27B6955CA702A70D906D603EA145AC0A2F079";
//    private static String pubKeyHex = "040ECAE82EA6BDC5FF6C90E6D8700F4F9BD44224E8F7F7576FA9B17CE823C18DD5C1D4F9CBF4EE23B3D3347C589036EE13E9497607D0F6C7B5CC655D0D250EDCE8";
//
//    private static byte[] prvKeyBytes = ByteUtils.hexToBytes(prvKeyHex);
//    private static byte[] pubKeyBytes = ByteUtils.hexToBytes(pubKeyHex);
//
//    public static void main(String[] args) {
//	Sm2Encrypt test = new Sm2Encrypt();
//	// test.testData();
//	String encript132Text = test.encript132Text("测试加密数据");
//    }
//
//    public static void deCript(String sourceData) {
//	try {
//	    logger.info("----------------SM2(字符串模式)场景描述:采用16进制公私钥对，对字符串形式的明文进行加密解密（字符串密文拼接方式）----------------");
//	    Sm2Utils sm2Utils = new Sm2Utils(CipherMode.C1C2C3);
//
//	    logger.info("C1C2C3加密:" + sourceData);
//	    String plantText = sm2Utils.decryptToText(prvKeyHex, sourceData);
//	    logger.info("C1C2C3解密:" + plantText);
//	    // 断言相等
//	    logger.info("--------------------------------\n");
//	} catch (InvalidCryptoDataException e) {
//	    logger.warning("SM2加密解密InvalidCryptoDataException异常");
//	} catch (InvalidKeyException e) {
//	    logger.warning("SM2加密解密InvalidKeyException异常");
//	}
//    }
//
//    public static String encriptText(String sourceData) {
//	String sourceText = sourceData;
//	try {
//	    logger.info("----------------SM2(字符串模式)场景描述:采用16进制公私钥对，对字符串形式的明文进行加密解密（字符串密文拼接方式）----------------");
//	    logger.info("私钥:" + prvKeyHex);
//	    logger.info("公钥:" + pubKeyHex);
//	    logger.info("明文:" + sourceText);
//	    Sm2Utils sm2Utils = new Sm2Utils(CipherMode.C1C2C3);
//	    String cipherHex = sm2Utils.encryptFromText(pubKeyHex, sourceText);
//	    return cipherHex;
//	} catch (InvalidKeyException e) {
//	    logger.warning("SM2加密解密InvalidKeyException异常");
//	} catch (InvalidSourceDataException e) {
//	    logger.warning("SM2加密解密InvalidSourceDataException异常");
//	}
//	return sourceData;
//    }
//
//    public static void decript132(String sourceData) {
//	try {
//	    logger.info("----------------SM2(字符串模式)场景描述:采用16进制公私钥对，对字符串形式的明文进行加密解密（字符串密文拼接方式）----------------");
//	    Sm2Utils sm2Utils = new Sm2Utils(CipherMode.C1C3C2);
//
//	    logger.info("C1C3C2加密:" + sourceData);
//	    String plantText = sm2Utils.decryptToText(prvKeyHex, sourceData);
//	    logger.info("C1C3C2解密:" + plantText);
//	    // 断言相等
//	    logger.info("--------------------------------\n");
//	} catch (InvalidCryptoDataException e) {
//	    logger.warning("SM2加密解密InvalidCryptoDataException异常");
//	} catch (InvalidKeyException e) {
//	    logger.warning("SM2加密解密InvalidKeyException异常");
//	}
//    }
//
//    public static String encript132Text(String sourceData) {
//	String sourceText = sourceData;
//	try {
//	    logger.info("----------------SM2(字符串模式)场景描述:采用16进制公私钥对，对字符串形式的明文进行加密解密（字符串密文拼接方式）----------------");
//	    logger.info("明文:" + sourceText);
//	    Sm2Utils sm2Utils = new Sm2Utils(CipherMode.C1C3C2);
//	    String cipherHex = sm2Utils.encryptFromText(pubKeyHex, sourceText);
//	    return cipherHex;
//	} catch (InvalidKeyException e) {
//	    logger.warning("SM2加密解密InvalidKeyException异常");
//	} catch (InvalidSourceDataException e) {
//	    logger.warning("SM2加密解密InvalidSourceDataException异常");
//	}
//	return sourceData;
//    }
}
