package android.withme.notesdemo.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.withme.notesdemo.R;
import android.withme.notesdemo.models.Note;
import android.withme.notesdemo.util.Utility;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {

    private static final String TAG = "NotesRecyclerAdapter";
    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener mOnNoteListener;

    public NotesRecyclerAdapter(ArrayList<Note> mNotes, OnNoteListener onNoteListener) {
        this.mNotes = mNotes;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item, parent, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            String month = mNotes.get(position).getTimestamp().substring(0,2);
            month = Utility.getMonthFromNumber(month);
            String year = mNotes.get(position).getTimestamp().substring(3);
            String timestamp = month + " " + year;
            holder.title.setText(mNotes.get(position).getTitle());
            holder.timestamp.setText(timestamp);

        }catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: NullPointerException" + e.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title, timestamp;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.noteTimestamp);
            itemView.setOnClickListener(this);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
