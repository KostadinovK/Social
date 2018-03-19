package com.kosta.social;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_socials)
    TextView mSocials;
    @BindView(R.id.edt_social)
    EditText mSocial;
    @BindView(R.id.txtbtn_social)
    TextView SocialButton;


    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getAndSetupData();
    }

    private void getAndSetupData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("socials");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Social> socials = new ArrayList<>();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Social social = postSnapshot.getValue(Social.class);
                    socials.add(social);
                }
                setupData(socials);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast toast = Toast.makeText(getBaseContext(),"Socials failed",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void setupData(List<Social> socials) {
        StringBuilder sb = new StringBuilder();
        for(Social social: socials){
            sb.append(social.toString());
        }
        mSocials.setText(sb.toString());
    }

    @OnClick(R.id.txtbtn_social)
    public void onSocialClicked(){
        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        String text = mSocial.getText().toString();
        Social social = new Social(user,"type",text);
        myRef.push().setValue(social).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast toast = Toast.makeText(getBaseContext(),"Posted!",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
