package com.joshellen.thebeerguru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Josh on 3/5/2017.
 */

public class BrowseStyle extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_style);
    }

    public void bSubCategoryClicked(View view)
    {
        Intent startActivity = new Intent(this, ViewPagerFragmentActivity.class);
        startActivity.putExtra("buttonID", view.getId());
        startActivity(startActivity);
    }
}
