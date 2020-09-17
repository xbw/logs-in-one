/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2010 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xbw.log.jboss.logging;

import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.jboss.logging.Logger;
import org.jboss.logging.LoggerProvider;

import java.util.Map;

public final class CustomLoggerProvider implements LoggerProvider {

    private final ThreadLocal<Map<String, Object>> mdcMap = new ThreadLocal<Map<String, Object>>();

    @Override
    public Logger getLogger(final String name) {
        return new CustomLogger("".equals(name) ? "ROOT" : name);
    }

    @Override
    public void clearMdc() {
        final Map<String, Object> map = mdcMap.get();
        if (map != null) {
            map.clear();
        }
    }

    @Override
    public Object putMdc(String key, Object value) {
        return null;
    }

    @Override
    public Object getMdc(String key) {
        return null;
    }


    @Override
    public void removeMdc(String key) {
        MDC.remove(key);
    }

    @Override
    public Map<String, Object> getMdcMap() {
        return null;
    }

    @Override
    public void clearNdc() {
        org.apache.log4j.NDC.remove();
    }

    @Override
    public String getNdc() {
        return org.apache.log4j.NDC.get();
    }

    @Override
    public int getNdcDepth() {
        return org.apache.log4j.NDC.getDepth();
    }

    @Override
    public String peekNdc() {
        return org.apache.log4j.NDC.peek();
    }

    @Override
    public String popNdc() {
        return org.apache.log4j.NDC.pop();
    }

    @Override
    public void pushNdc(String message) {
        org.apache.log4j.NDC.push(message);
    }

    @Override
    public void setNdcMaxDepth(int maxDepth) {
        NDC.setMaxDepth(maxDepth);
    }
}
