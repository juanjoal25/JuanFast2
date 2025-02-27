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

public class PlatosFuertesActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_fuertes= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platos_fuertes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaPlatosFuertes);
        listView.setAdapter(myAdapterMenu);
    }
        public void setData() {
            l_fuertes.clear();

            info fuertes1 = new info(
                    getResources().getStringArray(R.array.Platos)[0],
                    getResources().getStringArray(R.array.Platos)[1],
                    R.drawable.fuerte
            );
            l_fuertes.add(fuertes1);

            info fuerte2 = new info(
                    getResources().getStringArray(R.array.Platos)[2],
                    getResources().getStringArray(R.array.Platos)[3],
                    R.drawable.perro
            );
            l_fuertes.add(fuerte2);

            info fuerte3 = new info(
                    getResources().getStringArray(R.array.Platos)[4],
                    getResources().getStringArray(R.array.Platos)[5],
                    R.drawable.salchipapa
            );
            l_fuertes.add(fuerte3);

            info fuerte4 = new info(
                    getResources().getStringArray(R.array.Platos)[6],
                    getResources().getStringArray(R.array.Platos)[7],
                    R.drawable.alitas
            );
            l_fuertes.add(fuerte4);

            info fuerte5 = new info(
                    getResources().getStringArray(R.array.Platos)[8],
                    getResources().getStringArray(R.array.Platos)[9],
                    R.drawable.chuzo
            );
            l_fuertes.add(fuerte5);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_fuertes.size();
        }

        @Override
        public Object getItem(int position) {
            return l_fuertes.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_fuertes.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_fuertes.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_fuertes.get(position).descripcion);

            return view;
        }
    }
}