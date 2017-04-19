package edu.galileo.mvvm;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

    private ContactModel[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextview;
        public TextView phoneTextView;
        public Button callButton;

        public ViewHolder(View v) {
            super(v);
            this.nameTextview = (TextView) v.findViewById(R.id.name_text);
            this.phoneTextView = (TextView) v.findViewById(R.id.phone_text);
            this.callButton = (Button) v.findViewById(R.id.call_button);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ContactModel[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextview.setText(mDataset[position].name);
        holder.phoneTextView.setText(mDataset[position].phoneNumber);
        if (mDataset[position].enabled) {
            holder.callButton.setOnClickListener(this);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onClick(View v) {
        Log.d("RecyclerView", "CLICK!");
    }
}
