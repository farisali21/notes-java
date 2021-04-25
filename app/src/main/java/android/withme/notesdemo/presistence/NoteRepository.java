package android.withme.notesdemo.presistence;

import android.content.Context;
import android.withme.notesdemo.async.DeleteAsyncTask;
import android.withme.notesdemo.async.InsertAsyncTask;
import android.withme.notesdemo.async.UpdateAsyncTask;
import android.withme.notesdemo.models.Note;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNote(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDeo()).execute(note);

    }

    public void updateNote(Note note){
        new UpdateAsyncTask(mNoteDatabase.getNoteDeo()).execute(note);
    }

    public LiveData<List<Note>> retrieveNote(){
        return mNoteDatabase.getNoteDeo().getNotes();
    }

    public void deleteNote(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDeo()).execute(note);
    }
}
