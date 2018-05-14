package util;

public class ByteUtil {


    public static boolean compareByteArrays(byte[] bytes1, byte[] bytes2) {

        // Check if they are the same lengths first
        if (bytes1.length == bytes2.length) {

            // Iterate each byte in each array and check if they are not similar
            // Average & Worst = O(n)
            for (int i = 0; i < bytes1.length; i++) {

                if (bytes1[i] != bytes2[i])
                    return false;

            }

            return true;

        } else
            return false;

    }

}
