package com.Package.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Package.Dao.AdminDao;
import com.Package.Entity.Admin;
//import com.bookmymovie.service.HConnect;
//import com.bookmymovie.service.JConnect;
import com.Package.config.AppContext;

@Transactional
@Repository
@Service
public class AdminDaoImpl implements AdminDao {
	
	//@Autowired
	//private HConnect con;
	private AppContext con;
	

	public boolean insert(Admin admin) {

		try {
			
			Session session = (Session) con.sessionFactory();
			Transaction t = session.beginTransaction();
			session.save(admin);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	/*public Admin getAdminById(String adminId) {

		Admin admin=new Admin();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from admin_info where ADMIN_ID='"+adminId+"'");
				while(rs.next()){
					admin.setId(rs.getString("ADMIN_ID"));
					admin.setName(rs.getString("ADMIN_NAME"));
					admin.setGender(rs.getString("ADMIN_GENDER"));
					admin.setPwd(rs.getString("ADMIN_PWD"));
					
				}
				
				return admin;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return admin;
		}
		
	}*/

}
