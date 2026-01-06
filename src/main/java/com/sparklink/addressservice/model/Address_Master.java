package com.sparklink.addressservice.model;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;*/
/*

@NamedQueries(  
	    {  
	        @NamedQuery(  
					        name = "@HQL_Find_Address_By_City",  
					        query = "from Address_Master a where a.permCity = :permCity"
			),
	        @NamedQuery(  
			        name = "@HQL_Find_Address_By_EmployeeID",  
			        query = "from Address_Master a where a.employeeId = :employeeId"
	        ),
	        @NamedQuery(  
			        name = "@HQL_Find_Address_By_EmployeeID_AddressType",  
			        query = "from Address_Master a where a.employeeId = :employeeId and a.addressType = :addressType"
	        ),
	        @NamedQuery(  
			        name = "@HQL_Find_Address_By_AddressType",  
			        query = "from Address_Master a where a.addressType = :addressType"
	        ),
	        @NamedQuery(  
			        name = "@HQL_Get_All_EmployeeID_IN_AddressTable",  
			        query = "Select employeeId from Address_Master"
	        )
	    }  
	)  
*/

//@Entity
//@Table(name="ADDRESS_MASTER")
public class Address_Master {


	//@Id
	//@Column(name="addressId")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;

	//@Column(name="employeeId")
	private int employeeId;

	//@Column(name="permLocality")
	private String permLocality;

	//@Column(name="permCity")
	private String permCity;

	//@Column(name="permState")
	private String permState;

	//@Column(name="permCountry")
	private String permCountry;

	//@Column(name="permZipcode")
	private int permZipcode;

	//@Column(name="currLocality")
	private String currLocality;

	//@Column(name="currCity")
	private String currCity;

	//@Column(name="currState")
	private String currState;

	//@Column(name="currCountry")
	private String currCountry;

	//@Column(name="currZipcode")
	private int currZipcode;

	//@Column(name="addressType")
	private String addressType;


	public Address_Master() {
		super();
	}

	public Address_Master(int addressId, int employeeId, String permLocality, String permCity, String permState, String permCountry, int permZipcode, String currLocality, String currCity, String currState, String currCountry, int currZipcode,String addressType) {
		this.addressId = addressId;
		this.employeeId = employeeId;
		this.permLocality = permLocality;
		this.permCity = permCity;
		this.permState = permState;
		this.permCountry = permCountry;
		this.permZipcode = permZipcode;
		this.currLocality = currLocality;
		this.currCity = currCity;
		this.currState = currState;
		this.currCountry = currCountry;
		this.currZipcode = currZipcode;
		this.addressType = addressType;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPermLocality() {
		return permLocality;
	}

	public void setPermLocality(String permLocality) {
		this.permLocality = permLocality;
	}

	public String getPermCity() {
		return permCity;
	}

	public void setPermCity(String permCity) {
		this.permCity = permCity;
	}

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getPermCountry() {
		return permCountry;
	}

	public void setPermCountry(String permCountry) {
		this.permCountry = permCountry;
	}

	public int getPermZipcode() {
		return permZipcode;
	}

	public void setPermZipcode(int permZipcode) {
		this.permZipcode = permZipcode;
	}

	public String getCurrLocality() {
		return currLocality;
	}

	public void setCurrLocality(String currLocality) {
		this.currLocality = currLocality;
	}

	public String getCurrCity() {
		return currCity;
	}

	public void setCurrCity(String currCity) {
		this.currCity = currCity;
	}

	public String getCurrState() {
		return currState;
	}

	public void setCurrState(String currState) {
		this.currState = currState;
	}

	public String getCurrCountry() {
		return currCountry;
	}

	public void setCurrCountry(String currCountry) {
		this.currCountry = currCountry;
	}

	public int getCurrZipcode() {
		return currZipcode;
	}

	public void setCurrZipcode(int currZipcode) {
		this.currZipcode = currZipcode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}




}
