//Nim :10118348
//Nama :Muhammad Novel Zalsastian
//Kelas :IF8
//Tanggal Pengerjaan : 11 Agustus 2021
package com.example.uas_10118348_akb;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecreationList extends AppCompatActivity {

//Stuff for db
    private String tmpwisata;
    private String alamat;
    private int tarif;
    private int rating;

    public RecreationList() {
    }
    public String getTmpwisata(){
        return tmpwisata;
    }
    public String getAlamat(){
        return alamat;
    }
    public int getTarif(){
        return tarif;
    }
    public int getRating(){
        return rating;
    }
    //get
    public void setTmpwisata(String tmpwisata){
        this.tmpwisata= tmpwisata;
    }
    public void setAlamat(String alamat){
        this.alamat= alamat;
    }
    public void setTarif(int tarif){
        this.tarif= tarif;
    }
    public void setRating(int rating){
        this.rating= rating;
    }
//set

//crud
    EditText txttempwisata,txtalamat,txttarif,txtrating;
    Button btnsave,btnadd,btnview,btndelete;
    DatabaseReference dbRef;
    RecreationList rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation_list);

        txttempwisata = findViewById(R.id.tmptwst);
        txtalamat = findViewById(R.id.alamat);
        txttarif = findViewById(R.id.tarif);
        txtrating = findViewById(R.id.rating);

        btnadd = findViewById(R.id.btn_add);
        btnsave = findViewById(R.id.btn_save);
        btndelete = findViewById(R.id.btn_delete);
        btnview = findViewById(R.id.btn_view);

        rec = new RecreationList();

        dbRef = FirebaseDatabase.getInstance().getReference().child("RecreationList");
        try {
            if (TextUtils.isEmpty(txttempwisata.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Insert Place",Toast.LENGTH_LONG).show();
            else if (TextUtils.isEmpty(txtalamat.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Insert Location",Toast.LENGTH_LONG).show();
            else{
             rec.setTmpwisata(txttempwisata.getText().toString().trim());
             rec.setAlamat(txtalamat.getText().toString().trim());
             rec.setTarif(Integer.parseInt(txttarif.getText().toString().trim()));
             rec.setRating(Integer.parseInt(txtrating.getText().toString().trim()));
            }
            //push
            dbRef.push().setValue(rec);
            //popup
            Toast.makeText(getApplicationContext(), "Data Successfully Added",Toast.LENGTH_LONG).show();




        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Data ",Toast.LENGTH_LONG).show();
        }

        //view
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("RecreationList").child("rec1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txttempwisata.setText(dataSnapshot.child(tmpwisata).getValue().toString());
                    txtalamat.setText(dataSnapshot.child(alamat).getValue().toString());
                    txttarif.setText(dataSnapshot.child(String.valueOf(tarif)).getValue().toString());
                    txtrating.setText(dataSnapshot.child(String.valueOf(rating)).getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "What To Display ??",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //delete
        DatabaseReference deleteRef = FirebaseDatabase.getInstance().getReference().child("RecreationList");
        deleteRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("rec1")){
                    dbRef = FirebaseDatabase.getInstance().getReference().child("RecreationList").child("rec1");
                    dbRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Data Has Been Deleted",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No Data To Update(delete)",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
