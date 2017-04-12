package com.joshellen.thebeerguru;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Josh on 4/4/2017.
 *
 * This class will control the sub-category activity that is inflated when a primary category
 * button is clicked in the BrowseStyle activity.
 *
 * On creation:
 *   (1) the button id data that was passed with the intent from the BrowseStyle activity is used to
 *       set the appropriate 'primary category' header text and the appropriate text and/or
 *       visibility of each radio buttons is displayed,
 *   (2) the "featured" text view onClickListener is set, and
 *   (3) the "only show beers with additives" checkbox onClickListener is set that will define what
 *       will happen for the 'checked' and 'un-checked' states.
 */

public class FragmentStyleSubCatMain extends BrowseStyle {

    // handle variables for each dynamic xml object utilized in this [sub-category] activity
    private TextView header, featured;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11, rb12;
    private CheckBox cbAdditives;

    /**
     * onCreate method - called when this [sub-category] activity is inflated
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // inflate the sub-category activity layout
        setContentView(R.layout.fragment_style_sub_cat_main);

        // initialize the dynamic xml objects from this [sub-category] activity
        header = (TextView) findViewById(R.id.tv_header);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb6 = (RadioButton) findViewById(R.id.radioButton6);
        rb7 = (RadioButton) findViewById(R.id.radioButton7);
        rb8 = (RadioButton) findViewById(R.id.radioButton8);
        rb9 = (RadioButton) findViewById(R.id.radioButton9);
        rb10 = (RadioButton) findViewById(R.id.radioButton10);
        rb11 = (RadioButton) findViewById(R.id.radioButton11);
        rb12 = (RadioButton) findViewById(R.id.radioButton12);
        featured = (TextView) findViewById(R.id.tv_featured);
        cbAdditives = (CheckBox) findViewById(R.id.cb_additives);

        // retrieve "put extra" data from BrowseStyle class intent call
        // extra data is the button id that was clicked
        Intent mIntent = getIntent();
        // 0 is the default id
        int id = mIntent.getIntExtra("buttonID", 0);

        /* this switch statement will set the appropriate header text that needs to be displayed and
           call the appropriate method that will set the text and visibility of the radio buttons
         */
        switch (id)
        {
            case 0:
                // error handling if button id is invalid
                header.setText("Something went wrong");
                break;
            case R.id.b_lager_and_light_ales:
                header.setText(R.string.lagers);
                setLagerAndLightAlesRB();
                break;
            case R.id.b_wheat_ales:
                header.setText(R.string.wheats);
                setWheatAlesRB();
                break;
            case R.id.b_pale_ales_and_ipas:
                header.setText(R.string.pales);
                setPaleAlesAndIPAsRB();
                break;
            case R.id.b_belgian_ales:
                header.setText(R.string.belgians);
                setBelgianAlesRB();
                break;
            case R.id.ambers_and_browns:
                header.setText(R.string.ambers);
                setAmbersAndBrownsRB();
                break;
            case R.id.b_porters_and_stouts:
                header.setText(R.string.porters);
                setPortersAndStoutsRB();
                break;
            case R.id.b_strong_ales_and_barleywines:
                header.setText(R.string.strongs);
                setStrongAlesAndBarleywinesRB();
                break;
            case R.id.b_sours:
                header.setText(R.string.sours);
                setSoursRB();
                break;
            case R.id.b_ciders_and_meads:
                header.setText(R.string.ciders);
                setCidersAndMeadsRB();
                break;
        }

//        rb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        /**
//         * this is the OnClickListener that will determine what will happen when the featured text
//         * view is clicked
//         */
//        featured.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                // do something
//            }
//        });
//
//        /**
//         * this is the OnClickListener that will determine what will happen when the "only show
//         * beers with additives" checkbox is checked and un-checked
//         */
//        cbAdditives.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                if (cbAdditives.isChecked())
//                {
//                    // show all beers for the sub-category that is checked -or- if no sub-category
//                    // is checked, show all featured beers for the appropriate primary category
//                }
//                else
//                {
//                    // show only beers with additives for the sub-category that is checked -or- if
//                    // no sub-category is checked, show all additive-added beers for the appropriate
//                    // primary category
//                }
//            }
//        });
    }

    // --------------------------------------------------------------------------------------------
    // the following methods will set the appropriate radio button sub-category text and/or set the
    // appropriate visibility of the radio buttons for each of the primary category options:
    // --------------------------------------------------------------------------------------------

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Lager and Light Ales primary category option
     */
    private void setLagerAndLightAlesRB()
    {
        rb1.setText(R.string.Lager_sub_cat_1);
        rb2.setText(R.string.Lager_sub_cat_2);
        rb3.setText(R.string.Lager_sub_cat_3);
        rb4.setText(R.string.Lager_sub_cat_4);
        rb5.setText(R.string.Lager_sub_cat_5);
        rb6.setText(R.string.Lager_sub_cat_6);
        rb7.setText(R.string.Lager_sub_cat_7);
        rb8.setText(R.string.Lager_sub_cat_8);
        rb9.setText(R.string.Lager_sub_cat_9);
        rb10.setText(R.string.Lager_sub_cat_10);
        rb11.setText(R.string.Lager_sub_cat_11);
        rb12.setText(R.string.Lager_sub_cat_12);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Wheat Ales primary category option
     */
    private void setWheatAlesRB()
    {
        rb1.setText(R.string.wheat_sub_cat_1);
        rb2.setText(R.string.wheat_sub_cat_2);
        rb3.setText(R.string.wheat_sub_cat_3);
        rb4.setText(R.string.wheat_sub_cat_4);
        rb5.setText(R.string.wheat_sub_cat_5);
        rb6.setText(R.string.wheat_sub_cat_6);
        rb7.setText(R.string.wheat_sub_cat_7);
        rb8.setText(R.string.wheat_sub_cat_8);
        rb9.setText(R.string.wheat_sub_cat_9);
        rb10.setText(R.string.wheat_sub_cat_10);
        rb11.setText(R.string.wheat_sub_cat_11);
        rb12.setText(R.string.wheat_sub_cat_12);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Pale Ales and IPAs primary category option
     */
    private void setPaleAlesAndIPAsRB()
    {
        rb1.setText(R.string.pale_sub_cat_1);
        rb2.setText(R.string.pale_sub_cat_2);
        rb3.setText(R.string.pale_sub_cat_3);
        rb4.setText(R.string.pale_sub_cat_4);
        rb5.setText(R.string.pale_sub_cat_5);
        rb6.setText(R.string.pale_sub_cat_6);
        rb7.setText(R.string.pale_sub_cat_7);
        rb8.setText(R.string.pale_sub_cat_8);
        rb9.setText(R.string.pale_sub_cat_9);
        rb10.setText(R.string.pale_sub_cat_10);
        rb11.setText(R.string.pale_sub_cat_11);
        rb12.setText(R.string.pale_sub_cat_12);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Belgian Ales primary category option
     */
    private void setBelgianAlesRB()
    {
        rb1.setText(R.string.belgian_sub_cat_1);
        rb2.setText(R.string.belgian_sub_cat_2);
        rb3.setText(R.string.belgian_sub_cat_3);
        rb4.setText(R.string.belgian_sub_cat_4);
        rb5.setText(R.string.belgian_sub_cat_5);
        rb6.setText(R.string.belgian_sub_cat_6);
        rb7.setText(R.string.belgian_sub_cat_7);
        rb8.setText(R.string.belgian_sub_cat_8);
        rb9.setText(R.string.belgian_sub_cat_9);
        rb10.setText(R.string.belgian_sub_cat_10);
        rb11.setText(R.string.belgian_sub_cat_11);
        rb12.setText(R.string.belgian_sub_cat_12);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Ambers and Browns primary category option
     */
    private void setAmbersAndBrownsRB()
    {
        rb1.setText(R.string.amber_sub_cat_1);
        rb2.setText(R.string.amber_sub_cat_2);
        rb3.setText(R.string.amber_sub_cat_3);
        rb4.setText(R.string.amber_sub_cat_4);
        rb5.setText(R.string.amber_sub_cat_5);
        rb6.setText(R.string.amber_sub_cat_6);
        rb7.setText(R.string.amber_sub_cat_7);
        rb8.setText(R.string.amber_sub_cat_8);
        rb9.setText(R.string.amber_sub_cat_9);
        rb10.setText(R.string.amber_sub_cat_10);
        rb11.setText(R.string.amber_sub_cat_11);
        rb12.setVisibility(View.INVISIBLE);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Porters and Stouts primary category option
     */
    private void setPortersAndStoutsRB()
    {
        rb1.setText("Porters");
        rb2.setText("Irish & Dry Stouts");
        rb3.setText("Imperial Porters");
        rb4.setText("White Stouts");
        rb5.setText("Stouts");
        rb6.setText("Extra Stouts");
        rb7.setText("Milk Stouts");
        rb8.setText("Imperial Stouts");
        rb9.setText("Oatmeal Stouts");
        rb10.setText("Dark Ales");
        rb11.setText("Coffee Stouts");
        rb12.setText("Doubles & BA");
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Strong Ales and Barleywines primary category option
     */
    private void setStrongAlesAndBarleywinesRB()
    {
        rb1.setText("Strong Ales");
        rb2.setText("Scotch Ales");
        rb3.setText("Strong Golden Ales");
        rb4.setText("Wee Heavys");
        rb5.setText("Strong Pale Ales");
        rb6.setText("Barleywines");
        rb7.setText("Strong Red Ales");
        rb8.setText("Wheatwines");
        rb9.setText("Strong Dark Ales");
        rb10.setText("Barrel-Aged");
        rb11.setText("English Old Ales");
        rb12.setVisibility(View.INVISIBLE);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Sours primary category option
     */
    private void setSoursRB()
    {
        rb1.setText("Wild Ales");
        rb2.setText("Sour Dark Ales");
        rb3.setText("Wild Saisons");
        rb4.setText("Sour Imperial Ales");
        rb5.setText("Sour Ales");
        rb6.setText("Goses");
        rb7.setText("Kettle Sours");
        rb8.setText("Berliner Weisses");
        rb9.setText("Ales w/ Bretta");
        rb10.setText("Dry-Hopped & BA");
        rb11.setText("Blended Ales");
        rb12.setVisibility(View.INVISIBLE);
    }

    /**
     * this method will set the sub-category text and appropriate visibility of each radio button
     * for the Ciders and Meads primary category option
     */
    private void setCidersAndMeadsRB()
    {
        rb1.setText("Ciders");
        rb2.setText("Barrel-Aged Ciders");
        rb3.setText("Semi-Sweet Ciders");
        rb4.setText("Cysers");
        rb5.setText("Dry Ciders");
        rb6.setText("Meads");
        rb7.setText("English-Style Ciders");
        rb8.setText("Dry Meads");
        rb9.setText("Ciders w/ Belgian Yeast");
        rb10.setText("Barrel-Aged Meads");
        rb11.setText("Wet / Dry Hopped Ciders");
        rb12.setVisibility(View.INVISIBLE);
    }
}
