package br.com.g2soft.g2app.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import br.com.g2soft.g2app.R;

public class NewClientActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);

        final RadioButton radioButtonClientCPF = (RadioButton) findViewById(R.id.radioButtonClientCPF);
        final RadioButton radioButtonClientCNPJ = (RadioButton) findViewById(R.id.radioButtonClientCNPJ);
        final EditText editTextClientCpf = (EditText) findViewById(R.id.editTextClientCPF);
        final EditText editTextClientCnpj = (EditText) findViewById(R.id.editTextClientCNPJ);
        radioButtonClientCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButtonClientCPF.isChecked()) {
                    editTextClientCpf.setVisibility(View.VISIBLE);
                    editTextClientCnpj.setVisibility(View.INVISIBLE);
                } else {
                    editTextClientCpf.setVisibility(View.INVISIBLE);
                }
            }
        });
        radioButtonClientCNPJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButtonClientCNPJ.isChecked()) {
                    editTextClientCnpj.setVisibility(View.VISIBLE);
                    editTextClientCpf.setVisibility(View.INVISIBLE);
                } else {
                    editTextClientCnpj.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
