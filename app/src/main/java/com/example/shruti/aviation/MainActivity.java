package com.example.shruti.aviation;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flag=false;
    Uri uri;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                flag=true;
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(flag) {
                    if (selectedItem.equals("India")) {
                        uri = Uri.parse("http://www.Aviation-News-India.blogspot.com");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    if (selectedItem.equals("USA")){
                        uri = Uri.parse("http://www.USA-Aviation-News.blogspot.com");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    if (selectedItem.equals("New Zealand")){
                        uri = Uri.parse("http://www.Newzealand-Aviation-News.blogspot.co.nz");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    if (selectedItem.equals("Australia")){
                        uri = Uri.parse("http://www.Australian-Airlines-News.blogspot.com.au");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    if (selectedItem.equals("Canada")){
                        uri = Uri.parse("http://www.Canadian-Aviation-News.blogspot.ca");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    if (selectedItem.equals("Philippines")){
                        uri = Uri.parse("http://www.Philippine-Aviation-News.blogspot.com.ph");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(getApplicationContext(),"Please select a country", Toast.LENGTH_LONG).show();
            }
        });
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri = Uri.parse("http://www.AllAviationNews.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("EXIT");
        builder.setMessage("Do you want to exit? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
