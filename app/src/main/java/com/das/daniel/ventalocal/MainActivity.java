package com.das.daniel.ventalocal;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.das.daniel.ventalocal.Modelo.Producto;
import com.das.daniel.ventalocal.adaptadores.ListaProductoAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBManagerProducto managerProducto;
    private RecyclerView recycler;
    private ListaProductoAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Producto> listaItemsProductos;

    private EditText textoDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerProducto= new DBManagerProducto(this);
        textoBuscar= (EditText) findViewById(R.id.txtBuscar);

        inicializarRecicler();


        FloatingActionButton btnDialogoInsertar = (FloatingActionButton) findViewById(R.id.btnInsertar);
        btnDialogoInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });
        textoBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                listaItemsProductos = managerProducto.Buscar(textoBuscar.getText().toString());
                // Crear un nuevo adaptador
                adapter = new ListaProductoAdapter(listaItemsProductos, MainActivity.this);
                recycler.setAdapter(adapter);
                recycler.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void inicializarRecicler() {
        listaItemsProductos = managerProducto.getProductosList();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ListaProductoAdapter(listaItemsProductos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    public  void recargarRecicler() {
        //cargar datos
        listaItemsProductos = managerProducto.getProductosList();
        // Crear un nuevo adaptador
        adapter = new ListaProductoAdapter(listaItemsProductos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }


    private void mostrarDialogo() {
        final Dialog d=new Dialog(this);
        d.setContentView(R.layout.nuevo_producto);



        //  textoDescripcion= (EditText) d.findViewById(R.id.tvNProdDescripcion);


        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INSERTAR
                recargarRecicler();
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        d.show();
    }

}
