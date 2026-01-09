package com.sparklink.addressservice.controller;

import java.util.List;
//import javax.transaction.Transactional;
import com.sparklink.addressservice.model.Address_Master;
import com.sparklink.addressservice.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = {"${settings.cors_origin}"})
@CrossOrigin(origins = {"${settings.cors_origin_localhost}", "${settings.cors_origin_localhost_global}", "${settings.cors_origin_client_global}","${settings.cors_origin_localhost_k8s}", "${settings.cors_origin_client_k8s}", "${settings.cors_origin_address_dynamic}", "${settings.cors_origin_address_dynamic_k8s}"})
@RestController

//@RequestMapping(value="/restapiaddressservices")
//@RequestMapping(value="/rest-api-address-services")
@RequestMapping(value={"${rest.request.mapping.rest-api-address-services}"})
public class AddressServiceController {
	
	@Autowired
	private AddressService addressService;


	//********************************* AWS Address Service Blue Green Deployment Start *********************************************//

	//@GetMapping("/getAddressServicesDeployments")
	@GetMapping("${rest.get.mapping.getAddressServicesDeployments}")
	public String getAddressServicesDeployments() {
		return "AWS - Address Services Working Fine ...";
	}


	//********************************* AWS Address Service Blue Green Deployment Start *********************************************//


	//********************************* Address_Master Start *********************************************//

	//@GetMapping("/getAddressServices")
	@GetMapping("${rest.get.mapping.getAddressServices}")
	public String getAddressServices() {
		return "AWS Address Services Working Fine ...";
	}

	//@GetMapping("/callAddressServices")
	@GetMapping("${rest.get.mapping.callAddressServices}")
	public String callAddressServices() {
		return "Address Services Working Fine...";
	}



	// ****************** Calling from FrontController ********************** //

	/*@Transactional
	//@GetMapping("/getAllAddress")
	@GetMapping("${rest.get.mapping.getAllAddress}")
	public List<Address_Master> getAllAddress() {
		return addressService.getAllAddress();
	}

	@Transactional
	//@GetMapping("/getAddressById/{addressId}")
	@GetMapping("${rest.get.mapping.getAddressById}")
	public Address_Master getAddressById(@PathVariable int addressId) {
		return addressService.getAddressById(addressId);
	}
	
	@Transactional
	//@PostMapping("/addAddress")
	@PostMapping("${rest.post.mapping.addAddress}")
	public Address_Master addAddress(@RequestBody Address_Master address) {
		return addressService.addAddress(address);
	}

	@Transactional
	//@PutMapping("/updateAddress")
	@PutMapping("${rest.put.mapping.updateAddress}")
	public void updateAddress(@RequestBody Address_Master address) {
		System.out.println("updateAddress..");
		addressService.updateAddress(address);
	}

	@Transactional
	//@PutMapping("/updateAddressById/{addressId}")
	@PutMapping("${rest.put.mapping.updateAddressById}")
	public void updateAddressById(@RequestBody Address_Master address, @PathVariable int addressId) {
		addressService.updateAddressById(address, addressId);
	}

	@Transactional
	//@DeleteMapping("/deleteAddress/{id}")
	//@GetMapping("/deleteAddress/{addressId}")
	@GetMapping("${rest.get.mapping.deleteAddress}")
	public boolean deleteAddress(@PathVariable int addressId) {
		return addressService.deleteAddress(addressId);
	}
	
	// ****************** @NamedQueries ********************** //
	@Transactional
	//@GetMapping("/getAddressByCity/{city}")
	@GetMapping("${rest.get.mapping.getAddressByCity}")
	public List<Address_Master> getAddressByCity(@PathVariable String city) {
		return addressService.getAddressByCity(city.trim());
	}

	@Transactional
	//@GetMapping("/getAddressByEmployeeIDAddressType/{employeeId}/{addressType}")
	@GetMapping("${rest.get.mapping.getAddressByEmployeeIDAddressType}")
	public List<Address_Master> getAddressByEmployeeIDAddressType(@PathVariable int employeeId, @PathVariable String addressType) {
		return addressService.getAddressByEmployeeIDAddressType(employeeId,addressType);
	}
	
	@Transactional
	//@GetMapping("/getAddressByAddressType/{addressType}")
	@GetMapping("${rest.get.mapping.getAddressByAddressType}")
	public List<Address_Master> getAddressByAddressType(@PathVariable String addressType) {
		return addressService.getAddressByAddressType(addressType);
	}

	// ****************** Calling from FrontController ********************** //


	//------------ Calling from Employee Service --------------------------//
	@Transactional
	//@GetMapping("/getAllAddressEmployeeID")
	@GetMapping("${rest.get.mapping.getAllAddressEmployeeID}")
	public List<Integer> getAllAddressEmployeeID() {
		return addressService.getAllAddressEmployeeID();
	}

	@Transactional
	//@GetMapping("/getAddressByEmployeeID/{employeeId}")
	@GetMapping("${rest.get.mapping.getAddressByEmployeeID}")
	public List<Address_Master> getAddressByEmployeeID(@PathVariable int employeeId) {
		return addressService.getAddressByEmployeeID(employeeId);
	}
	//------------ Calling from Employee Service --------------------------//
*/



	//********************************* Address_Master End *********************************************//
	
	
}
