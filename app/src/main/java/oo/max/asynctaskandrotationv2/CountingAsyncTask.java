package oo.max.asynctaskandrotationv2;

import android.os.AsyncTask;
import android.util.Log;

public class CountingAsyncTask extends AsyncTask<Void, Integer, Void> {

    private final CountingListener countingListener;

    public CountingAsyncTask(CountingListener countingListener) {
        this.countingListener = countingListener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for(int i=0;i<100;i++) {
                Log.e("CountingAsyncTask", "Counting: "+i);
                publishProgress(i);
                Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        countingListener.onProgress(values[0]);
    }

    public interface CountingListener {
        void onProgress(int value);
    }
}
