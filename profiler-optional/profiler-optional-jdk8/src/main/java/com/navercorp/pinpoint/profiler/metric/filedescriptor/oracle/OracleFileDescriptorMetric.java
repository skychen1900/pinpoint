/*
 * Copyright 2020 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.profiler.metric.filedescriptor.oracle;

import com.navercorp.pinpoint.profiler.monitor.metric.filedescriptor.FileDescriptorMetric;
import com.navercorp.pinpoint.profiler.monitor.metric.filedescriptor.FileDescriptorMetricSnapshot;

import java.lang.management.ManagementFactory;

/**
 * @author Roy Kim
 */
public class OracleFileDescriptorMetric implements FileDescriptorMetric {

    private final com.sun.management.UnixOperatingSystemMXBean unixOperatingSystemMXBean;

    public OracleFileDescriptorMetric() {
        this.unixOperatingSystemMXBean = (com.sun.management.UnixOperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    @Override
    public FileDescriptorMetricSnapshot getSnapshot() {

        long openFileDescriptorCount = unixOperatingSystemMXBean.getOpenFileDescriptorCount();
        return new FileDescriptorMetricSnapshot(openFileDescriptorCount);
    }

    @Override
    public String toString() {
        return "FileDescriptorMetric for Oracle Java 1.5+";
    }
}
