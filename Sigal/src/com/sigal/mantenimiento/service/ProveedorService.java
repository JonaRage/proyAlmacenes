package com.sigal.mantenimiento.service;

import java.sql.SQLException;
import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProveedorDTO;
import com.sigal.mantenimiento.dao.ProveedorDAO;
import com.sigal.util.Constantes;

public class ProveedorService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProveedorDAO objProveeDAO = fabrica.getProveedorDAO();
	public List<ProveedorDTO> listaProveedor() throws Exception {
		return objProveeDAO.buscarProveedor(null);
	}
	public List<ProveedorDTO> buscarProveedorXDesc(ProveedorDTO proveedor)throws Exception  {
		return objProveeDAO.buscarProveedor(null);
	}
	
	
	public List<ProveedorDTO> listaProveedorPaginado(Integer inicio,Integer tamano)throws Exception  {
		return objProveeDAO.buscarProveedorPaginados(null, inicio,tamano);
	} 
	public List<ProveedorDTO> buscarProveedorXDescPaginado(ProveedorDTO proveedor,Integer inicio,Integer tamano)throws Exception  {
		return objProveeDAO.buscarProveedorPaginados(proveedor, inicio, tamano);
	}
	public Integer listaProveedorTotal()throws Exception  {
		return objProveeDAO.buscarProveedor(null).size();
	}
	public Integer buscarProveedorXDescTotal(ProveedorDTO proveedor ) throws Exception {
		return objProveeDAO.buscarProveedor(proveedor).size();
	}
	
	public Boolean registrarProveedor(ProveedorDTO objProveedor)throws Exception  {
		return objProveeDAO.registrarProveedor(objProveedor);
	}
	public Boolean actualizarProveedor(ProveedorDTO objProveedor) throws Exception {
		return objProveeDAO.actualizarProveedor(objProveedor);
	}
	public Boolean eliminarProveedor(ProveedorDTO objProveedor)throws SQLException  {
		return objProveeDAO.eliminarProveedor(objProveedor);
	}
	public ProveedorDTO getProveedor(ProveedorDTO proveedor)throws Exception  {
		return objProveeDAO.getProveedor(proveedor);
	}
	
}
