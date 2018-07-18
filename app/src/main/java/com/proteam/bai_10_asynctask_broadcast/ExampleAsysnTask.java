package com.proteam.bai_10_asynctask_broadcast;

import android.os.AsyncTask;
import android.widget.TextView;

public class ExampleAsysnTask extends AsyncTask<Integer, Integer, String> {
    private TextView mTvText;
    private Test update;

    public ExampleAsysnTask(TextView tvText, Test update) {
        mTvText = tvText;
        this.update = update;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTvText.setText("onPreExecute");
    }

    @Override
    protected String doInBackground(Integer... params) {
        this.update.updateUI("test");
        for (int i = 0; i < params[0]; i++) {
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Da Hoan Thanh";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mTvText.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mTvText.setText(s);
    }
}
