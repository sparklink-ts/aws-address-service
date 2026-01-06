package com.sparklink.addressservice.repository;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
/*import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sparklink.addressservice.exception.AddressInfoByCityNotFoundException;
import com.sparklink.addressservice.exception.AddressInfoByIDNotFoundException;
import com.sparklink.addressservice.exception.NoAddressDataFoundException;
import com.sparklink.addressservice.model.Address_Master;
import com.sparklink.addressservice.exception.RecordNotFoundNullPointerException;


@Repository
public class AddressRepository {
	
	/*@Autowired
	SessionFactory sessionFactory;
	
	private String message ="";
	private Boolean matched = false;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ****************** Calling from FrontController ********************** //

	@SuppressWarnings("unchecked")
	public List<Address_Master> getAllAddress() {
		List<Address_Master> addressList = null;

		Session session = this.sessionFactory.getCurrentSession();
		try {
			addressList = session.createQuery("from Address_Master").list();
		}catch(NoAddressDataFoundException naf) {
			naf.printStackTrace();
		}catch(RecordNotFoundNullPointerException rnfnpe) {
			rnfnpe.printStackTrace();
		}finally {
			//session.close();
		}

		return addressList; //= getAllAddressByEmployeeIDList();
	}

	@SuppressWarnings("unchecked")
	public List<Address_Master> getAllAddressByEmployeeIDList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Address_Master> addressList = null;
		String strQuery = "from Address_Master where employee_id in (1000,1001,1034)";
		try {
			addressList = session.createQuery(strQuery).list();
		}catch(NoAddressDataFoundException naf) {
			naf.printStackTrace();
		}catch(RecordNotFoundNullPointerException rnfnpe) {
			rnfnpe.printStackTrace();
		}finally {
			//session.close();
		}
		return addressList;
	}




	public Address_Master getAddressById(int address_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address_Master address = null;
		try {
			address = session.get(Address_Master.class, address_id);
		}catch(AddressInfoByIDNotFoundException aibIDnf) {
			aibIDnf.printStackTrace();
		}catch(RecordNotFoundNullPointerException rnfnpe) {
			rnfnpe.printStackTrace();
		}finally {
			//session.close();
		}
		
		return address;
	}
	
	public Address_Master addAddress(Address_Master address) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
		Serializable savedAddressId = session.save(address);
		if(savedAddressId != null)
			System.out.println("Saved Address ID :: " + savedAddressId);
		else
			System.out.println("Address Record Not Saved... ");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	@Transactional
	public void updateAddress(Address_Master address) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(address);
		session.update(address);
	}

	@Transactional
	public void updateAddressById(Address_Master address, int address_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(address);
		session.saveOrUpdate(String.valueOf(address_id), address);
	}

	public boolean deleteAddress(int address_id) {
		Session session = this.sessionFactory.getCurrentSession();
		//Transaction transaction = session.beginTransaction();
		Address_Master address_master = (Address_Master) session.get(Address_Master.class, address_id);
		
		try {
			if (address_master != null) {
				matched = true;
				System.out.println(address_master.getAddressId());
				session.delete(address_master);
				message = "Deleted Address Record is:" + " \n" + "Address ID: " + address_master.getAddressId() + "  City: " + address_master.getPermCity() + "  Country: " + address_master.getPermCountry() + "  State: " + address_master.getPermState() + "  Locality: " + address_master.getPermLocality() + "  Zipcode: " + address_master.getPermZipcode() + "  Address ID: " + address_master.getAddressId() + "\n";
			}else{
				matched = false;
				message = "Address with ID : " + address_id + " not found....";
			}
		}catch(AddressInfoByIDNotFoundException enf) {
			enf.printStackTrace();
		}finally {
			//transaction.commit();
		}
		
		System.out.println("Delete message :: " + message);
		return matched;
	}
	
	
	
	
	// ****************** @NamedQueries ********************** //
	@SuppressWarnings("unchecked")
	public List<Address_Master> getAddressByCity(String permCity) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;
		//Optional<Address> addressOptional = null;
		List<Address_Master> addressList= null;
		
		try {
				query = session.getNamedQuery("@HQL_Find_Address_By_City");
				query.setParameter("permCity", permCity);
				System.out.println("Named Query is : " + query.getQueryString());
				
				addressList = (List<Address_Master>) query.list().stream().collect(Collectors.toList());
				//addressList = session.createQuery(query.toString()).list();
				
				if(addressList.isEmpty())
					addressList = null;
		}catch(AddressInfoByCityNotFoundException aibcnfe) {
			aibcnfe.printStackTrace();
		}finally {
			//session.close();
		}
		
		return addressList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Address_Master> getAddressByEmployeeIDAddressType(int employee_id, String address_type) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;
		//Optional<Address> addressOptional = null;
		List<Address_Master> addressList= null;
		
		try {
				query = session.getNamedQuery("@HQL_Find_Address_By_EmployeeID_AddressType");
				query.setParameter("employee_id", employee_id);
				query.setParameter("address_type", address_type);
				System.out.println("Named Query is : " + query.getQueryString());
				
				addressList = (List<Address_Master>) query.list().stream().collect(Collectors.toList());
				//addressList = session.createQuery(query.toString()).list();
				
				if(addressList.isEmpty())
					addressList = null;
		}catch(AddressInfoByCityNotFoundException aibcnfe) {
			addressList = null;
			aibcnfe.printStackTrace();
		}finally {
			//session.close();
		}
		
		return addressList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Address_Master> getAddressByAddressType(String address_type) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;
		//Optional<Address> addressOptional = null;
		List<Address_Master> addressList= null;
		
		try {
				query = session.getNamedQuery("@HQL_Find_Address_By_AddressType");
				query.setParameter("address_type", address_type);
				System.out.println("Named Query is : " + query.getQueryString());
				
				addressList = (List<Address_Master>) query.list().stream().collect(Collectors.toList());
				//addressList = session.createQuery(query.toString()).list();
				
				if(addressList.isEmpty())
					addressList = null;
		}catch(AddressInfoByCityNotFoundException aibcnfe) {
			aibcnfe.printStackTrace();
		}finally {
			//session.close();
		}
		
		return addressList;
	}
	
	// ****************** Calling from FrontController ********************** //

	//------------ Calling from Employee Service --------------------------//

	@SuppressWarnings("unchecked")
	public List<Integer> getAllAddressEmployeeID() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Integer> employeeIDList = null;
		try {
			employeeIDList = session.createQuery("Select employeeId from Address_Master").list();
		}catch(NoAddressDataFoundException naf) {
			naf.printStackTrace();
		}catch(RecordNotFoundNullPointerException rnfnpe) {
			rnfnpe.printStackTrace();
		}finally {
			//session.close();
		}
		return employeeIDList;
	}

	@SuppressWarnings("unchecked")
	public List<Address_Master> getAddressByEmployeeID(int employee_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;
		//Optional<Address> addressOptional = null;
		List<Address_Master> addressList= null;

		try {
			query = session.getNamedQuery("@HQL_Find_Address_By_EmployeeID");
			query.setParameter("employeeId", employee_id);
			System.out.println("Named Query is : " + query.getQueryString());

			addressList = (List<Address_Master>) query.list().stream().collect(Collectors.toList());
			//addressList = session.createQuery(query.toString()).list();

			if(addressList.isEmpty())
				addressList = null;
		}catch(AddressInfoByCityNotFoundException aibcnfe) {
			aibcnfe.printStackTrace();
		}finally {
			//session.close();
		}

		return addressList;
	}
	//------------ Calling from Employee Service --------------------------//
*/


}
