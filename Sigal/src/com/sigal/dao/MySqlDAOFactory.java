package com.sigal.dao;

import com.sigal.cotizacion.dao.CotizacionDAO;
import com.sigal.cotizacion.dao.CotizacionDetalleDAO;
import com.sigal.cotizacion.dao.MySqlCotizacionDAO;
import com.sigal.cotizacion.dao.MySqlCotizacionDetalleDAO;
import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlCategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlProductoDAO;
import com.sigal.mantenimiento.dao.MySqlProductoProveedorDAO;
import com.sigal.mantenimiento.dao.MySqlProveedorDAO;
import com.sigal.mantenimiento.dao.MySqlUmedidaDAO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.mantenimiento.dao.ProveedorDAO;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.ordencompra.dao.MySqlOrdenCompraDAO;
import com.sigal.ordencompra.dao.MySqlOrdenCompraDetalleDAO;
import com.sigal.ordencompra.dao.OrdenCompraDAO;
import com.sigal.ordencompra.dao.OrdenCompraDetalleDAO;
import com.sigal.pedido.dao.MySqlPedidoDetalleDAO;
import com.sigal.pedido.dao.MySqlSolicitudPedidoDAO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.seguridad.dao.MySqlAreaDAO;
import com.sigal.seguridad.dao.MySqlCargoDAO;
import com.sigal.seguridad.dao.MySqlUsuarioDAO;
import com.sigal.seguridad.dao.UsuarioDAO;


public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public SolicitudPedidoDAO getSolicitudPedidoDAO() {
		// TODO Auto-generated method stub
		return new MySqlSolicitudPedidoDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new MySqlProductoDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoriaDAO();
	}

	@Override
	public UmedidaDAO getUmedidaDAO() {
		// TODO Auto-generated method stub
		return new MySqlUmedidaDAO();
	}

	@Override
	public CargoDAO getCargoDAO() {
		return new MySqlCargoDAO();
	}
 
	@Override
	public AreaDAO getAreaDAO() {
		return new MySqlAreaDAO();
	} 
	@Override
	public ProveedorDAO getProveedorDAO() {
		return new MySqlProveedorDAO();
	}
 
	@Override
	public ProductoProveedorDAO getProductoProveedorDAO() {
		return new MySqlProductoProveedorDAO();
	} 
	@Override
	public PedidoDetalleDAO getPedidoDetalleDAO() {
		return new MySqlPedidoDetalleDAO();
	}
 
	@Override
	public CotizacionDAO getCotizacionDAO() {
		return new MySqlCotizacionDAO();
	}
 
	@Override
	public CotizacionDetalleDAO getCotizacionDetalleDAO() {
		return new MySqlCotizacionDetalleDAO();
	} 
	@Override
	public OrdenCompraDAO getOrdenCompraDAO() {
		return new MySqlOrdenCompraDAO();
	} 
	@Override
	public OrdenCompraDetalleDAO getOrdenCompraDetalleDAO() {
		return new MySqlOrdenCompraDetalleDAO();
	}

 
 
}
