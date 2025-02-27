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

public class BebidasActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_bebidas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bebidas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView  = findViewById(R.id.listaBebidas);
        listView.setAdapter(myAdapterMenu);
    }
    public void setData() {
        l_bebidas.clear();

        info bebida1 = new info(
                getResources().getStringArray(R.array.Bebidas)[0],
                getResources().getStringArray(R.array.Bebidas)[1],
                R.drawable.bebidas
        );
        l_bebidas.add(bebida1);

        info bebida2 = new info(
                getResources().getStringArray(R.array.Bebidas)[2],
                getResources().getStringArray(R.array.Bebidas)[3],
                R.drawable.soda
        );
        l_bebidas.add(bebida2);

        info bebida3 = new info(
                getResources().getStringArray(R.array.Bebidas)[4],
                getResources().getStringArray(R.array.Bebidas)[5],
                R.drawable.limonada
        );
        l_bebidas.add(bebida3);

        info bebida4 = new info(
                getResources().getStringArray(R.array.Bebidas)[6],
                getResources().getStringArray(R.array.Bebidas)[7],
                R.drawable.agua
        );
        l_bebidas.add(bebida4);

        info bebida5 = new info(
                getResources().getStringArray(R.array.Bebidas)[8],
                getResources().getStringArray(R.array.Bebidas)[9],
                R.drawable.sabor
        );
        l_bebidas.add(bebida5);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_bebidas.size();
        }

        @Override
        public Object getItem(int position) {
            return l_bebidas.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_bebidas.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_bebidas.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_bebidas.get(position).descripcion);

            return view;
        }
    }
}