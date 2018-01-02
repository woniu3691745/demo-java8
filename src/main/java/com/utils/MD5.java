package com.utils;

import org.springframework.util.DigestUtils;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 16:51
 */
public class MD5 {
    /**
     * 使用spring工具类生成md5
     * @param password
     * @return md5
     */
    String Md5Value(long password) {
        String slat = "112233445566";
        String base = password + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}