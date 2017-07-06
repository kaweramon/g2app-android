package br.com.g2soft.g2app.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import br.com.g2soft.g2app.R;
import br.com.g2soft.g2app.adapter.ClientArrayAdapter;
import br.com.g2soft.g2app.dao.ClientDAO;
import br.com.g2soft.g2app.model.domain.ClientG2Soft;

public class ClientsFragment extends Fragment {

    ArrayList<ClientG2Soft> clients;
    ListView listViewClients;

    public ClientsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clients = new ArrayList<ClientG2Soft>();
        GetClientsFromG2Soft teste = new GetClientsFromG2Soft();
        teste.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_clients, container, false);
        System.out.print(clients);
        Log.i("LogX", clients.toString());
        listViewClients = (ListView) rootView.findViewById(R.id.listViewClients);
        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ClientG2Soft clientSelected = clients.get(position);
                Intent intent = new Intent(getContext(), ShowClientActivity.class);
                intent.putExtra("clientSelected", clientSelected);
                startActivity(intent);
            }
        });

        Button btnNewClient = (Button) rootView.findViewById(R.id.btn_new_client);
        btnNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNewClient = new Intent(getContext(), NewClientActivity.class);
                startActivity(intentNewClient);
            }
        });

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class GetClientsFromG2Soft extends AsyncTask<String, Void, String> {

        private URL url;
        private HttpURLConnection connection = null;
        InputStream stream = null;
        Gson gson;

        @Override
        protected String doInBackground(String[] strings) {

                ClientDAO clientDAO = new ClientDAO(getContext());
                clients = clientDAO.getClients();

                /*this.url = new URL("http://192.168.1.52:8080/client");
                this.connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code: " + responseCode);
                }
                stream = connection.getInputStream();
                if (stream != null) {
                    String testeRetorno = IOUtils.toString(connection.getInputStream(), "UTF-8");

                    Log.i("TESTE",testeRetorno);
                    GsonBuilder builder = new GsonBuilder();
                    gson = builder.create();
                    Type clientListType = new TypeToken<Collection<ClientG2Soft>>() {}.getType();
//                    clients = (ArrayList<ClientG2Soft>) gson.fromJson(testeRetorno, clientListType);

                    ClientDAO clientDAO = new ClientDAO(getContext());
                    clients = clientDAO.getClients();

                    *//*for (ClientG2Soft client: clients) {
                        if (!clientDAO.isClientInDB(client.getCpf(), client.getCnpj())){
                            clientDAO.insertClient(client);
                        }
                    }
                    Log.i("TESTE2", clients.toString());*//*
                    return testeRetorno;*/
                    return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ClientArrayAdapter clientAdapter = new ClientArrayAdapter(getContext(), clients);
            listViewClients.setAdapter(clientAdapter);
        }
    }

}
