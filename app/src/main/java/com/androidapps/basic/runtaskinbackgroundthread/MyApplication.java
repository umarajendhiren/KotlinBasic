package com.androidapps.basic.runtaskinbackgroundthread;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApplication extends Application {

    ExecutorService executorService = Executors.newFixedThreadPool(4);
}
