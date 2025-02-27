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

public class EntradasActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_entradas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entradas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView  = findViewById(R.id.listaEntradas);
        listView.setAdapter(myAdapterMenu);

    }

    public void setData(){
        l_entradas.clear();

        info entrada1 = new info(
                getResources().getStringArray(R.array.entradas)[0],
                getResources().getStringArray(R.array.entradas)[1],
                R.drawable.nachos
        );
        l_entradas.add(entrada1);

        info entrada2 = new info(
                getResources().getStringArray(R.array.entradas)[2],
                getResources().getStringArray(R.array.entradas)[3],
                R.drawable.arepas
        );
        l_entradas.add(entrada2);

        info entrada3 = new info(
                getResources().getStringArray(R.array.entradas)[4],
                getResources().getStringArray(R.array.entradas)[5],
                R.drawable.papas
        );
        l_entradas.add(entrada3);

        info entrada4 = new info(
                getResources().getStringArray(R.array.entradas)[6],
                getResources().getStringArray(R.array.entradas)[7],
                R.drawable.entrada
        );
        l_entradas.add(entrada4);

        info entrada5 = new info(
                getResources().getStringArray(R.array.entradas)[8],
                getResources().getStringArray(R.array.entradas)[9],
                R.drawable.bunuelos
        );
        l_entradas.add(entrada5);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_entradas.size();
        }

        @Override
        public Object getItem(int position) {
            return l_entradas.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_entradas.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_entradas.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_entradas.get(position).descripcion);

            return view;
        }

    }
}