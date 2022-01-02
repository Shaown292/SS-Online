package com.syssolution.ssonline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.syssolution.ssonline.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity {


    ActivityRegistrationBinding binding;
    SharedPreferences sharedPreferences;

    private static final String SHR_NAME = "my_pref_name";
    private static final String KEY_NAME = "my_key_name";
    private static final String PHONE_NO = "my_phone_no";
    private static final String NAME = "my_full_name";
    private static final String EMAIL = "my_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPreferences = getSharedPreferences(SHR_NAME, MODE_PRIVATE);


        String SH_name = sharedPreferences.getString(KEY_NAME, null);

        if (SH_name != null){
            Intent intent = new Intent(Registration.this, Homepage.class);
            startActivity(intent);
        }
    }


    private boolean validName() {
        String val = binding.nameBox.getText().toString();
        if (val.isEmpty()) {
            binding.nameBox.setError("This Field can not be empty");
            return false;
        } else {
            binding.nameBox.setError(null);
            return true;
        }
    }
    private boolean validUserName() {
        String val = binding.nameBox.getText().toString();
        if (val.isEmpty()) {
            binding.nameBox.setError("This Field can not be empty");
            return false;
        } else {
            binding.nameBox.setError(null);
            return true;
        }
    }


    private boolean validMobName() {
        String val = binding.phoneNoBox.getText().toString();
        if (val.isEmpty()) {
            binding.phoneNoBox.setError("This Field can not be empty");
            return false;
        } else {
            binding.phoneNoBox.setError(null);
            return true;
        }
    }

    private boolean validEmail() {
        String val = binding.mailBox.getText().toString();
        String emailPatter = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            binding.mailBox.setError("This Field can not be empty");
            return false;
        } else if (!val.matches(emailPatter)) {
            binding.mailBox.setError("invalid Email");
            return false;
        } else {
            binding.mailBox.setError(null);
            return true;
        }
    }

    public void registerUser (View view) {

        if (!validName() | !validUserName() | !validEmail() | !validMobName()) {
            return;
        }
        else{
            isUser();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();


        String  name = binding.nameBox.getText().toString();
        String  phone_no = binding.phoneNoBox.getText().toString();
        String email = binding.mailBox.getText().toString();
        String user_name = binding.usernameBox.getText().toString();

        editor.putString(KEY_NAME,user_name);
        editor.putString(PHONE_NO,phone_no);
        editor.putString(EMAIL, email);
        editor.putString(NAME, name);
        editor.apply();
        Intent intent = new Intent(Registration.this, Phone_Verification.class);
        startActivity(intent);
        Toast.makeText(Registration.this, "Logged in", Toast.LENGTH_SHORT).show();
    }

    private void isUser() {
        String  name = binding.nameBox.getText().toString();
        String  phone_no = binding.phoneNoBox.getText().toString();
        String email = binding.mailBox.getText().toString();
        String user_name = binding.usernameBox.getText().toString();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        user_helper helper = new user_helper(name,user_name, email, phone_no);
        reference.child(user_name).setValue(helper);


    }

    }
