package es.uma.ac.movinf003.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements View.OnClickListener{

    private final static String STRING_KEY = "textView_text";
    private final static String COLOR_KEY = "textView_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonRed = (Button) findViewById(R.id.button_red);
        ImageView icon = (ImageView) findViewById(R.id.image_logo_android);

        buttonRed.setOnClickListener(this);
        icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText tv = (EditText) findViewById(R.id.textView);
        switch (v.getId()) {
            case R.id.button_red:
                tv.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.image_logo_android:
                RadioGroup rgroup = (RadioGroup) findViewById(R.id.radiogroup);
                int radioButtonID = rgroup.getCheckedRadioButtonId();

                if (R.id.radiobutton_green == radioButtonID) {
                    tv.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (R.id.radiobutton_blue == radioButtonID) {
                    tv.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                break;
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText tv = (EditText) findViewById(R.id.textView);
        String text = (String) savedInstanceState.get(STRING_KEY);
        if (text != null) {
            tv.setText(text);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveStateBundle) {
        super.onSaveInstanceState(saveStateBundle);
        EditText tv = (EditText) findViewById(R.id.textView);
        saveStateBundle.putString(STRING_KEY, tv.getText().toString());
        saveStateBundle.putString(COLOR_KEY, tv.getText().toString());
    }
}
