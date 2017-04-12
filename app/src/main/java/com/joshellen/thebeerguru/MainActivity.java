package com.joshellen.thebeerguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInstructions, tvMailingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInstructions = (TextView) findViewById(R.id.tv_instructions);
        tvMailingList = (TextView) findViewById(R.id.tv_mailing_list);

        tvInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instructionsActivity = new Intent(v.getContext(), Instructions.class);
                startActivity(instructionsActivity);
            }
        });
        tvMailingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailingListActivity = new Intent(v.getContext(), JoinMailingList.class);
                startActivity(mailingListActivity);
            }
        });
    }

    public void bBreweryClicked(View v) {
        Intent browseBreweryActivity = new Intent(this, BrowseBrewery.class);
        startActivity(browseBreweryActivity);
    }

    public void bFlavorClicked(View v) {
        Intent browseFlavorActivity = new Intent(this, BrowseFlavor.class);
        startActivity(browseFlavorActivity);
    }

    public void bStyleClicked(View v) {
        Intent browseStyleActivity = new Intent(this, BrowseStyle.class);
        startActivity(browseStyleActivity);
    }
}
