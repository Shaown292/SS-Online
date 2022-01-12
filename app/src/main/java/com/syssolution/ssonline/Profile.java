package com.syssolution.ssonline;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    EditText full_name, email_address, mobile, address, user_name;
    TextView full_name_label, user_name_label;
    String _name, _phone, _u_name, _email;


    SharedPreferences sharedPreferences;
    private static final String SHR_NAME = "my_pref_name";
    private static final String KEY_NAME = "my_key_name";
    private static final String PHONE_NO = "my_phone_no";
    private static final String NAME = "my_full_name";
    private static final String EMAIL = "my_email";
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        full_name = findViewById(R.id.fullname_profile);
        email_address = findViewById(R.id.email_profile);
        mobile = findViewById(R.id.phone_no_profile);
        user_name = findViewById(R.id.username_profile);
        full_name_label = findViewById(R.id.fullname_label);
        user_name_label = findViewById(R.id.username_label);


        sharedPreferences = getSharedPreferences(SHR_NAME, MODE_PRIVATE);
        reference = FirebaseDatabase.getInstance().getReference("users");


        showAllData();


    }

    private void showAllData() {
        _name = sharedPreferences.getString(NAME, null);
        _phone = sharedPreferences.getString(PHONE_NO, null);
        _u_name = sharedPreferences.getString(KEY_NAME, null);
        _email = sharedPreferences.getString(EMAIL, null);


        if (_name != null || _phone != null || _u_name != null || _email != null) {
            full_name_label.setText(_name);
            user_name_label.setText(_u_name);
            full_name.setText(_name);
            user_name.setText(_u_name);
            email_address.setText(_email);
            mobile.setText(_phone);
        }
    }

    public void update_data(View view) {

        if (isNameChange() || isUserPhoneNumberChange() || isUserNameChange() || isEmailChange()) {
            Toast.makeText(Profile.this, "Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Profile.this, "Nothing to update right now", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmailChange() {
        if (!_email.equals(email_address.getText().toString())) {

            reference.child(_u_name).child("mail").setValue(email_address.getText().toString());
            _email = email_address.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isUserNameChange() {
        if (!_u_name.equals(user_name.getText().toString())) {
            reference.child(_u_name).child("user_name").setValue(user_name.getText().toString());
            _u_name = user_name.getText().toString();
            user_name_label.setText(_u_name);
            return true;
        } else {
            return false;
        }
    }

    private boolean isUserPhoneNumberChange() {
        if (!_phone.equals(mobile.getText().toString())) {

            reference.child(_u_name).child("phone_no").setValue(mobile.getText().toString());
            _phone = mobile.getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isNameChange() {
        if (!_name.equals(full_name.getText().toString())) {

            reference.child(_u_name).child("name").setValue(full_name.getText().toString());
            _name = full_name.getText().toString();
            full_name_label.setText(_name);
            return true;
        } else {
            return false;
        }

    }

}