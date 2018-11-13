package com.example.primer.datospersonales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtApellidos;
    EditText editText;
    RadioButton radioButtonHombre;
    RadioButton radioButtonMujer;
    Switch switchHijos;
    TextView txtResultado;

    RadioGroup RDGenero;

    Spinner lstEstado;
    String[] Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        editText = findViewById(R.id.editText);
        radioButtonHombre = findViewById(R.id.radioButtonHombre);
        radioButtonMujer = findViewById(R.id.radioButtonMujer);
        switchHijos = findViewById(R.id.switchHijos);
        RDGenero = findViewById(R.id.RDGenero);
        txtResultado = findViewById(R.id.txtResultado);

        //Spinner Ejercicio 5

        Estado =  new String[]{"", "Casado", "Separado", "Viudo", "Otro"};
        ArrayAdapter adaptadorEstado = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Estado);

        lstEstado = findViewById(R.id.lstEstado);
        lstEstado.setAdapter(adaptadorEstado);

        lstEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MyAPP", "Has seleccionado algo ! " + position + "  " + Estado[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Borrar Contenido
        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtApellidos.setText("");
                editText.setText("");
                txtResultado.setText("");
                radioButtonHombre.setChecked(false);
                radioButtonMujer.setChecked(false);
                switchHijos.setChecked(false);
                lstEstado.setSelection(0);
            }
        });

        //Genero
        RDGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String generoSeleccionado = "";
                if (checkedId == R.id.radioButtonHombre) generoSeleccionado = "Hombre";
                if (checkedId == R.id.radioButtonMujer) generoSeleccionado = "Mujer";

                //txtCursoSeleccionado.setText( cursoSeleccionado );

            }
        });

        //Resultado
        Button btnTexto = findViewById(R.id.btnTexto);
        btnTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtApellidos.getText().toString() + ", " + txtNombre.getText().toString() + ", " + editText.getText().toString() + ", " + lstEstado.getSelectedItem().toString());
            }
        });



    }
}
