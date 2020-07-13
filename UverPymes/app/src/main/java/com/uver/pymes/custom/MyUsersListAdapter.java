package com.uver.pymes.custom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uver.pymes.R;
import com.uver.pymes.object.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class MyUsersListAdapter extends BaseAdapter implements Filterable {

    private final String LOGGER = "MyUsersListAdapter";

    private Context context;
    private List<UserResponse> userList;
    private LayoutInflater inflater;
    private List<UserResponse> mFilterList;
    private ValueFilter mFilter;

    public MyUsersListAdapter(Context context, List<UserResponse> userList){
        this.context = context;
        this.mFilterList = userList;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if( view == null){
            view = inflater.inflate(R.layout.my_users_content, null);
        }

        TextView name = (TextView) view.findViewById(R.id.my_users_lv_tv_name);
        TextView detail1 = (TextView) view.findViewById(R.id.my_users_lv_tv_detail_1);
        TextView detail2 = (TextView) view.findViewById(R.id.my_users_lv_tv_detail_2);
        ImageView imageView = (ImageView) view.findViewById(R.id.my_users_lv_iv);

        name.setText(userList.get(i).getUserFullName());
        detail1.setText(userList.get(i).getPosition());
        detail2.setText(userList.get(i).getPositionTier());
        if( !userList.get(i).getUserImg().isEmpty()){
            Picasso.with(context).load(userList.get(i).getUserImg()).into(imageView);
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        if(mFilter == null){
            mFilter = new ValueFilter();
        }
        return mFilter;
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            Log.d(LOGGER, "CharSequencue: " + charSequence);
            if(charSequence!= null && charSequence.length() > 0){
                Log.d(LOGGER, "Searching: " + charSequence);
                ArrayList<UserResponse> filterList = new ArrayList<>();
                UserResponse filterObject;
                for(int i = 0; i< mFilterList.size(); i++){
                    if(mFilterList.get(i).getUserFullName().toUpperCase().contains(charSequence.toString().toUpperCase())){
                        filterObject = mFilterList.get(i);
                        filterList.add(
                                new UserResponse(
                                        filterObject.getId(),
                                        filterObject.getUserFullName(),
                                        filterObject.getUserImg(),
                                        filterObject.getPosition(),
                                        filterObject.getPositionTier()
                                )
                        );
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else{
                Log.d(LOGGER, "Without text");
                results.count = mFilterList.size();
                results.values = mFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            userList = (ArrayList<UserResponse>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
