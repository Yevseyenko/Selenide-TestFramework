package utils;


import org.apache.commons.codec.binary.StringUtils;

import java.util.Base64;

public class Utils {
    public static String getPassword(char[] pass) {
        return StringUtils.newStringUtf8(Base64.getDecoder().decode(String.valueOf(pass)));
    }
}
