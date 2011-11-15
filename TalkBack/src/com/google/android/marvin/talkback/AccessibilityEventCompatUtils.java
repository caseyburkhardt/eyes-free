/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.android.marvin.talkback;

import android.view.accessibility.AccessibilityEvent;

import java.lang.reflect.Method;

/**
 * Provides backward-compatible access to method in {@link AccessibilityEvent}.
 * 
 * @author alanv@google.com (Alan Viverette)
 */
public class AccessibilityEventCompatUtils {
    private static final Class<?> CLASS_AccessibilityEvent = AccessibilityEvent.class;
    private static final Method METHOD_getMaxScrollX = CompatUtils.getMethod(
            CLASS_AccessibilityEvent, "getMaxScrollX");
    private static final Method METHOD_getMaxScrollY = CompatUtils.getMethod(
            CLASS_AccessibilityEvent, "getMaxScrollY");

    /**
     * Gets the max scroll offset of the source left edge in pixels.
     * 
     * @return The max scroll.
     */
    public static int getMaxScrollX(AccessibilityEvent receiver) {
        return (Integer) CompatUtils.invoke(receiver, -1, METHOD_getMaxScrollX);
    }

    /**
     * Gets the max scroll offset of the source top edge in pixels.
     * 
     * @return The max scroll.
     */
    public static int getMaxScrollY(AccessibilityEvent receiver) {
        return (Integer) CompatUtils.invoke(receiver, -1, METHOD_getMaxScrollY);
    }
}
