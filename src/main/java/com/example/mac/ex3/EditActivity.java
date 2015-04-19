package com.example.mac.ex3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class EditActivity extends ActionBarActivity {
        Integer position;
    EditText name;
    EditText id;
    EditText phone;
    EditText address;
    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        position = getIntent().getIntExtra("position",0);
        Button save = (Button)findViewById(R.id.editStudentSaveBTN);
        initViews();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudent();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("editResult", true);


                setResult(RESULT_OK,returnIntent);

                finish();
            }




        });
        Button cancel = (Button)findViewById(R.id.editStudentCancelBTN);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });
        Button delete = (Button)findViewById(R.id.editStudentDeleteBTN);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyModel.getInstance().model.deleteStudent(position);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("editResult", false);


                setResult(RESULT_OK,returnIntent);

                finish();
            }
        });

    }

    private void initViews() {
       name = (EditText)findViewById(R.id.editStudentNameText);
        id = (EditText)findViewById(R.id.editStudentIdText);
       phone = (EditText)findViewById(R.id.editStudentPhoneText);
      address = (EditText)findViewById(R.id.editStudentAddressText);
        check = (CheckBox)findViewById(R.id.editStudentCheckBox);
        Student s = MyModel.getInstance().model.getStudents().get(position);
        name.setText(s.getName());
        id.setText(s.getId());
        phone.setText(s.getPhone());
        address.setText(s.getAddress());
        check.setChecked(s.isChecked());

    }

    private void saveStudent() {

        MyModel.getInstance().model.editStudent(position,new Student(name.getText().toString(),id.getText().toString(),address.getText().toString(),phone.getText().toString(),check.isChecked()));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
