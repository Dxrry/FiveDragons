/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Utils;

/**
 *
 * @author dxrry
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String calculateMD5(String input) {
        try {
            // Create MD5 hash instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calculate MD5 hash
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array to signum representation
            BigInteger signum = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hash = signum.toString(16);

            // Add leading zeros to make it a 32-bit hash
            while (hash.length() < 32) {
                hash = "0" + hash;
            }

            return hash;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
