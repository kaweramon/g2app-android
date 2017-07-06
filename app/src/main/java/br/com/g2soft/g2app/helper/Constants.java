package br.com.g2soft.g2app.helper;

import android.provider.BaseColumns;

/**
 * Created by kawe.oliveira on 04/07/2017.
 */

public class Constants {

    public static String DATABASE_NAME = "G2App";
    public static Integer DATABASE_VERSION = 1;

    public static abstract class Client implements BaseColumns {

        public final static String TABLE_NAME = "Cliente";
        public final static String COLUMN_NAME_CODIGO = "Codigo";
        public final static String COLUMN_NAME_NOME = "Nome";
        public final static String COLUMN_NAME_NOME_FANTASIA = "nome_fantasia";
        public final static String COLUMN_NAME_NOME_PAI = "nome_pai";
        public final static String COLUMN_NAME_NOME_MAE = "nome_mae";
        public final static String COLUMN_NAME_CPF = "cpf";
        public final static String COLUMN_NAME_CNPJ = "cnpj";
        public final static String COLUMN_NAME_SITUACAO = "situacao";
        public final static String COLUMN_NAME_CONVENIO = "convenio";
        public final static String COLUMN_NAME_NATURAL_DE = "natural_de";
        public final static String COLUMN_NAME_CONJUGE = "conjuge";
        public final static String COLUMN_NAME_SEXO = "sexo";
        public final static String COLUMN_NAME_DATA_CADASTRO = "data_cadastro";
        public final static String COLUMN_NAME_RG = "rg";
        public final static String COLUMN_NAME_INSC_ESTADUAL = "insc_estadual";
        public final static String COLUMN_NAME_DATA_NASCIMENTO = "data_nascimento";
        public final static String COLUMN_NAME_ENDERECO = "endereco";
        public final static String COLUMN_NAME_NUMERO = "numero";
        public final static String COLUMN_NAME_COMPLEMENTO = "complemento";
        public final static String COLUMN_NAME_BAIRRO = "bairro";
        public final static String COLUMN_NAME_UF = "uf";
        public final static String COLUMN_NAME_CIDADE = "cidade";
        public final static String COLUMN_NAME_CEP = "cep";
        public final static String COLUMN_NAME_TELEFONE = "telefone";
        public final static String COLUMN_NAME_TELEFONE2 = "telefone2";
        public final static String COLUMN_NAME_CODIGO_MUNICIPIO = "codigo_municipio";

        public final static String ON_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_NAME_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME_NOME + " VARCHAR, "
                + COLUMN_NAME_NOME_FANTASIA + " VARCHAR, "
                + COLUMN_NAME_NOME_PAI + " VARCHAR, "
                + COLUMN_NAME_NOME_MAE + " VARCHAR, "
                + COLUMN_NAME_CPF + " VARCHAR, "
                + COLUMN_NAME_CNPJ + " VARCHAR, "
                + COLUMN_NAME_SITUACAO + " VARCHAR, "
                + COLUMN_NAME_CONVENIO + " VARCHAR, "
                + COLUMN_NAME_NATURAL_DE + " VARCHAR, "
                + COLUMN_NAME_CONJUGE + " VARCHAR, "
                + COLUMN_NAME_SEXO + " VARCHAR, "
                + COLUMN_NAME_DATA_CADASTRO + " VARCHAR, "
                + COLUMN_NAME_RG + " VARCHAR, "
                + COLUMN_NAME_INSC_ESTADUAL + " VARCHAR, "
                + COLUMN_NAME_DATA_NASCIMENTO + " VARCHAR, "
                + COLUMN_NAME_ENDERECO + " VARCHAR, "
                + COLUMN_NAME_NUMERO + " VARCHAR, "
                + COLUMN_NAME_COMPLEMENTO + " VARCHAR, "
                + COLUMN_NAME_BAIRRO + " VARCHAR, "
                + COLUMN_NAME_UF + " VARCHAR, "
                + COLUMN_NAME_CIDADE + " VARCHAR, "
                + COLUMN_NAME_CEP + " VARCHAR, "
                + COLUMN_NAME_TELEFONE + " VARCHAR, "
                + COLUMN_NAME_TELEFONE2 + " VARCHAR, "
                + COLUMN_NAME_CODIGO_MUNICIPIO + " VARCHAR)";

        public final static String ON_DELETE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
