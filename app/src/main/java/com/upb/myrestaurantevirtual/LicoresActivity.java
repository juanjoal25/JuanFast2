package com.upb.myrestaurantevirtual;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LicoresActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_licores= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_licores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaLicores);
        listView.setAdapter(myAdapterMenu);

    }
    public void setData() {
        l_licores.clear();

        info licor1 = new info(
                getResources().getStringArray(R.array.Licores)[0],
                getResources().getStringArray(R.array.Licores)[1],
                R.drawable.aguardi
        );
        l_licores.add(licor1);

        info licor2 = new info(
                getResources().getStringArray(R.array.Licores)[2],
                getResources().getStringArray(R.array.Licores)[3],
                R.drawable.ron
        );
        l_licores.add(licor2);

        info licor3 = new info(
                getResources().getStringArray(R.array.Licores)[4],
                getResources().getStringArray(R.array.Licores)[5],
                R.drawable.jose
        );
        l_licores.add(licor3);

        info licor4 = new info(
                getResources().getStringArray(R.array.Licores)[6],
                getResources().getStringArray(R.array.Licores)[7],
                R.drawable.bucha
        );
        l_licores.add(licor4);

        info licor5 = new info(
                getResources().getStringArray(R.array.Licores)[8],
                getResources().getStringArray(R.array.Licores)[9],
                R.drawable.cerveza
        );
        l_licores.add(licor5);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_licores.size();
        }

        @Override
        public Object getItem(int position) {
            return l_licores.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("useCompatLoadingForDrawbles")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null) {
                // Make up a new view
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.info_menu, null);
            } else {
                // Use convertView if it is available
                view = convertView;
            }

            // Example to get an image resource
            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(l_licores.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_licores.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_licores.get(position).descripcion);

            return view;
        }
    }
}