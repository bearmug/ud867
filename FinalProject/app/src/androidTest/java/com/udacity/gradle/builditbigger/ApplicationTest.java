package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testVerifyEchoResponse() {
        assertEquals("hello", "hello");
    }

    public void testAsyncTask() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicReference<String> res = new AtomicReference<>();

        new JokeAsyncTask() {

            @Override
            protected String doInBackground(Pair<Context, String>... params) {
                String result = super.doInBackground(params);
                res.set(result);
                latch.countDown();
                return result;
            }

        }.doInBackground(new Pair<Context, String>(new MockContext(), "nothing"));
        latch.await(10, TimeUnit.SECONDS);

        assertEquals("Long hours - green mouse", res.get());
    }
}