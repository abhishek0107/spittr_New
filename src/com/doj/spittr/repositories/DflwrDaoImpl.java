/**
 * 
 */
package com.doj.spittr.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doj.spittr.entities.Dflwr;
import com.doj.spittr.entities.Dusr;

/**
 * @author Abhishek
 *
 * 
 */
@Repository
@Transactional
public class DflwrDaoImpl implements DflwrDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	DAppImageDao dAppImageDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Dusr> getAllUser(@ModelAttribute("loginUser") Dusr loginUsr) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Dusr");
		return query.list();

	}

	@Override
	public void follow(@ModelAttribute("loginUser") Dusr loginUsr, String followingId) {
		Dflwr flwr = null;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		flwr = new Dflwr();
		flwr.setCreatedate(new Date());
		flwr.setFollowerId(Long.parseLong(followingId));
		flwr.setFlwrusrid(loginUsr.getUsrid());
		flwr.setModidate(new Date());
		session.save(flwr);
		tx.commit();
		session.close();

	}

	@Override
	public List<Dusr> getAllUserFollwoedByLoginUser(@ModelAttribute("loginUser") Dusr loginUsr) {
		String ids = "";
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("SELECT flwrusrid from Dflwr WHERE followerid=:usrid");
		query.setParameter("usrid", loginUsr.getUsrid());
		@SuppressWarnings("unchecked")
		List<Long> dflwr = query.list();
		session.close();
		if (dflwr != null && !dflwr.isEmpty()) {
			for(Long usr:dflwr){
				ids =ids+usr.toString();
			}
			return followerDetailByUsrId(ids);
		}

		return null;
	}

	/*private static boolean isContain(String source, String subItem) {
		String pattern = "\\b" + subItem + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		return m.find();
	}*/

	@SuppressWarnings("unchecked")
	private List<Dusr> followerDetailByUsrId(String ids) {
		if (ids.length() > 0) {
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("from Dusr WHERE usrid in(" + ids + ")");

			List<Dusr> allUsr = query.list();
			session.close();
//			List<Dusr> temp= new ArrayList<Dusr>();
			if (allUsr != null && !allUsr.isEmpty()) {
				/*for (Dusr o : allUsr) {
					String encodedString = "";
					byte b[] = dAppImageDao.getImage(o.getUsrid());
					if (b != null && b.length > 0) {
						byte[] encoded = Base64.encodeBase64(b);
						encodedString = new String(encoded);
					}
					Dusr usr = new Dusr();
					usr=(Dusr)o;
					usr.setUsrImg(encodedString);
					temp.add(usr);
				}*/
				return allUsr;
			}
		}

		return null;
	}

	@Override
	public List<Dusr> getMyFollower(@ModelAttribute("loginUser") Dusr loginUsr) {
		String ids = "";
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("SELECT followerId FROM Dflwr WHERE flwrusrid=:USRID");
		query.setParameter("USRID", loginUsr.getUsrid());
		@SuppressWarnings("unchecked")
		List<Long> followerList = query.list();
		if (followerList != null && !followerList.isEmpty()) {
			for (Long itrDflwr : followerList) {
				ids = ids + itrDflwr.toString();
			}

			session.close();
			return followerDetailByUsrId(ids);
		}
		return null;

	}

}
