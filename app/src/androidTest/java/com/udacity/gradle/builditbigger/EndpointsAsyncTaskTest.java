package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

public class EndpointsAsyncTaskTest extends AndroidTestCase {

    Exception mError = null;
    CountDownLatch signal = null;

    @Override
    protected void setUp() {
        signal = new CountDownLatch(1);
    }

    public void testVerifyAsyncTask() throws InterruptedException {

        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    // A non empty string represents a joke
                    assertTrue(result.length() > 0);
                    signal.countDown();
                }
            }
        };

        testTask.execute();
        signal.await();

        assertNull(mError);
    }

}