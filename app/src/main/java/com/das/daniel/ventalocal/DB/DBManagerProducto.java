package com.das.daniel.ventalocal.DB;

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

    public DBManagerProducto(Context context) {
        super(context);
    }

    @Override
    public void insertarProducto(String id, String descripcion, String cantidad, String precio, String estado, String tipo) {

    }

    @Override
    public void actualizarProducto(String id, String descripcion, String cantidad, String precio, String tipo) {

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
