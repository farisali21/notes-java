package android.withme.notesdemo.presistence;

import android.content.Context;
import android.withme.notesdemo.models.Note;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static final String DATA_BASE_NAME = "notes_dp";

    private static NoteDatabase instance;

    static NoteDatabase getInstance(final Context context){
      if (instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NoteDatabase.class,
                    DATA_BASE_NAME
            ).build();
      }
      return instance;
    }

    public abstract NoteDeo getNoteDeo();

}
