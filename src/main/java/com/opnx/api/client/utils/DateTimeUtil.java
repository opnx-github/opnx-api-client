package com.opnx.api.client.utils;


import com.opnx.api.client.constant.OpnxApiConstants;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getFormatTimestamp() {
        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern(OpnxApiConstants.TIMESTAMP_FORMAT);
        return LocalDateTime.now(ZoneId.of(OpnxApiConstants.UTC)).format(dataTimeFormatter);
    }
}
