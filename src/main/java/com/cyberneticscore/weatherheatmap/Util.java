package com.cyberneticscore.weatherheatmap;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by saikek on 25.9.16.
 */
public class Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
    static void PrintDebugInfo(Object obj) {
        LOGGER.info(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));
    }
}
