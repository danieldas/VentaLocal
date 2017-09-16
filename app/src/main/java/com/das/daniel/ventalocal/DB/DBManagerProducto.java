package com.das.daniel.ventalocal.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.das.daniel.ventalocal.Modelo.Producto;

import java.util.List;

/**
 * Created by Daniel on 15/09/2017.
 */
public class DBManagerProducto extends DBManager {

    private static final String NOMBRE_TABLA="producto";
    private static final String COL_ID="_id";
    private static final String COL_DESCRIPCION="descripcion";
    private static final String COL_PRECIO="precio";
    private static final String COL_CANTIDAD="cantidad";
    private static final String COL_TIPO="tipo";
    private static final String COL_ESTADO="estado";

    public static final String CREATE_TABLE="create table " + NOMBRE_TABLA +" ("+
                        COL_ID+" integer PRIMARY KEY AUTOINCREMENT, "+
                        COL_DESCRIPCION+" text NOT NULL, "+
                        COL_PRECIO+" DECIMAL(10,5) NOT NULL, "+
                        COL_CANTIDAD+" text NOT NULL, "+
                        COL_TIPO+" text NOT NULL, "+
                        COL_ESTADO+" text NOT NULL); ";

    public DBManagerProducto(Context context) {
        super(context);
    }

    public ContentValues generarValores(String id, String descripcion, String cantidad, String precio, String estado, String tipo)
    {
        ContentValues valores= new ContentValues();
        valores.put(COL_ID, id);
        valores.put(COL_DESCRIPCION, descripcion);
        valores.put(COL_CANTIDAD, cantidad);
        valores.put(COL_PRECIO, precio);
        valores.put(COL_TIPO, tipo);
        valores.put(COL_ESTADO, estado);
        return valores;
    }
    @Override
    public void insertarProducto(String id, String descripcion, String cantidad, String precio, String estado, String tipo) {
        super.getDb().insert(NOMBRE_TABLA,null,
                generarValores(id, descripcion,cantidad, precio, estado, tipo));
    }

    @Override
    public void actualizarProducto(String id, String descripcion, String cantidad, String precio, String tipo) {
        ContentValues valores= new ContentValues();
        valores.put(COL_ID, id);
        valores.put(COL_DESCRIPCION, descripcion);
        valores.put(COL_CANTIDAD, cantidad);
        valores.put(COL_PRECIO, precio);
        valores.put(COL_TIPO, tipo);
        String [] args= new String[]{id};
        super.getDb().update(NOMBRE_TABLA,valores, "_id=?", args);
    }

    @Override
    public void darBajaProducto(String id, String estado) {

    }

    @Override
    public void actualizarCantidad(String id, String cantidad) {

    }

    @Override
    public Cursor cargarCursor() {
        return null;
    }

    @Override
    public Cursor cargarCursorBuscar(String descripcion) {
        return null;
    }

    @Override
    public List<Producto> getProductosList() {
        return null;
    }

    @Override
    public List<Producto> Buscar() {
        return null;
    }
}
