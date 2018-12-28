package com.apolis.lanny.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity implements OnItemSelectedListener {

    private String username,password, yesorno, gender, country, time;
    RadioGroup rgCar, rgGen;
    ArrayList<String> answersStringArray= new ArrayList<String>();
    private Spinner spinner;
    private static final String[] selectCountry = {"China", "Korean", "Japan", "Indian"};

    SharedPreferences formPreferences;
    SharedPreferences.Editor formrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_spinner_item,selectCountry);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void clickSubmit(View view) {
        formPreferences = getSharedPreferences("formPrefs", MODE_PRIVATE);
        formrefsEditor = formPreferences.edit();

//        Log.i("xxx", "come inside");

        final EditText etName = findViewById(R.id.editTextName);
        username = etName.getText().toString();
        answersStringArray.add(username);
        formrefsEditor.putString("username", username);


        final EditText etPassword = findViewById(R.id.editText2);
        password = etPassword.getText().toString();
        answersStringArray.add(password);
        formrefsEditor.putString("password", password);

        rgCar = findViewById(R.id.Owncar);
        rgGen = findViewById(R.id.Gender);

        if (rgCar.getCheckedRadioButtonId() != -1) {
            RadioButton uans = (RadioButton) findViewById(rgCar.getCheckedRadioButtonId());
            String ansCarText = uans.getText().toString();
            answersStringArray.add(ansCarText);
            formrefsEditor.putString("carOrNot", ansCarText);
        }

        if (rgGen.getCheckedRadioButtonId() != -1) {
            RadioButton uan = (RadioButton) findViewById(rgGen.getCheckedRadioButtonId());
            String ansGenText = uan.getText().toString();
            answersStringArray.add(ansGenText);
            formrefsEditor.putString("Gender", ansGenText);
        }

        Spinner spinner2 = findViewById(R.id.spinner);
        country = spinner2.getSelectedItem().toString();
        answersStringArray.add(country);
        formrefsEditor.putString("country", country);
        Log.i("xxx", country);

        TimePicker timePicker = findViewById(R.id.simpleTimePicker);
        time = timePicker.getCurrentHour().toString() + ":" +timePicker.getCurrentMinute().toString();
        Log.i("xxx", time);
        answersStringArray.add(time);
        formrefsEditor.putString("time", time);

        String res = answersStringArray.get(4);
        Log.i("xxx", res);
        myInterface(answersStringArray);

        formrefsEditor.commit();
    }

    public void myInterface(ArrayList<String> arr) {

        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        //bundle.putString("key", name);
        bundle.putStringArrayList("arrayList", arr);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.form, fragment).addToBackStack(null).commit();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
