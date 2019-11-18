package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.service.CustomerInfoMgmtService;

@Controller("ctrl")
public class CustomerOperationController {
	
	
	@Autowired
	private CustomerInfoMgmtService serv;
	// handler method for launching home page
		@RequestMapping("/welcome.htm")
		public String showHome() {
			return "home";
		}

		//this method get/showing all customer details
		@RequestMapping("/all_customers.htm")
		public String getAllCustomers(Map<String, Object> map) {
			List<Customer> listDTO = null;
				listDTO=new ArrayList();
			// use Service
		
				listDTO = serv.fetchAllCustomers();
			// keep results map object
			map.put("listDTO", listDTO);
			// return lvn
			return "list_customers";
		}// method

		@RequestMapping(value = "/delete_customer.htm")
		public String deleteCustomer(HttpServletRequest req, Map<String, Object> map) throws Exception {
			int cno = 0;
			List<Customer> listDTO = null;
			// read additonal req param values
			cno = Integer.parseInt(req.getParameter("cno"));
			// use Service class
			 serv.removeCustomerByNo(cno);
			listDTO = serv.fetchAllCustomers();
			// keep results in Map (model)
			map.put("listDTO", listDTO);
			// return logical View name
			return "list_customers";
		}// method

		// for InitialPahse request and formBackingObject(-,-)
		@RequestMapping(value = "/update_customer.htm", method = RequestMethod.GET)
		public String showUpdateForm(HttpServletRequest req, Map<String, Object> map) {
			int cno = 0;
			Customer dto = null;
			CustomerCommand cmd = null;
			// read customer number from hyperlink
			cno = Integer.parseInt(req.getParameter("cno"));
			// use service
			dto = serv.fetchCustomerByCno(cno);
			// create and Command class obj having dynamic initial values
			cmd = new CustomerCommand();
			BeanUtils.copyProperties(dto, cmd);
			// keep Command class obj as model attribute
			map.put("custCmd", cmd);
			// return form page as lvn
			return "update_customer";

		}

		// for Postback request
		@RequestMapping(value = "/update_customer.htm", method = RequestMethod.POST)
		public String updateCustomer(Map<String, Object> map, @ModelAttribute("custCmd") CustomerCommand cmd,
				BindingResult errors) throws Exception {
			CustomerDTO dto = null;
			List<Customer> listDTO = null;
			ModelAndView mav = null;
			// Convert Command class obj to DTO class obj
			dto = new CustomerDTO();
			dto.setCno(cmd.getCno());
			dto.setCname(cmd.getCname());
			dto.setCadd(cmd.getCadd());
			dto.setMobileNo(cmd.getMobileNo());
			System.out.println(dto.getMobileNo());
			dto.setBillAmt(cmd.getBillAmt());
			// use service
			serv.modifyCustomerByNo(dto);
			listDTO = serv.fetchAllCustomers();
			// create and return MAV obj

			map.put("listDTO", listDTO);
		
			return "list_customers";
		}// method

}
