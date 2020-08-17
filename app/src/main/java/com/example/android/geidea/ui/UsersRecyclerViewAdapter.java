package com.example.android.geidea.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.geidea.R;
import com.example.android.geidea.model.Data;

import java.util.List;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private static final int ITEM_VIEW_TYPE_LOADING = 0;
    private static final int ITEM_VIEW_TYPE_EMPTY_LIST = 1;
    private static final int ITEM_VIEW_TYPE_DATA = 2;

    private List<Data> dataList;

    public UsersRecyclerViewAdapter(Context context,List<Data> dataList){

        this.context=context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case ITEM_VIEW_TYPE_LOADING:{

                final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading_list,parent,false);
                viewHolder=new LoadingViewHolder(view);
                break;
            }
            case ITEM_VIEW_TYPE_EMPTY_LIST:{
                final View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_list,parent,false);
                viewHolder=new EmptyViewHolder(view);
                break;
            }
            case ITEM_VIEW_TYPE_DATA:{
                final View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_users_list,parent,false);
                viewHolder=new DataViewHolder(view);
                break;
            }
            default:{
                viewHolder=null;
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (dataList==null){
            bindLoadingViewHolder(holder);
        }else if (dataList.isEmpty()){
            bindEmptyViewHolder(holder);

        }else {

            bindDataViewHolder(holder,position);
        }

    }

    private void bindLoadingViewHolder(RecyclerView.ViewHolder viewHolder){

        LoadingViewHolder loadingViewHolder = (LoadingViewHolder)viewHolder;

    }
    private void bindEmptyViewHolder(RecyclerView.ViewHolder viewHolder){

        EmptyViewHolder emptyViewHolder = (EmptyViewHolder) viewHolder;
        emptyViewHolder.setUpData("Empty List");
    }

    private void bindDataViewHolder(RecyclerView.ViewHolder viewHolder,int position){
        DataViewHolder dataViewHolder = (DataViewHolder) viewHolder;
        dataViewHolder.updateViews(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        int count = 0;

        if (dataList == null) {
            count = 1;
        } else if (dataList.isEmpty()) {
            count = 1;
        } else {
            count = dataList.size();
        }
        return count;
    }


    public int getItemViewType(int position){

        int itemViewType = -1;

        if (dataList == null) {
            itemViewType = ITEM_VIEW_TYPE_LOADING;
        } else if (dataList.isEmpty()) {
            itemViewType = ITEM_VIEW_TYPE_EMPTY_LIST;
        } else {
            itemViewType = ITEM_VIEW_TYPE_DATA;
        }
        return itemViewType;
    }


    public void updateDataSource(List<Data> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }


    public class LoadingViewHolder extends RecyclerView.ViewHolder{

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }

        public void setUpData(String txt){
            textView.setText(txt);
        }

    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView idTextview;
        private TextView firstNameTextview;
        private TextView lastNameTextview;
        private View mainView;
        private Data data;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextview = (TextView) itemView.findViewById(R.id.idTextview);
            firstNameTextview = (TextView) itemView.findViewById(R.id.fnTextview);
            lastNameTextview = (TextView) itemView.findViewById(R.id.lnTextview);
            mainView = itemView.findViewById(R.id.mainView);
            mainView.setOnClickListener(this);
        }

        public void updateViews(Data data){

            this.data = data;
            idTextview.setText("Id: "+data.getId());
            firstNameTextview.setText(data.getFirstName()+" "+data.getLastName());
            lastNameTextview.setText(data.getEmail());
        }

        @Override
        public void onClick(View v) {

            Bundle bundle = new Bundle();
            bundle.putLong("id",data.getId());
            Intent intent = new Intent(context,UserDetailsActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);

        }
    }

}
