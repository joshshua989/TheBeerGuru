package com.joshellen.thebeerguru;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Josh on 3/5/2017.
 */

public class BrowseBrewery extends MainActivity {

    private AutoCompleteTextView actvBreweryName, actvBreweryState;
    private ImageButton ibSearchByBreweryName, ibSearchByState;
    private CheckBox cbShowBreweryInfo;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter adapter;
    private List<BreweryData> brewery_data_list;
    String[] breweryNames;

    // String array containing data for state auto_complete_text_view
    final String[] stateArray =
    {
        "AL - Alabama", "AK - Alaska", "AZ - Arizona", "AR - Arkansas", "CA - California",
        "C0 - Colorado", "CT - Connecticut", "DE - Delaware", "FL - Florida", "GA - Georgia",
        "HI - Hawaii", "ID - Idaho", "IL - Illinois", "IN - Indiana", "IA - Iowa", "KS - Kansas",
        "KY - Kentucky", "LA - Louisiana", "ME - Maine", "MD - Maryland", "MA - Massachusetts",
        "MI - Michigan", "MN - Minnesota", "MS - Mississippi", "MO - Missouri", "MT - Montana",
        "NE - Nebraska", "NV - Nevada", "NH - New Hampshire", "NJ - New Jersey", "NM - New Mexico",
        "NY - New York", "NC - North Carolina", "ND - North Dakota", "OH - Ohio", "OK - Oklahoma",
        "OR - Oregon", "PA - Pennsylvania", "RI - Rhode Island", "SC - South Carolina",
        "SD - South Dakota", "TN - Tennessee", "TX - Texas", "UT - Utah", "VT - Vermont",
        "VA - Virginia", "WA - Washington", "WV - West Virginia", "WI - Wisconsin", "WY - Wyoming"
    };

    // String array containing data for brewery auto_complete_text_view
    // Data is current as of 2013
    final String[] breweryArray =
    {
        // AL - Alabama Breweries:
        "",

        // AK - Alaska Breweries:
        "",

        // AZ - Arizona Breweries:
        "",

        // AR - Arkansas Breweries:
        "",

        // CA - California Breweries:
        "",

        // C0 - Colorado Breweries:
        "",

        // CT - Connecticut Breweries:
        "",

        // DE - Delaware Breweries:
        "",

        // FL - Florida Breweries:
        "",

        // GA - Georgia Breweries:
        "",

        // "HI - Hawaii Breweries:
        "",

        // ID - Idaho Breweries:
        "",

        // IL - Illinois Breweries:
        "",

        // IN - Indiana Breweries:
        "",

        // IA - Iowa Breweries:
        "",

        // KS - Kansas Breweries:
        "",

        // "KY - Kentucky Breweries:
        "",

        // LA - Louisiana Breweries:
        "",

        // ME - Maine Breweries:
        "",

        // MD - Maryland Breweries:
        "",

        // MA - Massachusetts Breweries:
        "",

        // MI - Michigan Breweries:
        "27 Brewing", "51 North Brewery", "57 Brewpub", "Arbor Brewing Company", "Arcadia Ales",
        "Arclight Brewing Co.", "Ascension Brewing Co.", "Atwater Brewery",
        "Austin Brothers Beer Co.", "Axle Brewing Co.", "B Nektar", "BOB's Brewery",
        "BAD Brewing Company", "Bad Frog Beer – Rose City", "Baffin Brewing Co.", "Barn Brewers",
        "Bastone Brewery", "Batch Brewing Company", "Beards Brewery", "Bell's Brewery", "Biercamp",
        "Big Buck Brewery & Steakhouse", "Big Cat Brewing Company", "Big Hart Brewing Co.",
        "Big Lake Brewing", "Bitter Old Fecker", "Black Lotus Brewery", "Blackrocks Brewery",
        "Block Brewing Company", "Blue Tractor BBQ & Brewery", "Boatyard Brewing Company",
        "Bravo! Restaurant & Cafe", "Brew Detroit", "Brew Works of Fremont", "Brewery Becker",
        "Brewery Ferment", "Brewery Terra Firma", "Brewery Vivant", "Brickside Brewery",
        "Brite Eyes Brewing Co.", "Brooks Brewing", "CJ's Brewing Co.", "Canton Brew Works",
        "Cedar Springs Brewing Co.", "Cellar Brewing Company", "Cellarmen's",
        "Charlotte Brewing Company", "Cheboygan Brewing Company", "Chelsea Alehouse Brewery",
        "Chocolay River Brewery", "Clam Lake Beer Company", "Cognition Brewing Company",
        "Constantine Brewing Company", "Cotton Brewing Company", "Cranker's Brewery",
        "Cravings Bistro & Brew Pub", "Cultivate Brewing Co.", "Dark Horse Brewery",
        "Dead Bear Brewing Co.", "Dearborn Brewing", "Detroit Beer Company",
        "Drafting Table Brewing Co.", "Dragonmead", "Draught Horse Brewery", "Dutch Girl Brewery",
        "EagleMonk Pub & Brewery", "Elk Brewing", "Elk Street Brewery",
        "Ellison Brewery and Spirits", "Eternity Brewing", "Falling Down Beer Company",
        "Farmington Brewing Company", "Fenton Winery & Brewery", "Fetch Brewing Co.",
        "Final Gravity Brewing Co.", "Fort Street Brewery", "Founders Brewing Company",
        "Four Leaf Brewing", "Frankenmuth Brewery", "Glasshouse Brewing",
        "Gonzo's BiggDogg Brewing Co.", "Grand Armory Brewing Co.", "Grand Rapids Brewing Co.",
        "Grand River Brewery", "Granite City Food & Brewery", "Gravel Bottom Craft Brewery & Supply",
        "Great Baraboo Brewing Co.", "Greenbush Brewing Co.", "Greenbush Brewing Company",
        "Greyline Brewing Co.", "Griffin Claw Brewing Co.", "Grizzly Peak Brewing Co.",
        "Harmony Brewing Co.", "Harsens Island Brewery", "HawkPeak Brewing Company",
        "Hereford & Hops", "Hideout Brewing Company", "Hop Lot Brewing Co.",
        "Hunter's Handmade Brewery and Ale House", "Jaden James Brewery", "Jamesport Brewing Co.",
        "Jasper Ridge Brewery", "Jolly Pumpkin Artisan Ales", "Keweenaw Brewing Company",
        "Kickstand Brewing Co.", "Kuhnhenn Brewing Company", "Lake Ann Brewing Co.",
        "Lake Charlevoix Brewing Co.", "Lake Superior Brewing Co.", "Lansing Brewing Co.",
        "Latitude 42 Brewing Company", "Lexington Brewing Co.", "Liberty Street Brewing Company",
        "Lily's Brewery & Seafood Grill", "Lockside Brewery", "Lynchpin Beer Co.",
        "Midtown Brewing Company", "Millgrove Brewing Co.", "Mishigama Craft Brewing",
        "Motor City Brewing Works", "Mountain Town Brewing Co.", "New Holland Brewing Company",
        "Newaygo Brewing Co.", "North Center Brewing Co.", "North Peak Brewing Company",
        "North Pier Brewing Co.", "Northern Oak Brewery", "Northport Brewing",
        "Northville Winery & Brewing Co.", "Odd Side Ales", "Old Boys' Brewhouse",
        "Old Mill Brewpub & Grill", "Old Nation Brewing Co.", "Olde Peninsula Brewpub & Restaurant",
        "One Well Brewing", "OpenRoad Brewery", "Ore Dock Brewing Co.",
        "Original Gravity Brewing Co.", "Osgood Brewing", "Our Brewing Co.", "Ozone's Brewhouse",
        "Paddle Hard Brewing", "Paw Paw Brewing Co.", "Perrin Brewing Co.", "Petoskey Brewing Co.",
        "Pigeon Hill Brewing Co.", "Pike 51 Brewing Co.", "Poison Frog Brewery",
        "Prime Time Brewers", "Railtown Brewing Co.", "Rare Bird Brewpub","Raven Brewing and BBQ",
        "Red Jacket Brewing Company", "Redwood Brewing Company", "Right Brain Brewery",
        "River Rouge Brewing Co.", "River's Edge Brewing Co.", "Roak Brewing Co.",
        "Rochester Mills Beer Company", "Rockford Brewing Co.", "Round Barn Brewery",
        "Royal Oak Brewery", "Rupert's Brew House", "Salt Springs Brewery", "Saugatuck Brewing Co.",
        "Schmohz Brewing Co.", "Sherwood Brewing Co.", "Short's Brewing Company",
        "Silver Harbor Brewing Co.", "Sister Lakes Brewing Co.", "Snowbelt Brewing Company",
        "Soo Brewing Co.", "Starving Artist Brewing Co.", "Steele Street Brewing",
        "Stony Lake Brewing Co.", "Stormcloud Brewing Company", "Tahquamenon Falls Brewery & Pub",
        "Tapistry Brewing Co.", "Tecumseh Brewing Co.", "Tenacity Brewing Co.",
        "Territorial Brewing Co.", "Texas Corners Brewing Co.", "The Filling Station Microbrewery",
        "The Gallery Brewery", "The Library Restaurant & Brew Pub", "The Livery", "The Maple Grille",
        "The Mitten Brewing Co.", "The Vierling Restaurant & Marquette Harbor Brewery",
        "The Workshop Brewing Co.", "Third Monk Brewing Co.", "Thumb Brewery", "Tibbs Brewing Co.",
        "Traffic Jam & Snug", "Trail Point Brewing Co.", "Transient Artisan Ales",
        "Tri-City Brewing", "Tripelroot", "Unity Vibration Living Kombucha Tea",
        "Unruly Brewing Co.", "Upper Hand Brewery", "Vander Mill", "Walldorff Brewpub & Bistro",
        "Watermark Brewing Co.", "White Flame Brewing Co.", "Willow Brewing", "Wiltse's Brewpub",
        "Witch's Hat Brewing Company", "Wolverine State Brewing Co.", "Woodward Avenue Brewers",

        // MN - Minnesota Breweries:
        "",

        // MS - Mississippi Breweries:
        "",

        // MO - Missouri Breweries:
        "",

        // MT - Montana Breweries:
        "",

        // NE - Nebraska Breweries:
        "",

        // NV - Nevada Breweries:
        "",

        // NH - New Hampshire Breweries:
        "",

        // NJ - New Jersey Breweries:
        "",

        // NM - New Mexico Breweries:
        "",

        // NY - New York Breweries:
        "",

        // NC - North Carolina Breweries:
        "",

        // ND - North Dakota Breweries:
        "",

        // OH - Ohio Breweries:
        "",

        // OK - Oklahoma Breweries:
        "",

        // OR - Oregon Breweries:
        "",

        // PA - Pennsylvania Breweries:
        "",

        // RI - Rhode Island Breweries:
        "",

        // SC - South Carolina Breweries:
        "",

        // SD - South Dakota Breweries:
        "",

        // TN - Tennessee Breweries:
        "",

        // TX - Texas Breweries:
        "",

        // UT - Utah Breweries:
        "",

        // VT - Vermont Breweries:
        "",

        // VA - Virginia Breweries:
        "",

        // WA - Washington Breweries:
        "",

        // WV - West Virginia Breweries:
        "",

        // WI - Wisconsin Breweries:
        "",

        // WY - Wyoming breweries:
        "",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_brewery);

        actvBreweryName = (AutoCompleteTextView) findViewById(R.id.actv_brewery_name);
        actvBreweryState = (AutoCompleteTextView) findViewById(R.id.actv_state);
        ibSearchByBreweryName = (ImageButton) findViewById(R.id.ib_search_by_brewery_name);
        ibSearchByState = (ImageButton) findViewById(R.id.ib_search_by_state);
        cbShowBreweryInfo = (CheckBox) findViewById(R.id.cb_show_brewery_info);
        recyclerView = (RecyclerView) findViewById(R.id.brewery_recycler_view);

        linearLayoutManager = new LinearLayoutManager(this);

        brewery_data_list = new ArrayList<>();
        load_featured_data_from_server("true");

        adapter = new CustomAdapter(this, brewery_data_list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition()
                        == brewery_data_list.size()-1) {
                    load_featured_data_from_server(
                            brewery_data_list.get(brewery_data_list.size()-1).getFeatured());
                }
            }
        });

        // Not sure why I have this here: ??
        for (int i = 0; i < brewery_data_list.size(); i++) {
            breweryNames[i] = brewery_data_list.get(i).getName();
        }

        /* As text is typed into the brewery name auto_complete_text_view, a dialog box containing
           possible choices will be displayed. This occurs at the threshold int.
          */
        ArrayAdapter<String> breweryNameAdapter = new ArrayAdapter<>
                (this, android.R.layout.select_dialog_item, breweryArray);
        actvBreweryName.setThreshold(2);
        actvBreweryName.setAdapter(breweryNameAdapter);

        /* As text is typed into the state auto_complete_text_view, a dialog box containing possible
           choices will be displayed. This occurs at the threshold int.
          */
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>
                (this, android.R.layout.select_dialog_item, stateArray);
        actvBreweryState.setThreshold(1);
        actvBreweryState.setAdapter(stateAdapter);

        // Load data from the server based on the user's brewery name input
        ibSearchByBreweryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breweryNameUserInput = actvBreweryName.getText().toString();
                load_name_data_from_server(breweryNameUserInput);
            }
        });

        // Load data from the server based on the user's state input
        ibSearchByState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breweryStateUserInput = actvBreweryState.getText().toString();
                load_state_data_from_server(breweryStateUserInput);
            }
        });
    }

    private void load_featured_data_from_server(final String isFeatured) {
        AsyncTask<String,Void,Void> task = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... String) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://thebeerguru.byethost13.com/conn_all.php?featured="+true)
                        .addHeader("Cookie", "__test=02f69eebbbd6c84c810f49bc320a8a7a; " +
                                   "expires=Thu, 31-Dec-37 23:55:55 GMT; path=/")
                        .build();

//                OkHttpClient client = new OkHttpClient().newBuilder()
//                        .addInterceptor(new Interceptor() {
//                            @Override
//                            public Response intercept(Chain chain) throws IOException {
//                                final Request original = chain.request();
//
//                                final Request authorized = original.newBuilder()
//                                        .url("http://thebeerguru.byethost13.com/conn_all.php?id="+id)
//                                        .addHeader("Cookie", "__test=02f69eebbbd6c84c810f49bc320a8a7a; expires=Thu, 31-Dec-37 23:55:55 GMT; path=/")
//                                        .build();
//
//                                return chain.proceed(authorized);
//                            }
//                        })
//                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0; i<array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        BreweryData data = new BreweryData(
                                object.getInt("id"),
                                object.getString("name"),
                                object.getString("image_link"),
                                object.getString("city"),
                                object.getString("state"),
                                object.getString("phone"),
                                object.getString("website"),
                                object.getString("year_established"),
                                object.getInt("rating"),
                                object.getString("featured"));

                        brewery_data_list.add(data);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        task.execute(isFeatured);
    }

    private void load_name_data_from_server(final String name) {
        AsyncTask<String,Void,Void> task = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... String) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://thebeerguru.byethost13.com/conn_all.php?name="+name)
                        .addHeader("Cookie", "__test=02f69eebbbd6c84c810f49bc320a8a7a; " +
                                "expires=Thu, 31-Dec-37 23:55:55 GMT; path=/")
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0; i<array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        BreweryData data = new BreweryData(
                                object.getInt("id"),
                                object.getString("name"),
                                object.getString("image_link"),
                                object.getString("city"),
                                object.getString("state"),
                                object.getString("phone"),
                                object.getString("website"),
                                object.getString("year_established"),
                                object.getInt("rating"),
                                object.getString("featured"));

                        brewery_data_list.add(data);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        task.execute(name);
    }

    private void load_state_data_from_server(final String state) {
        AsyncTask<String,Void,Void> task = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... String) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://thebeerguru.byethost13.com/conn_.php?name="+state)
                        .addHeader("Cookie", "__test=02f69eebbbd6c84c810f49bc320a8a7a; " +
                                "expires=Thu, 31-Dec-37 23:55:55 GMT; path=/")
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i=0; i<array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        BreweryData data = new BreweryData(
                                object.getInt("id"),
                                object.getString("name"),
                                object.getString("image_link"),
                                object.getString("city"),
                                object.getString("state"),
                                object.getString("phone"),
                                object.getString("website"),
                                object.getString("year_established"),
                                object.getInt("rating"),
                                object.getString("featured"));

                        brewery_data_list.add(data);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        task.execute(state);
    }
}
