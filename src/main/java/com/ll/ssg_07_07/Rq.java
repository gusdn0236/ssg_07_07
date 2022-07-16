package com.ll.ssg_07_07;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    String queryStr;
    String path;

    Map<String, String> queryParams;

    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        queryParams = new HashMap<>();

        if (urlBits.length == 2) {
            queryStr = urlBits[1];

            String[] bits = queryStr.split("&");

            for (String urlBit : bits) {
                String[] paramNameAndValue = urlBit.split("=", 2);
                String paramName_ = paramNameAndValue[0];
                String paramValue = paramNameAndValue[1];

                if (paramNameAndValue.length == 1) {
                    continue;
                }

                queryParams.put(paramName_, paramValue);

            }
        }
    }

    public int getIntParam(String paramName, int defaultValue) {
        if (queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }

        String paramValue = queryParams.get(paramName);

        if (paramValue.length() == 0) {
            return defaultValue;
        }

        return Integer.parseInt(paramValue);
    }

    public String getPath() {
        return path;
    }
}




