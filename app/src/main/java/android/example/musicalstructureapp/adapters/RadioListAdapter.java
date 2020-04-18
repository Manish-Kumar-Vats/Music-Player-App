package android.example.musicalstructureapp.adapters;


import android.example.musicalstructureapp.R;
import android.example.musicalstructureapp.modals.RadioChannelModal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RadioListAdapter extends RecyclerView.Adapter<RadioListAdapter.MyViewHolder> {


    private List<RadioChannelModal> listOfRadioChannel;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView raioChannel,radioName;
        MyViewHolder(View view) {
            super(view);
            raioChannel = view.findViewById(R.id.radioChannelName);
            radioName = view.findViewById(R.id.radioName);
        }
    }


    public RadioListAdapter(List<RadioChannelModal> listOfRadioChannel) {
        this.listOfRadioChannel = listOfRadioChannel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_channel_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //getting the custom data of current position
        RadioChannelModal currentRadioChannel = listOfRadioChannel.get(position);
        //now here we can set the data to any views that we want..
        holder.raioChannel.setText(currentRadioChannel.getRadioChannelName());
        holder.radioName.setText(currentRadioChannel.getRadioName());

    }


    @Override
    public int getItemCount() {
        return listOfRadioChannel.size();
    }
}
