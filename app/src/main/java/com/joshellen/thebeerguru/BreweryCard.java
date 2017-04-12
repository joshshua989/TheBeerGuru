package com.joshellen.thebeerguru;

import android.os.Bundle;

/**
 * Created by Josh on 3/8/2017.
 */

public class BreweryCard extends BrowseBrewery {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_brewery);
    }
}
