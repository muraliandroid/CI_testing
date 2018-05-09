package murali.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import murali.myapplication.rest_api_work.TaskListener;

/**
 * Created by shyleenrodrigues on 2/6/18.
 */

public class SampleAsync extends AsyncTask<Void, Void, Void> {

    TaskListener taskListener;

    public SampleAsync(TaskListener taskListener) {
        this.taskListener = taskListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        taskListener.taskStarted();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        taskListener.taskCompleted();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        taskListener.taskInBackground();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
        Log.d("async", "cancelled parameter");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d("async", "cancelled");
    }
}