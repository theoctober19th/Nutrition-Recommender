package com.ersathi.nutritionrecommender.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ersathi.nutritionrecommender.R;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private Context mContext;
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;

    public MedicineAdapter(Context mContext, SQLiteDatabase database) {
        this.mContext = mContext;
        this.mDatabase = database;
        mCursor = getMedicineList();
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.medicine_reminder_itemview, viewGroup, false);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder medicineViewHolder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex("name"));
        String time = mCursor.getString(mCursor.getColumnIndex("timesInADay"));
        int id = mCursor.getInt(mCursor.getColumnIndex("id"));
        medicineViewHolder.bind(name, time, id, i);
    }

    private Cursor getMedicineList(){
        return mDatabase.rawQuery(
                "SELECT * FROM medicines;",
                null
        );
    }

    private void deleteMedicine(int id, int position){
        mDatabase.execSQL("DELETE FROM medicines WHERE id = " + String.valueOf(id));
        Toast.makeText(mContext, "DELETE PRESSED", Toast.LENGTH_SHORT).show();
        this.notifyDataSetChanged();
    }

    private void editMedicine(int id) {
        //TODO SEND TO MEDICINE FORM
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder{

        TextView medicineNameTextView;
        TextView medicineTimeTextView;
        ImageButton editImageButton;
        ImageButton deleteImageButton;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);

            medicineNameTextView = itemView.findViewById(R.id.medicine_name);
            medicineTimeTextView = itemView.findViewById(R.id.medicine_intake_time);
            editImageButton = itemView.findViewById(R.id.edit_button);
            deleteImageButton = itemView.findViewById(R.id.delete_button);
        }

        public void bind(String name, String time, final int id, final int  position){
            medicineTimeTextView.setText(time);
            medicineNameTextView.setText(name);

            editImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editMedicine(id);
                }
            });

            deleteImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteMedicine(id, position);
                }
            });
        }
    }


}
