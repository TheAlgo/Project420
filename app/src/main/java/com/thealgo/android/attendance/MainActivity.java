package com.thealgo.android.attendance;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ekh";
    FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference mPostReference;
    private ValueEventListener mPostListener;
    EditText st;
   TextView st1;
    List<String> absentees;
    ArrayList<Students> allStudents;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        st = (EditText) findViewById(R.id.input);
        st1 = (TextView) findViewById(R.id.results);
        absentees = new ArrayList<>();
        allStudents = new ArrayList<Students>();


        DatabaseReference myRef = database.getReference("family");
        List<String> input= Arrays.asList("Nitin","Puja","Anmol","Shilpa","Sanjay","Sumit","Tanmay");
        Students s1=new Students();
        s1.names=input;
        s1.familyname="Mishra";
        String key = myRef.push().getKey();
        allStudents.add(s1);
        myRef.child(key).setValue(s1);



        List<String> input1=Arrays.asList("Sohan");
        Students s2=new Students();
        s2.names=input;
        s2.familyname="Mehra";
        String key1 = myRef.push().getKey();
        allStudents.add(s2);
        myRef.child(key1).setValue(s2);


        List<String> input2=Arrays.asList("Raman","Sudhan","Krish","Suman");
        Students s3=new Students();
        s3.names=input;
        s3.familyname="Pillai";
        String key2 = myRef.push().getKey();
        allStudents.add(s3);
        myRef.child(key2).setValue(s3);




        /*ref.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Map<String,String> results;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Students s = child.getValue(Students.class);
                    results=s.getPresentees();
                    Iterator it = results.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        if(pair.getValue()=="false")
                        {
                            absentees.add(String.valueOf(pair.getKey()));
                        }
                        // avoids a ConcurrentModificationException
                    }
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        st1.setText(absentees.size());
    }*/
        myRef.child("messages").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                  //  allStudents.add(child.getValue(Students.class));
                    Students s = child.getValue(Students.class);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void Submit(View view) {
        String finalString= "";
        absentees.clear();
        st1.setText("");
        String query = st.getText().toString();
        String log = "";
        for (Students s : allStudents) {

            if (s.getFamilyname().equals(query)) {
               List<String> arr=s.getNames();
               int len=arr.size();
               if(len==1)
               {
                   finalString="bachelor";
               }
            else if(len>1 && len<6)
                finalString="nuclear";


               else
                   finalString="joint";
            }
        }






//            st1.setText(finalString.toString());
        st1.setText(finalString);
        }

    }




