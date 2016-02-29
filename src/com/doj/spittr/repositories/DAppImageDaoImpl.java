package com.doj.spittr.repositories;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.DAppImage;

@Repository
@Transactional
public class DAppImageDaoImpl implements DAppImageDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DAppImage img) {
		DAppImage currImgDetail= getUserImgDetail(img);		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		if(currImgDetail!=null){		
			img.setAppimgid(currImgDetail.getAppimgid());
			img.setModidate(new Date());
			session.update(img);
		}else{
			img.setCreatedate(new Date());
			img.setModidate(new Date());
			session.save(img);
		}
		tx.commit();
		session.close();

	}
	private DAppImage getUserImgDetail(DAppImage dAppImg){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from DAppImage where appimgusrid=:appimgusrid");
		query.setParameter("appimgusrid", dAppImg.getAppimgusrid());
		@SuppressWarnings("unchecked")
		List<DAppImage> dAppImage = query.list();
		if (dAppImage != null && !dAppImage.isEmpty()) {
			session.close();
			return dAppImage.get(0);			
		}
		return null;
	
	}

	public byte[] getImage(Long id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from DAppImage where appimgusrid=:appimgusrid");
		query.setParameter("appimgusrid", id);
		@SuppressWarnings("unchecked")
		List<DAppImage> dAppImage = query.list();
		session.close();
		if (dAppImage != null && !dAppImage.isEmpty()) {
			byte[] bytes;
			try {
				bytes = dAppImage.get(0).getAppimgdata().getBytes(1, (int) dAppImage.get(0).getAppimgdata().length());
				
				return bytes;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
