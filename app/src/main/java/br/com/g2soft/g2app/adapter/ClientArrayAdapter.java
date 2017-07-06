package br.com.g2soft.g2app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.g2soft.g2app.R;
import br.com.g2soft.g2app.model.domain.ClientG2Soft;

/**
 * Created by kawe.oliveira on 05/07/2017.
 */

public class ClientArrayAdapter extends ArrayAdapter<ClientG2Soft> {
    private final Context context;
    private final List<ClientG2Soft> clients;

    public ClientArrayAdapter(Context context, ArrayList<ClientG2Soft> clients) {
        super(context, -1, clients);
        this.context = context;
        this.clients = clients;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClientG2Soft client = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.client_cel, parent, false);
        if (rowView != null) {
            TextView textViewClientName = (TextView) rowView.findViewById(R.id.textViewClientName);
            TextView textViewClientCPFOrCNPJ = (TextView) rowView.findViewById(R.id.textViewClientCPFOrCNPJ);
            TextView textViewClientCity = (TextView) rowView.findViewById(R.id.textViewClientCity);

            if (client.getName() != null && !client.getName().isEmpty()) {
                textViewClientName.setText(client.getName());
            }

            if (client.getCpf() != null && !client.getCpf().isEmpty()) {
                textViewClientCPFOrCNPJ.setText("CPF: " + client.getCpf());
            } else if (client.getCnpj() != null && !client.getCnpj().isEmpty()) {
                textViewClientCPFOrCNPJ.setText("CNPJ: " + client.getCnpj());
            }
            if (client.getCity() != null && !client.getCity().isEmpty()) {
                textViewClientCity.setText("Cid.:" + client.getCity());
            }
        }
        return rowView;
    }
}
