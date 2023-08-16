package com.bastard.datacommunication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

	private Button start;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		start = findViewById(R.id.button);

		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startQUiz();
			}
		});
	}

	private void startQUiz(){
		Intent intent = new Intent(MainActivity.this, quiz.class);
		startActivity(intent);
	}
}