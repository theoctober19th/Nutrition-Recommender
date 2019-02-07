package com.ersathi.nutritionrecommender;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ersathi.nutritionrecommender.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private LinearLayout diseaseLLContainer;
    private LinearLayout favoriteFoodLLContainer;
    private LinearLayout frequentFoodLLContainer;

    private CheckBox[] diseaseCheckBoxes;
    private CheckBox[] favoriteFoodCheckBoxes;
    private CheckBox[] frequentFoodCheckBoxes;

    private Spinner genderSpinner;
   // private Spinner diseaseSpinner;
    private RadioGroup diseaseRadioGroup;
    EditText nameEditText;
    EditText ageEditText;
    EditText heightEditText;
    EditText weightEditText;

    private ConstraintLayout mFormContainerLayout;
    private ProgressBar mLoadingProgressBar;


    private ImageButton nextButton;

    private User mAppUser;

    private String[] diseaseArray;
    private String[] foodArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mAppUser = new User();

        diseaseArray = getResources().getStringArray(R.array.diseases_array);
        foodArray = getResources().getStringArray(R.array.food_array);
        initalizeViews();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePersonalInformationData();

                mLoadingProgressBar.setVisibility(View.VISIBLE);
                mFormContainerLayout.setVisibility(View.INVISIBLE);

                saveDataToFirebase();
            }
        });

    }

    private void saveDataToFirebase() {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        String pushKey = rootRef.push().getKey();
        mAppUser.setId(pushKey);
        
        rootRef.child("users").child(pushKey).setValue(mAppUser).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent successIntent = new Intent(FormActivity.this, MainActivity.class);
                    startActivity(successIntent);
                }else{
                    Toast.makeText(FormActivity.this, "Error writing to database", Toast.LENGTH_SHORT).show();
                    mLoadingProgressBar.setVisibility(ProgressBar.INVISIBLE);
                    mFormContainerLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void savePersonalInformationData() {


        Spinner genderSpinner = findViewById(R.id.genderSpinner);


        mAppUser.setName(nameEditText.getText().toString());
        mAppUser.setAge(Integer.parseInt(ageEditText.getText().toString()));
        mAppUser.setHeight(Double.parseDouble(heightEditText.getText().toString()));
        mAppUser.setWeight(Double.parseDouble(weightEditText.getText().toString()));
        mAppUser.setSex(genderSpinner.getSelectedItem().toString());
//        mAppUser.setFavoriteFood(favoriteFoodSpinner.getSelectedItem().toString());
//        mAppUser.setOftenFood(frequentFoodSpinner.getSelectedItem().toString());
//        mAppUser.setDisease(diseaseSpinner.getSelectedItem().toString());
    }

    private void initalizeViews() {
        nextButton = findViewById(R.id.nextButton);



        genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(FormActivity.this, R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        nameEditText = findViewById(R.id.user_name);
        ageEditText = findViewById(R.id.user_age);
        heightEditText = findViewById(R.id.user_height);
        weightEditText = findViewById(R.id.user_weight);

        diseaseCheckBoxes = new CheckBox[diseaseArray.length];
        diseaseLLContainer = findViewById(R.id.diseaseRGContainer);
        for(int i=0; i<diseaseArray.length; i++){
            diseaseCheckBoxes[i] = new CheckBox(this);
            diseaseCheckBoxes[i].setText(diseaseArray[i]);
            diseaseCheckBoxes[i].setOnCheckedChangeListener(this);
            diseaseLLContainer.addView(diseaseCheckBoxes[i]);

        }

        favoriteFoodCheckBoxes = new CheckBox[foodArray.length];
        favoriteFoodLLContainer = findViewById(R.id.favoriteFoodLLContainer);
        for(int i=0; i<foodArray.length; i++){
            favoriteFoodCheckBoxes[i] = new CheckBox(this);
            favoriteFoodCheckBoxes[i].setText(foodArray[i]);
            favoriteFoodCheckBoxes[i].setOnCheckedChangeListener(this);
            favoriteFoodLLContainer.addView(favoriteFoodCheckBoxes[i]);

        }


        frequentFoodCheckBoxes = new CheckBox[foodArray.length];
        frequentFoodLLContainer = findViewById(R.id.frequentFoodLLContainer);
        for(int i=0; i<foodArray.length; i++){
            frequentFoodCheckBoxes[i] = new CheckBox(this);
            frequentFoodCheckBoxes[i].setText(foodArray[i]);
            frequentFoodCheckBoxes[i].setOnCheckedChangeListener(this);
            frequentFoodLLContainer.addView(frequentFoodCheckBoxes[i]);

        }


        mFormContainerLayout = findViewById(R.id.form_container);
        mLoadingProgressBar = findViewById(R.id.form_progress_bar);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
