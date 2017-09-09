/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
//        earthquakes.add(new Earthquake("7.2", "Yelizovo, Russia", "1454124312220"));
//        earthquakes.add(new Earthquake("6.1", "Taron, Papua New Guinea", "1453777820750"));
//        earthquakes.add(new Earthquake("6.3", "Al Hoceima, Morocco", "1453695722730"));
//        earthquakes.add(new Earthquake("7.1", "Old Iliamna, Alaska", "1453631430230"));
//        earthquakes.add(new Earthquake("6.6", "Tomatlan, Mexico", "1453399617650"));
//        earthquakes.add(new Earthquake("6.7", "Shizunai, Japan", "1452741933640"));
//        earthquakes.add(new Earthquake("6.1", "Charagua, Bolivia", "1452741928270"));
//        earthquakes.add(new Earthquake("6.2", "Rumoi, Japan", "1452532083920"));
//        earthquakes.add(new Earthquake("6.5", "Sarangani, Philippines", "1452530285900"));
//        earthquakes.add(new Earthquake("6", "Pacific-Antarctic Ridge", "1451986454620"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, earthquakes);
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(adapter);
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake = adapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(websiteIntent);
            }
        });

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
//        earthquakeListView.setAdapter(adapter);
    }
}
