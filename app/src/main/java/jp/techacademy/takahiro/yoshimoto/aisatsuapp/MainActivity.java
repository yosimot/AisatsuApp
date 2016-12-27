package jp.techacademy.takahiro.yoshimoto.aisatsuapp;

import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.util.Log;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int hour;
    int min; //条件分岐の時にきちんと呼び出せるように、外で宣言する

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
    }


    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour = hourOfDay;
                        min = minute;
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                hour,
                min,
                true);
        timePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button2) {
            if(2 <= hour && hour < 10){
                mTextView.setText("おはよう");
            }else if(10 <= hour && hour < 18){
                mTextView.setText("こんにちは");
            }else if(18 <= hour && hour <= 23 || 0 <= hour && hour <2){
                mTextView.setText("こんばんは");
            }
        }
    }
}