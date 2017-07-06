package br.com.g2soft.g2app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import br.com.g2soft.g2app.R;
import br.com.g2soft.g2app.model.domain.ClientG2Soft;

public class ShowClientActivity extends AppCompatActivity {

    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        Intent intent = getIntent();
        ClientG2Soft clientSelected = (ClientG2Soft) intent.getSerializableExtra("clientSelected");

        TextView textViewClientName = (TextView) findViewById(R.id.textViewClientName);
        textViewClientName.setText(clientSelected.getName());

        if (clientSelected.getFantasyName() != null) {
            TextView textViewClientFantasyName = (TextView) findViewById(R.id.textViewClientFantasyName);
            textViewClientFantasyName.setText(clientSelected.getFantasyName());
        }

        TextView textViewClientCpfOrCnpjLabel = (TextView) findViewById(R.id.textViewClientCpfOrCnpjLabel);
        TextView textViewClientCPFOrCnpj = (TextView) findViewById(R.id.textViewClientCPFOrCnpj);
        if (clientSelected.getCpf() != null && !clientSelected.getCpf().isEmpty()) {
            textViewClientCPFOrCnpj.setText(clientSelected.getCpf());
        } else if (clientSelected.getCnpj() != null && !clientSelected.getCnpj().isEmpty()) {
            textViewClientCpfOrCnpjLabel.setText("CNPJ: ");
            textViewClientCPFOrCnpj.setText(clientSelected.getCnpj());
        }
        TextView textViewClientRG = (TextView) findViewById(R.id.textViewClientRG);
        if (clientSelected.getRg() != null && !clientSelected.getRg().isEmpty()) {
            textViewClientRG.setText(clientSelected.getRg());
        } else {
            TextView textViewClientRGLabel = (TextView) findViewById(R.id.textViewClientRGLabel);
            textViewClientRGLabel.setText("");
        }
        // State Registration - Inscrição Estadual
        TextView textViewClientStateRegistration = (TextView) findViewById(R.id.textViewClientStateRegistration);
        if (clientSelected.getStateRegistration() != null && !clientSelected.getStateRegistration().isEmpty()) {
            textViewClientStateRegistration.setText(clientSelected.getStateRegistration());
        } else {
            TextView textViewClientStateRegistrationLabel = (TextView) findViewById(R.id.textViewClientStateRegistrationLabel);
            textViewClientStateRegistrationLabel.setText("");
        }
        // Gender - Gênero
        TextView textViewClientGender = (TextView) findViewById(R.id.textViewClientGender);
        if (clientSelected.getGender() != null && !clientSelected.getGender().isEmpty()) {
            textViewClientGender.setText(clientSelected.getGender());
        } else {
            TextView textViewClientGenderLabel = (TextView) findViewById(R.id.textViewClientGenderLabel);
            textViewClientGenderLabel.setText("");
        }
        // NaturalOf - Natural de
        TextView textViewClientNaturalOf = (TextView) findViewById(R.id.textViewClientNaturalOf);
        if (clientSelected.getNaturalOf() != null && !clientSelected.getNaturalOf().isEmpty()) {
            textViewClientNaturalOf.setText(clientSelected.getNaturalOf());
        } else {
            TextView textViewClientNaturalOfLabel = (TextView) findViewById(R.id.textViewClientNaturalOfLabel);
            textViewClientNaturalOfLabel.setText("");
        }
        // Birth Date - Data de Nascimento
        TextView textViewClientBirthDate = (TextView) findViewById(R.id.textViewClientBirthDate);
        if (clientSelected.getBirthDate() != null) {
            textViewClientBirthDate.setText(clientSelected.getBirthDate().toString());
        } else {
            TextView textViewClientBirthDateLabel = (TextView) findViewById(R.id.textViewClientBirthDateLabel);
            textViewClientBirthDateLabel.setText("");
        }
        // Address - Endereço
        TextView textViewClientAddress = (TextView) findViewById(R.id.textViewClientAddress);
        if (clientSelected.getAddress() != null && !clientSelected.getAddress().isEmpty()) {
            textViewClientAddress.setText(clientSelected.getAddress());
        }
        // Address Number - Número do Endereço
        TextView textViewClientAddressNumber = (TextView) findViewById(R.id.textViewClientAddressNumber);
        if (clientSelected.getNumber() != null) {
            textViewClientAddressNumber.setText(clientSelected.getNumber());
        } else {
            TextView textViewClientAddressNumberLabel = (TextView) findViewById(R.id.textViewClientAddressNumberLabel);
            textViewClientAddressNumberLabel.setText("");
        }
        // ZipCode - CEP
        TextView textViewClientCep = (TextView) findViewById(R.id.textViewClientCep);
        if (clientSelected.getCep() != null && !clientSelected.getCnpj().isEmpty()) {
            textViewClientCep.setText(clientSelected.getCel1());
        } else {
            TextView textViewClientCepLabel = (TextView) findViewById(R.id.textViewClientCepLabel);
            textViewClientCepLabel.setText("");
        }
        // City - Cidade
        TextView textViewClientCity = (TextView) findViewById(R.id.textViewClientCity);
        if (clientSelected.getCity() != null && !clientSelected.getCity().isEmpty()) {
            textViewClientCity.setText(clientSelected.getCity());
        } else {
            TextView textViewClientCityLabel = (TextView) findViewById(R.id.textViewClientCityLabel);
            textViewClientCityLabel.setText("");
        }
        // Neighborhood - Bairro
        TextView textViewClientNeighborhood = (TextView) findViewById(R.id.textViewClientNeighborhood);
        if (clientSelected.getNeighborhood() != null && !clientSelected.getNeighborhood().isEmpty()) {
            textViewClientNeighborhood.setText(clientSelected.getNeighborhood());
        } else {
            TextView textViewClientNeighborhoodLabel = (TextView) findViewById(R.id.textViewClientNeighborhoodLabel);
            textViewClientNeighborhoodLabel.setText("");
        }
        // UF
        TextView textViewClientUf = (TextView) findViewById(R.id.textViewClientUf);
        if (clientSelected.getUf() != null && !clientSelected.getUf().isEmpty()) {
            textViewClientUf.setText(clientSelected.getUf());
        } else {
            TextView textViewClientUfLabel = (TextView) findViewById(R.id.textViewClientUfLabel);
            textViewClientUfLabel.setText("");
        }
    }
}
