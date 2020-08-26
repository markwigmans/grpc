package com.capgemini.perf.lib.util;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class EurekaUtil {

    public static InstanceInfo waitForRegistrationWithEureka(EurekaClient eurekaClient, String serverId) {
        InstanceInfo nextServerInfo = null;
        while (nextServerInfo == null) {
            try {
                nextServerInfo = eurekaClient.getNextServerFromEureka(serverId, false);
            } catch (Throwable e) {
                log.info("Waiting ... verifying service registration with eureka ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    log.info("Interupted",e1);
                }
            }
        }
        return nextServerInfo;
    }
}
