package org.competetive.programming.Leetcode;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Solution535 {

    Map<String, String> urlMapping = new HashMap<>();

    public static void main(String[] args) {

    }

    public String encode(String longUrl) {

        String encodedUrl = Base64.getEncoder().encodeToString(longUrl.getBytes());
        urlMapping.put(encodedUrl, longUrl);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return urlMapping.get(shortUrl);
    }
}
