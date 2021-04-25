package android.withme.notesdemo.async;

import android.os.AsyncTask;
import android.util.Log;
import android.withme.notesdemo.models.Note;
import android.withme.notesdemo.presistence.NoteDeo;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

    private static final String TAG = "InsertAsyncTask";

    private NoteDeo mNoteDeo;
    public UpdateAsyncTask(NoteDeo deo) {
        mNoteDeo = deo;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());
        mNoteDeo.update(notes);
        return null;
    }
}
