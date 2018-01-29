package com.pdp.interop.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class CommonUtil {

    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * @param originalList
     * @param toAppendUrl
     * @return
     */
    public static String addCallbackUrl(String originalList, String toAppendUrl) {
        if (originalList != null && originalList.length() > 0) {
            return originalList + ";" + toAppendUrl;
        } else {
            return toAppendUrl;
        }
    }

    /**
     * @param callbackUrlList
     * @return
     */
    public static String getLatestCallbackUrl(String callbackUrlList) {
        if (callbackUrlList.indexOf(';') != -1) {
            return callbackUrlList.substring(callbackUrlList.indexOf(';') + 1);
        } else {
            return callbackUrlList;
        }
    }

    public static String getCallbackUrlAtPosition(String callbackUrlList, int position) {
        if (callbackUrlList.indexOf(';') != -1) {
            return callbackUrlList.split(";")[position - 1];
        } else {
            return callbackUrlList;
        }
    }

    public static String removeLastEntry(String callbackUrlList) {
        log.info("CallbackUrlList: {}",callbackUrlList);
        if (callbackUrlList.indexOf(';') != -1) {
            return callbackUrlList.substring(0, callbackUrlList.lastIndexOf(";"));
        } else {
            return callbackUrlList;
        }
    }

    public static String getAccountIdFromUrl(String accountUrl) {
        log.info("Account Url: {}", accountUrl);
        if (accountUrl.indexOf("/") != -1)
            return accountUrl.substring(accountUrl.lastIndexOf("/") + 1);
        else
            return accountUrl;
    }
}
