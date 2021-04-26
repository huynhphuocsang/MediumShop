package com.sang.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.SanPhamImp;
import com.sang.entity.ChiTietSanPham;
import com.sang.entity.SanPham;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory; 
	
	@Transactional
	public List<SanPham> getListProduct() {
		
		Session session = sessionFactory.getCurrentSession(); 
		String sql ="from sanpham"; 
		List<SanPham> listProduct  = session.createQuery(sql).getResultList(); 
		return listProduct; 
	}


	@Transactional
	public SanPham getSpecificProduct(int id) {
		String sql = "from sanpham where masanpham='"+id+"'"; 
		Session session = sessionFactory.getCurrentSession(); 
		SanPham sanpham = (SanPham) session.createQuery(sql).getSingleResult(); 
		return sanpham; 
	}


	@Transactional
	public List<SanPham> getListProductViaCategory(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		String sql = "from sanpham where madanhmuc="+id; 
		List<SanPham> listProduct = session.createQuery(sql).getResultList(); 
		return listProduct;
	}

	@Transactional
	public List<SanPham> getLimitProduct(int startIndex, int maxRow) {
		Session session = sessionFactory.getCurrentSession(); 
		String sql ="from sanpham"; 
		List<SanPham> listProduct = session.createQuery(sql).setFirstResult(startIndex).setMaxResults(maxRow).getResultList();
		return listProduct; 
	}

	@Transactional
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		SanPham sanpham = getSpecificProduct(id); 
		Set<ChiTietSanPham> danhSachChiTietSanPhams = sanpham.getDanhsachchitietsanpham(); 
		
		
		
		String sqlChiTietHoaDon ="delete chitiethoadon where machitietsanpham ="; 
		for(ChiTietSanPham chitietsanpham: danhSachChiTietSanPhams) {
			session.createQuery(sqlChiTietHoaDon+chitietsanpham.getMachitietsanpham()).executeUpdate(); 
		}
		
		String sqlChitietSanPham = "delete chitietsanpham where masanpham="+id; 
		session.createQuery(sqlChitietSanPham).executeUpdate(); 
		

		String sqlSanPham = "delete sanpham where masanpham="+id;
		
		session.createQuery(sqlSanPham).executeUpdate(); 
		
	}

	@Transactional
	public int addProduct(SanPham sp) {
		Session session = sessionFactory.getCurrentSession(); 
		int id = (Integer) session.save(sp); 
		return id; 
	}

	
	
	@Transactional
	public int updateProduct(SanPham sp) {
		
		Session session = sessionFactory.getCurrentSession(); 

		int masanpham = sp.getMasanpham(); 
//		String sqldelete = "delete chitietsanpham where masanpham="+masanpham; 
//		
//		session.createQuery(sqldelete).executeUpdate(); 
		
		for(ChiTietSanPham chitietsanpham: sp.getDanhsachchitietsanpham()) {
			session.update(chitietsanpham);
		}
		
		String sql = "from sanpham where masanpham='"+sp.getMasanpham()+"'"; 
		SanPham spUpdate = (SanPham) session.createQuery(sql).getSingleResult(); 
 
		System.out.println("masanphamla: "+spUpdate.getMasanpham());
		spUpdate.setDanhmucsanpham(sp.getDanhmucsanpham());
		spUpdate.setDanhsachchitietsanpham(sp.getDanhsachchitietsanpham());
		spUpdate.setGianhcho(sp.getGianhcho());
		spUpdate.setGiatien(sp.getGiatien());
		spUpdate.setMota(sp.getMota());
		spUpdate.setTensanpham(sp.getTensanpham());
		session.update(spUpdate);
		return 1;
	}



	
	
}




















