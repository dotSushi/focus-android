/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static final ExecutorService backgroundExecutorService = Executors.newSingleThreadExecutor();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void postToBackgroundThread(final Runnable runnable) {
        backgroundExecutorService.submit(runnable);
    }

    public static void postToMainThreadDelayed(final Runnable runnable, long delayMillis) {
        handler.postDelayed(runnable, delayMillis);
    }
}
