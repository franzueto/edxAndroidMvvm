package edu.galileo.mvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import edu.galileo.mvvm.databinding.ItemContactBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ContactModel[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemContactBinding itemContactBinding;

        public ViewHolder(ItemContactBinding itemContactBinding) {
            super(itemContactBinding.cardView);
            this.itemContactBinding = itemContactBinding;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ContactModel[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemContactBinding itemContactBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.item_contact,
            parent,
            false);

        return new ViewHolder(itemContactBinding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemContactBinding itemContactBinding = holder.itemContactBinding;
        itemContactBinding.setViewModel(new ContactViewModel(mDataset[position]));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
