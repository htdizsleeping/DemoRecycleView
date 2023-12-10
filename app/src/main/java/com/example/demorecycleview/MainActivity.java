package com.example.demorecycleview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseAdapter adapter;
    private List<Course> courseList;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseList = new ArrayList<>();

        courseList.add(new Course(" CMP354", " Lập trình di động",
                " Nguyễn Huy", R.drawable.didong));
        courseList.add(new Course(" CMP324", " Lập trình Java",
                " Nguyễn Văn A", R.drawable.java));
        courseList.add(new Course(" CMP332", " Lập trình Windows",
                " Nguyễn Văn B", R.drawable.window));

        adapter = new CourseAdapter(this, courseList);
        recyclerView.setAdapter(adapter);

        // Button initialization
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gọi hộp thoại để thêm Course mới
                addNewCourseDialog();
            }
        });
    }

    private void addNewCourseDialog() {
        // Tạo một hộp thoại AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add New Course");

        // Sử dụng LayoutInflater để tạo layout cho hộp thoại
        View view = getLayoutInflater().inflate(R.layout.dialog_add_course, null);
        builder.setView(view);

        // Khởi tạo các trường EditText trong layout
        final EditText codeEditText = view.findViewById(R.id.editTextCode);
        final EditText nameEditText = view.findViewById(R.id.editTextName);
        final EditText lecturerEditText = view.findViewById(R.id.editTextLecturer);

        // Thiết lập nút "Add" và xử lý sự kiện khi nó được nhấn
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Lấy dữ liệu từ các trường EditText
                String code = codeEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String lecturer = lecturerEditText.getText().toString();

                // Tạo một Course mới và thêm vào danh sách
                Course newCourse = new Course(code, name, lecturer,R.drawable.didong);
                courseList.add(newCourse);

                // Cập nhật Adapter
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }
}