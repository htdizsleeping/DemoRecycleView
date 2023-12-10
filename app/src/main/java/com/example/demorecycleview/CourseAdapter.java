package com.example.demorecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private Context context;
    private List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.courseCode.setText(course.getCourseCode());
        holder.courseName.setText(course.getCourseName());
        holder.lecturerName.setText(course.getLecturerCode());
        holder.courseImage.setImageResource(course.getCourseImage());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView courseCode;
        TextView courseName;
        TextView lecturerName;
        ImageView courseImage;

        public CourseViewHolder(View itemView) {
            super(itemView);
            courseCode = itemView.findViewById(R.id.course_code);
            courseName = itemView.findViewById(R.id.course_name);
            lecturerName = itemView.findViewById(R.id.lecturer_name);
            courseImage = itemView.findViewById(R.id.course_image);
        }
    }
}
