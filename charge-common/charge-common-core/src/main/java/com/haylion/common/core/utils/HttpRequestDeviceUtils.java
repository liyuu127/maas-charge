package com.haylion.common.core.utils;

import nl.basjes.parse.useragent.AgentField;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyu
 * date 2022/11/24 15:54
 * description
 */
public class HttpRequestDeviceUtils {

    private static final String USER_AGENT_HEADER = "User-Agent";

    public enum Device {
        MOBILE,
        PC,
        UNKNOWN
    }


    public static Device parseDevice(HttpServletRequest request) {
        String userAgent = request.getHeader(USER_AGENT_HEADER);
        if (userAgent == null || userAgent.equals("")) {
            return Device.UNKNOWN;
        }

        return parseDeviceFromAgent(userAgent);

    }

    private static Device parseDeviceFromAgent(String userAgent) {
        UserAgentAnalyzer uaa = UserAgentAnalyzer
                .newBuilder()
                .hideMatcherLoadStats()
                .withCache(1000)
                .build();
        UserAgent.ImmutableUserAgent agent = uaa.parse(userAgent);
        String deviceClass = agent.get("OperatingSystemClass").getValue();
        if (deviceClass.equals("Mobile")) {
            return Device.MOBILE;
        } else if (deviceClass.equals("Desktop")) {
            return Device.PC;
        }
        return Device.UNKNOWN;
    }

    public static void main(String[] args) {
        Device device = parseDeviceFromAgent("Mozilla/5.0 (Linux; Android 7.0; Nexus 6 Build/NBD90Z) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.124 Mobile Safari/537.36");

    }
}
