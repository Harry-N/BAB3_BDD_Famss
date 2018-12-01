package com.example.hryle.logindemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterCompte extends AppCompatActivity {

    DataBaseCompte myDB;
    EditText txtName, txtMontant;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_compte);
        txtName = (EditText)findViewById(R.id.name);
        txtMontant = (EditText)findViewById(R.id.mountant);

        myDB = new DataBaseCompte(this);
        addCompte();
    }

    //create a method for adding data to hotel table
    public void addCompte(){
        btnSave = (Button) findViewById(R.id.bntSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertCompte(txtName.getText().toString(), txtMontant.getText().toString());
                if(isInserted){

                    Toast.makeText((AjouterCompte.this), "Data is inserted", Toast.LENGTH_LONG).show();
                    //Cursor result = myDB.getAllCompte();
                    //result.getString(0);//récupère n
                    //result.getString(1);
                    Intent intent = new Intent(AjouterCompte.this, SecondActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText((AjouterCompte.this), "Data is not inserted ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
