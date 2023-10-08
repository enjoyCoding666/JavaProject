package com.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebugLog {
    public static void main(String[] args) {
        if (log.isDebugEnabled()) {
            log.debug("debug enable.log start.");
        }
    }
}
