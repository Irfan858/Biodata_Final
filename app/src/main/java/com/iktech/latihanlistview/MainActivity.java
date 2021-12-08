package com.iktech.latihanlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabTambahData;
    ListView listView;
    String mNamaMhs[] = {"Irfan Kurniawan","Andrias Abi Widyanto", "Intan Andesti"};
    String mProdiMhs[] = {"Teknik Informatika / 5","Teknik Informatika / 5","Teknik Informatika / 5"};
    int mImgMhs[] = {R.drawable.ic_baseline_account_circle,R.drawable.ic_baseline_account_circle,R.drawable.ic_baseline_account_circle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listview.
        listView = findViewById(R.id.listViewMhs);
        MyAdapter adapter = new MyAdapter(this, mNamaMhs, mProdiMhs, mImgMhs);
        listView.setAdapter(adapter);

        //FAB Button
        fabTambahData = (FloatingActionButton) findViewById(R.id.tambah_data_fab);
        fabTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahMhsActivity.class);
                startActivity(intent);
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rNamaMhs[];
        String rProdiMhs[];
        int rImgMhs[];

        MyAdapter (Context c, String NamaMhs[], String ProdiMhs[], int Img[]) {
            super(c, R.layout.row_data, R.id.NamaMhs, NamaMhs);
            this.context = c;
            this.rNamaMhs = NamaMhs;
            this.rProdiMhs = ProdiMhs;
            this.rImgMhs = Img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_data, parent, false);
            ImageView dataImgMhs = row.findViewById(R.id.ImageMhs);
            TextView dataNamaMhs = row.findViewById(R.id.NamaMhs);
            TextView dataProdiMhs = row.findViewById(R.id.ProdiMhs);

            //Setting Resource
            dataImgMhs.setImageResource(rImgMhs[position]);
            dataNamaMhs.setText(rNamaMhs[position]);
            dataProdiMhs.setText(rProdiMhs[position]);

            return row;
        }

    }
}