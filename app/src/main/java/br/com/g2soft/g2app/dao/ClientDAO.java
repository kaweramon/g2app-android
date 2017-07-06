package br.com.g2soft.g2app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.g2soft.g2app.helper.Constants;
import br.com.g2soft.g2app.helper.G2AppDatabaseOpenHelper;
import br.com.g2soft.g2app.model.domain.ClientG2Soft;

/**
 * Created by kawe.oliveira on 04/07/2017.
 */

public class ClientDAO {

    private G2AppDatabaseOpenHelper dbHelper;
    private Context context;

    public ClientDAO(Context context) {
        this.context = context;
        dbHelper = new G2AppDatabaseOpenHelper(context);
    }

    public void insertClient(ClientG2Soft client) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        if (client.getName() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_NOME, client.getName());
        }
        if (client.getFantasyName() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_NOME_FANTASIA, client.getFantasyName());
        }
        if (client.getCpf() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_CPF, client.getCpf());
        }
        if (client.getCnpj() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_CNPJ, client.getCnpj());
        }
        if (client.getCity() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_CIDADE, client.getCity());
        }
        if (client.getUf() != null) {
            contentValues.put(Constants.Client.COLUMN_NAME_UF, client.getUf());
        }
        db.insertOrThrow(Constants.Client.TABLE_NAME, null, contentValues);
        Log.i("LogX", "Client Inserted: " + client.getName());
        db.close();
    }

    public boolean isClientInDB(String cpf, String cnpj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String query = "SELECT nome FROM " + Constants.Client.TABLE_NAME +
                " WHERE ";

        if (cpf == null && cnpj == null) {
            return false;
        } else if (cpf != null && !cpf.isEmpty()) {
            query += "cpf = '" + cpf + "'";
        } else if (cnpj != null && !cnpj.isEmpty()) {
            query += " cnpj = '" + cnpj + "'";
        }

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() == -1) {
            return false;
        }

        return true;
    }

    public ArrayList<ClientG2Soft> getClients() {
        ArrayList<ClientG2Soft> clients = new ArrayList<ClientG2Soft>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String clientColumns[] = {Constants.Client.COLUMN_NAME_CODIGO,
                Constants.Client.COLUMN_NAME_NOME,
                Constants.Client.COLUMN_NAME_NOME_FANTASIA,
                Constants.Client.COLUMN_NAME_CPF,
                Constants.Client.COLUMN_NAME_CNPJ,
                Constants.Client.COLUMN_NAME_CIDADE,
                Constants.Client.COLUMN_NAME_UF};

        Cursor cursor = db.query(Constants.Client.TABLE_NAME, clientColumns, null, null, null, null, null);

        while(cursor.moveToNext()) {
            ClientG2Soft client = new ClientG2Soft();
            setClientProperties(client, cursor);
            clients.add(client);
        }
        db.close();
        return clients;
    }

    private void setClientProperties(ClientG2Soft client, Cursor cursor) {
        client.setId(cursor.getInt(0));
        client.setName(cursor.getString(1));
        client.setFantasyName(cursor.getString(2));
        client.setCpf(cursor.getString(3));
        client.setCnpj(cursor.getString(4));
        client.setCity(cursor.getString(5));
        client.setUf(cursor.getString(6));
    }
}
