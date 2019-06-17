package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> textViewWeakReference;

    public MyAsyncTask(TextView t) {
        textViewWeakReference=new WeakReference<>(t);
    }


    @Override
    protected String doInBackground(Void... voids) {


        Random random=new Random();
        int r=random.nextInt(11);
        int s=r*200;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textViewWeakReference.get().setText(s);
    }
}
