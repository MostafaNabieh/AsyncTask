package com.example.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView1);
        if(savedInstanceState != null)
        {
            textView.setText(savedInstanceState.getString("Current_State"));
        }

    }


    public void startTask(View view) {
        textView.setText("ready to start");
        new MyAsyncTask(textView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Current_State",textView.getText().toString());
    }
}
