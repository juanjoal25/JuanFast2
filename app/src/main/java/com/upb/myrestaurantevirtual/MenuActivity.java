package com.upb.myrestaurantevirtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Declaración de variables

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_categoria = new ArrayList<>();
    //String[] CATEGORIAS = new String [] {"Entradas" , "Platos Fuertes" , "Bebidas" , "Postres" , "Licores"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Obtener el id del archivo xml
        //ListView lv = findViewById(android.R.id.list);

        //Prepara contenido
        //ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CATEGORIAS);

        //Asigna contenido a la vista
       //lv.setAdapter(la);

        //lv.setOnItemClickListener(this);

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView  = findViewById(R.id.list);
        listView.setAdapter(myAdapterMenu);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        switch (i){

            case 0: Intent intencion = new Intent(this, EntradasActivity.class);
                startActivity(intencion);
                break;

            case 1: Intent intencion1 = new Intent(this, PlatosFuertesActivity.class);
                startActivity(intencion1);
                break;

            case 2: Intent intencion2 = new Intent(this, BebidasActivity.class);
                startActivity(intencion2);
                break;

            case 3: Intent intencion3 = new Intent(this, PostresActivity.class);
                startActivity(intencion3);
                break;

            case 4: Intent intencion4 = new Intent(this, LicoresActivity.class);
                startActivity(intencion4);
                break;

            //Insertar otros productos


        }

    }
    public void  setData()
    {
        l_categoria.clear();

        info Entradas = new info(
                getResources().getStringArray(R.array.categorias)[0],
                getResources().getStringArray(R.array.categorias)[1],
                R.drawable.entrada
        );
        l_categoria.add(Entradas);


        info Fuerte = new info(
                getResources().getStringArray(R.array.categorias)[2],
                getResources().getStringArray(R.array.categorias)[3],
                R.drawable.fuerte
        );
        l_categoria.add(Fuerte);

        info Bebidas = new info(
                getResources().getStringArray(R.array.categorias)[4],
                getResources().getStringArray(R.array.categorias)[5],
                R.drawable.bebidas
        );
        l_categoria.add(Bebidas);

        info Postres = new info(
                getResources().getStringArray(R.array.categorias)[6],
                getResources().getStringArray(R.array.categorias)[7],
                R.drawable.postres
        );
        l_categoria.add(Postres);

        info Licores = new info(
                getResources().getStringArray(R.array.categorias)[8],
                getResources().getStringArray(R.array.categorias)[9],
                R.drawable.licores
        );
        l_categoria.add(Licores);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_categoria.size();
        }

        @Override
        public Object getItem(int position) {
            return l_categoria.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_categoria.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_categoria.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_categoria.get(position).descripcion);

            return view;
        }

    }
}