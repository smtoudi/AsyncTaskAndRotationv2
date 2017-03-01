package oo.max.asynctaskandrotationv2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class MainFragment extends Fragment implements CountingAsyncTask.CountingListener {

    private SeekBar seekBar;
    private boolean asyncTaskStarted = false;
    private CountingAsyncTask countingAsyncTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Fragment: " + this, "onCreate");
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.e("Fragment: " + this, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        seekBar = (SeekBar) view.findViewById(R.id.seekbar);

        if(!asyncTaskStarted) {
            countingAsyncTask = new CountingAsyncTask(this);
            countingAsyncTask.execute();
            asyncTaskStarted = true;
        }

        return view;
    }

    @Override
    public void onProgress(int value) {
        if (seekBar != null) {
            seekBar.setProgress(value);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(countingAsyncTask != null) {
            countingAsyncTask.cancel(true);
        }
    }
}
