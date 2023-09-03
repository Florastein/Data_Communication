package com.bastard.datacommunication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class timetab extends AppCompatActivity {

	private NavigationView navigationView;
	private DrawerLayout drawerLayout;
	private RecyclerView postList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetab);

		drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
		navigationView = (NavigationView) findViewById(R.id.nav_View);
		View navView = navigationView.inflateHeaderView(R.layout.nav_header);

		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {

				UserMenuSelector(item);
				return false;
			}
		});
	}

	private void UserMenuSelector(MenuItem item){

	}

	/*private void UserMenuSelector(MenuItem item) {
		switch (item.getItemId())
		{
			case R.id.nav_exams:
				Toast.makeText(this, "Exams Timetable", Toast.LENGTH_SHORT).show();
				break;

			case R.id.nav_home:
				Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
				break;

			case R.id.nav_share:
				Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
				break;

			case R.id.nav_classes:
				Toast.makeText(this, "Class TimeTable", Toast.LENGTH_SHORT).show();

		}
	}*/
}