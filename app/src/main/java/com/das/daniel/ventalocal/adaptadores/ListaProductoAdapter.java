package com.das.daniel.ventalocal.adaptadores;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.das.daniel.ventalocal.ItemClickListener;
import com.das.daniel.ventalocal.MainActivity;
import com.das.daniel.ventalocal.Modelo.Producto;
import com.das.daniel.ventalocal.R;

import java.util.List;

/**
 * Created by Daniel on 15/09/2017.
 */
public class ListaProductoAdapter extends RecyclerView.Adapter<ListaProductoAdapter.ListaViewHolder> {
    private Context mainContext;

    // declarar componentes: private EditText, Spinner, Button


    int imagen1= R.drawable.ic_celular;
    int imagen2=R.drawable.ic_ropa;

    private List<Producto> items;   // de modelo
    private DBManagerProducto managerProducto;

    public ListaProductoAdapter(List<Producto> items, Context mainContext) {
        this.mainContext = mainContext;
        this.items = items;
    }

    static class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // protected TextView idProd, imageview

        ItemClickListener itemClickListener;

        public ListaViewHolder(View v) {
            super(v);
            //buscando de items_producto
            // this.idProd = (TextView) v.findViewById(R.id.tv_prod_id);
            //this.imagenGral= (ImageView) v.findViewById(R.id.img_prod_foto);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)  {
            this.itemClickListener.onItemClick(view,getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;
        }
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_recycler, viewGroup, false);

        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int position) {
        Producto item = items.get(position);
        viewHolder.itemView.setTag(item);  //guardar item

        if (item.getTipo().equals("Celular"))
        {
            // viewHolder.imagenGral.setImageResource(imagen1);
        }
        else
        {
            // viewHolder.imagenGral.setImageResource(imagen2);
        }


        // viewHolder.idProd.setText("Nº: "+item.getIdProd());    cargar de modelo



        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //OPEN DETAIL ACTIVITY
                //PASS DATA

                final Dialog d=new Dialog(mainContext);
                d.setContentView(R.layout.detalle_producto);
                // textoIdProd= (EditText) d.findViewById(R.id.tvDProdId);


                int posicion=0;
                final String itemCmb=items.get(pos).getTipo();
                if (itemCmb.equals("Celular"))
                {
                    posicion=1;
                }

                //textoIdProd.setText(items.get(pos).getIdProd());

                managerProducto= new DBManagerProducto(mainContext);

                botonActualizar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Actualizar
                        ((MainActivity) mainContext).recargarRecicler();
                        d.hide();
                    }
                });

                botonDarBaja.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AlertDialog.Builder(mainContext)
                                .setTitle("Dar de baja a producto")
                                .setMessage("¿Estás segura en dar de baja a este producto?")
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //dar baja
                                        ((MainActivity) mainContext).recargarRecicler();
                                        d.hide();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .setIcon(android.R.drawable.ic_menu_delete)
                                .show();
                    }
                });
                d.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}

