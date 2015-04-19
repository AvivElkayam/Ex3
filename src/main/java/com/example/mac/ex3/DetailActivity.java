package com.example.mac.ex3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {
     TextView name,id,phone,address;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }

    private void initViews() {
        final Integer i = getIntent().getIntExtra("position",0);
        Student s = MyModel.getInstance().getStudents().get(i);
        name = (TextView)findViewById(R.id.detail_name_text_view);
        name.setText("Name: "+s.getName());
        id = (TextView)findViewById(R.id.detail_id_text_view);
        id.setText("ID: "+s.getId());
        phone = (TextView)findViewById(R.id.detail_phone_text_view);
        phone.setText("Phone: "+s.getPhone());
        address = (TextView)findViewById(R.id.detail_address_text_view);
        address.setText("Address: "+s.getAddress());
        checkBox = (CheckBox)findViewById(R.id.detail_check_box);
        checkBox.setChecked(s.isChecked());
        checkBox.setClickable(false);
        //checkBox.setChecked(false);
        Button edit = (Button)findViewById(R.id.detailStudentEditBTN);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(DetailActivity.this,EditActivity.class);
                editIntent.putExtra("position",i);
                startActivityForResult(editIntent, 1);
                //dan
                Log.w("s","s");
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                //true = saved , false = delete
                boolean result=data.getBooleanExtra("editResult", false);
//                MyModel.getInstance().addStudent(new Student("s","s","s","s",true));
                if(result)
                {
                    //OnCreate
                    initViews();
                }
                else {
                    Intent returnIntent = new Intent();
                    setResult(RESULT_CANCELED, returnIntent);

                    finish();
                }
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);

                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
