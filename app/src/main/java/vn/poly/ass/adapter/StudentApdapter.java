package vn.poly.ass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.poly.ass.R;
import vn.poly.ass.model.Student;

public class StudentApdapter extends BaseAdapter {
    Context context;
    List<Student> students;
    public StudentApdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }
    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView ==null){
            Student student= (Student) getItem(position);

            convertView = LayoutInflater.from(context).inflate(R.layout.studentrow, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvStt=convertView.findViewById(R.id.tvStt);
            viewHolder.tvName=convertView.findViewById(R.id.tvName);
            viewHolder.tvBirthday=convertView.findViewById(R.id.tvBirthday);

            viewHolder.tvStt.setText((position+1)+"");
            viewHolder.tvName.setText(student.getName());
            viewHolder.tvBirthday.setText(student.getBirthday());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    private static class ViewHolder{
        public static TextView tvStt,tvName,tvBirthday;
    }

}

