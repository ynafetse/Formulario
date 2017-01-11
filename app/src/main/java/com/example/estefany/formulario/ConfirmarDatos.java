package com.example.estefany.formulario;

import android.content.Intent;
import android.opengl.EGL14;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.jar.Attributes;

import static android.R.attr.editable;

public class ConfirmarDatos extends AppCompatActivity {

    public TextView Name_, Birth_, Phone_, Email_, Description_;
    public Button EditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        iniciar();
        MostrarParametros();

        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();

            }
        });

    }

    public void iniciar(){

        Name_ = (TextView) findViewById(R.id.Name_confirm);
        Birth_ = (TextView) findViewById(R.id.Bd_confirm);
        Phone_ = (TextView) findViewById(R.id.Phone_confirm);
        Email_ = (TextView) findViewById(R.id.Email_confirm);
        Description_ = (TextView) findViewById(R.id.Description_confirm);
        EditButton = (Button) findViewById(R.id.Edit_button);

    }

    public void MostrarParametros(){

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String fecha = parametros.getString(getResources().getString(R.string.pFecha));
        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        String email = parametros.getString(getResources().getString(R.string.pCorreo));
        String descripcion = parametros.getString(getResources().getString(R.string.pDescripcion));

        Name_.setText(nombre);
        Birth_.setText(fecha);
        Phone_.setText(telefono);
        Email_.setText(email);
        Description_.setText(descripcion);
    }

    public void Back(){
        Intent ii = new Intent(ConfirmarDatos.this, MainActivity.class);
        startActivity(ii);

    }

}


