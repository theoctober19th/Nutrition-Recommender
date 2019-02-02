package com.ersathi.nutritionrecommender;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.ersathi.nutritionrecommender.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormActivity extends AppCompatActivity {

    private Spinner genderSpinner;
    private Spinner favoriteFoodSpinner;
    private Spinner frequentFoodSpinner;
    private Spinner diseaseSpinner;
    EditText nameEditText;
    EditText ageEditText;
    EditText heightEditText;
    EditText weightEditText;

    private ImageButton nextButton;

    private User mAppUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mAppUser = new User();

        initalizeViews();

    }

    private void saveDataToFirebase() {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        String pushKey = rootRef.push().getKey();
        mAppUser.setId(pushKey);
        
        rootRef.child(pushKey).setValue(mAppUser).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(FormActivity.this, "Successfully written to Database", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FormActivity.this, "Error writing to database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void savePersonalInformationData(View view) {


        Spinner genderSpinner = findViewById(R.id.genderSpinner);
        Spinner favoriteFoodSpinner = findViewById(R.id.favoriteFoodSpinner);
        Spinner frequentFoodSpinner = findViewById(R.id.oftenFoodSpinner);

        mAppUser.setName(nameEditText.getText().toString());
        mAppUser.setAge(Integer.parseInt(ageEditText.getText().toString()));
        mAppUser.setHeight(Double.parseDouble(heightEditText.getText().toString()));
        mAppUser.setWeight(Double.parseDouble(weightEditText.getText().toString()));
        mAppUser.setSex(genderSpinner.getSelectedItem().toString());
        mAppUser.setFavoriteFood(favoriteFoodSpinner.getSelectedItem().toString());
        mAppUser.setOftenFood(frequentFoodSpinner.getSelectedItem().toString());
        mAppUser.setDisease(diseaseSpinner.getSelectedItem().toString());
    }

    private void initalizeViews() {
        nextButton = findViewById(R.id.nextButton);

        genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(FormActivity.this, R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        favoriteFoodSpinner = findViewById(R.id.favoriteFoodSpinner);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(FormActivity.this, R.array.food_array, android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        favoriteFoodSpinner.setAdapter(foodAdapter);

        frequentFoodSpinner = findViewById(R.id.oftenFoodSpinner);
        frequentFoodSpinner.setAdapter(foodAdapter);

        nameEditText = findViewById(R.id.user_name);
        ageEditText = findViewById(R.id.user_age);
        heightEditText = findViewById(R.id.user_height);
        weightEditText = findViewById(R.id.user_weight);

        diseaseSpinner = (Spinner)findViewById(R.id.diseaseSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.diseases_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diseaseSpinner.setAdapter(adapter);
    }



}
