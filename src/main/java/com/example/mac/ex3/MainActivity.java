package com.example.mac.ex3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    //MyModel model = MyModel.getInstance();
    ListView listView;
    StudentArrayAdapter studentArrayAdapter;
    public class StudentArrayAdapter extends ArrayAdapter<Student>
    {
        public StudentArrayAdapter()
        {
            super(MainActivity.this,R.layout.student_cell,MyModel.getInstance().model.getStudents());
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
           // Student student = (Student)listView.getItemAtPosition(position);

            if(itemView==null)
            {
                itemView = getLayoutInflater().inflate(R.layout.student_cell,parent,false);
            }
            Student student = MyModel.getInstance().model.getStudents().get(position);
            TextView nameTextView = (TextView)itemView.findViewById(R.id.name_text_view);
            nameTextView.setText(student.getName());
            TextView idTextView = (TextView)itemView.findViewById(R.id.student_id_text_view);
            idTextView.setText(student.getId());
            CheckBox checkBox = (CheckBox)itemView.findViewById(R.id.student_check_box);
            checkBox.setChecked(student.isChecked());
            checkBox.setClickable(false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                    intent.putExtra("position",position);

                    startActivityForResult(intent, 1);

                }
            });

            return itemView;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // addStudents();
        initViews();

    }

    private void addStudents() {
        Student s1 = new Student("aviv","s","s","s",true);
        MyModel.getInstance().model.getStudents().add(s1);
    }

    private void initViews() {
        listView =(ListView)findViewById(R.id.students_list_view);
        studentArrayAdapter = new StudentArrayAdapter();
        listView.setAdapter(studentArrayAdapter);

        Button addButton = (Button)findViewById(R.id.addStudentButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(MainActivity.this,AddStudentActivity.class);
                startActivityForResult(addIntent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                boolean result=data.getBooleanExtra("result", false);
//                MyModel.getInstance().addStudent(new Student("s","s","s","s",true));
                studentArrayAdapter.notifyDataSetChanged();
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
                studentArrayAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
