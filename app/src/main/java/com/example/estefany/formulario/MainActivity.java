package com.example.estefany.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{

    private EditText Name, Phone, Email, Description;
    protected static TextView DateText;
    private Button DateButton, NextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();

        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment mDatePicker = new DatePickerFragment();
                mDatePicker.show(getFragmentManager(), "Select date");
            }
        });

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MandarDatos();
            }
        });

    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            DateText.setText("Selected Date: " + String.valueOf(year) + " / " + (month+1) + " / " + String.valueOf(day));
        }

    }

    public void iniciar(){
        Name = (EditText) findViewById(R.id.input_nombre);
        Phone = (EditText) findViewById(R.id.input_telefono);
        Email = (EditText) findViewById(R.id.input_email);
        Description = (EditText) findViewById(R.id.input_descripcion);
        DateText = (TextView) findViewById(R.id.selected_date);
        DateButton = (Button) findViewById(R.id.Date_button);
        NextButton = (Button) findViewById(R.id.Next_button);

    }

    public void MandarDatos(){
        Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
        i.putExtra(getResources().getString(R.string.pNombre),Name.getText().toString());
        i.putExtra(getResources().getString(R.string.pFecha),DateText.getText().toString());
        i.putExtra(getResources().getString(R.string.pTelefono),Phone.getText().toString());
        i.putExtra(getResources().getString(R.string.pCorreo),Email.getText().toString());
        i.putExtra(getResources().getString(R.string.pDescripcion),Description.getText().toString());
        startActivity(i);

    }


}
