package vn.poly.ass.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.List;

import vn.poly.ass.R;
import vn.poly.ass.model.Class;

public class SpinnerAdapterStudent implements SpinnerAdapter {
    Context context;
    List<Class> classes;
    boolean first = true;
    public SpinnerAdapterStudent(Context context, List<Class> classes) {
        this.context=context;
        this.classes = classes;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
convertView=LayoutInflater.from(context).inflate(R.layout.student_spinner_item,parent,false);
TextView tvItem=convertView.findViewById(R.id.tvItem);

return convertView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return classes.size();
    }

    @Override
    public Object getItem(int position) {
        return classes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.student_spinner_item, parent, false);
        convertView.findViewById(R.id.imgClass).setVisibility(View.GONE);
        TextView tvItem = convertView.findViewById(R.id.tvItem);
        tvItem.setBackgroundColor(Color.parseColor("#FF8BC34A"));

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
