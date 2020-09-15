package vn.poly.ass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.poly.ass.R;
import vn.poly.ass.model.Class;

public class ClassAdpater extends BaseAdapter {
    Context context;
    List<Class> classes;
public ClassAdpater(Context context, List<Class>classes){
this.context=context;
this.classes=classes;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder viewHolder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent,false);

            viewHolder = new viewHolder();
            viewHolder.tvStt = convertView.findViewById(R.id.tvStt);
            viewHolder.tvId = convertView.findViewById(R.id.tvId);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);

            Class aClass = (Class) getItem(position);
            viewHolder.tvStt.setText((position+1)+"");
            viewHolder.tvId.setText(aClass.getId());
            viewHolder.tvName.setText(aClass.getName());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ClassAdpater.viewHolder) convertView.getTag();
        }
        return convertView;
    }

    private static class viewHolder{
        TextView tvStt,tvId,tvName;
    }
}



