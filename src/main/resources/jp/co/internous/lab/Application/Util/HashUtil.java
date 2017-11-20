package jp.co.internous.lab.Application.Util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class HashUtil {

    //ハッシュ生成前にバイト配列に置き換える際のCharset
    private static Charset charset = StandardCharsets.UTF_8;

    //ハッシュアルゴリズム
    private static String algorithm = "SHA-512";

    // ハッシュ格納
    private static byte[] bytes;

    public static String createHash(String value) throws NoSuchAlgorithmException {
    //ハッシュ生成処理
    bytes = MessageDigest.getInstance(algorithm).digest(value.getBytes(charset));
    System.out.println(DatatypeConverter.printHexBinary(bytes));
    return DatatypeConverter.printHexBinary(bytes);
    }
}
