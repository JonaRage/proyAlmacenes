/**
 * MySqlInformeInternoDAO 29/07/2013
 */
package com.sigal.informeinterno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlInformeInternoDAO implements InformeInternoDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();  
	@Override
	public Object registrarII(InformeInternoDTO ii,
			List<InformeInternoDetalleDTO> iiDet) throws Exception{
		Integer rsult=0;
		SqlSession sesion =sqlMapper.openSession();
		try {  
			
			sesion.insert("ii.SQL_registraII",ii);
			SolicitudPedidoDTO ped = (SolicitudPedidoDTO) sesion.selectOne("pedido.SQL_getPedido",ii.getCod_pedido()); 
			ped.setCod_solicitudPedido(ii.getCod_pedido());
			if("Salida".equals(ii.getTipo_informe_interno())){
				if("Abastecimiento".equals(ped.getTipo_pedido())){ 
					ped.setEstado_pedido("Atentido");
				}else{//PRestamo 
					ped.setEstado_pedido("Falta Devolver");
				}
			}else{ 
				ped.setEstado_pedido("Devuelto");
			}
			 
			sesion.update("pedido.SQL_actualizarPedidoEstado",ped);
			for (InformeInternoDetalleDTO  detalleInformeInternoDTO : iiDet) {  
				detalleInformeInternoDTO.setCod_informe_interno(ii.getCod_informe_interno()); 
				DetallePedidoDTO det = (DetallePedidoDTO) sesion.selectOne("pedidodetalle.SQL_getDetallePedido1",
						detalleInformeInternoDTO.getCod_detalle_pedido()); 
				ProductoDTO  objProducto = (ProductoDTO) sesion.selectOne("producto.SQL_getProductoXCodProd",
						det.getCod_producto()); 
				Integer stock=0; 
				if("Salida".equals(ii.getTipo_informe_interno())){
					stock = objProducto.getStock_producto() -  det.getCantidad();
				}else{
					stock = det.getCantidad() + objProducto.getStock_producto();
				}
				
				objProducto.setStock_producto(stock);
				sesion.update("producto.SQL_updateProducto", objProducto);
				sesion.insert("iidetalle.SQL_registraDetalleII",detalleInformeInternoDTO);
			} 
			sesion.commit();
			rsult=1;
		} catch (Exception e) { 
			sesion.rollback();
			sesion.close(); 
			rsult=-1;
		}finally{
			sesion.close();
		} 
		return rsult;
	}

}
