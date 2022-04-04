package com.algo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algo.model.CustomerRegistrationForm;
import com.algo.model.LoginModel;
import com.algo.model.ProductModel;
import com.algo.model.SellerRegistrationForm;
import com.algo.service.CustomerService;
import com.algo.service.ProductService;
import com.algo.service.SellerService;
import com.algo.validator.AddProductFormValidator;
import com.algo.validator.CustomerRegistrationFormvalidator;
import com.algo.validator.SellerRegistrationFormvalidator;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRegistrationFormvalidator customerRegistrationFormvalidator;
	@Autowired
	private AddProductFormValidator addProductFormValidator;
	@Autowired
	HttpSession session;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/customer-register")
	public String customerRegistrationForm(Model model) {
		model.addAttribute("customerRegistration", new CustomerRegistrationForm());
		return "customerRegistrationForm";
	}

	@RequestMapping(value = "/customer-register", method = RequestMethod.POST)
	public String sellerRegistrationFormtoDB(
			@ModelAttribute("customerRegistration") CustomerRegistrationForm customerRegistration, BindingResult errors,
			Model model) {
		customerRegistrationFormvalidator.validate(customerRegistration, errors);
		if (errors.hasErrors())
			return "customerRegistrationForm";
		customerService.saveCustomer(customerRegistration);
		model.addAttribute("isCustomerCreated", true);
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("customerCreatedMessage", "Customer Account Created Successfully");
		return "customerlogin";
	}

	@RequestMapping(value = "/customer-login")
	public String customerLogin(@ModelAttribute("loginModel") LoginModel loginModel) {
		return "customerlogin";
	}

	@RequestMapping(value = "/customer-login-validate", method = RequestMethod.POST)
	public String userLoginValidate(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		CustomerRegistrationForm customer = customerService.getCustomerCredentials(loginModel);
		if (customer != null) {
			if (customerService.validateCustomerCredentials(loginModel)) {
				session.setAttribute("userName", loginModel.getUserId());
				model.addAttribute("isValidUser", true);
				model.addAttribute("validUser", " Logged in successfully");
				return "customerSuccess";
			}
			model.addAttribute("inValidUser", true);
			model.addAttribute("inValidUser", " you have Entered Invalid Credentials");
			return "customerLogin";
		}
		model.addAttribute("inValidUser", true);
		model.addAttribute("userName", loginModel.getUserId());
		model.addAttribute("invalidUser", " Invalid Credentials");
		return "customerlogin";
	}

	@RequestMapping(value = "/customer-logout")
	public String customerLogout() {
		return "redirect:/customer-login";
	}

	
	

	@RequestMapping(value = "/view-all-productss")
	public String allProductCustomer(Model model) {
		List<ProductModel> allProducts = productService.getAllProduct();
		if (!allProducts.isEmpty()) {
			model.addAttribute("allProductsList", allProducts);
			model.addAttribute("isAllProductsList", true);
			return "customerSuccess";
		}
		model.addAttribute("allProductListEmpty", true);
		return "customerSuccess";
	}
	
	
	@RequestMapping(value="/product-search")
	public String productSearch(@ModelAttribute("productModel") ProductModel productModel,Model model) {
		model.addAttribute("productsearch", true);
		return "customerSuccess";
	}
	@RequestMapping(value="/product-search1")
	public String productsearch1(@RequestParam("proCategory") String proCategory,@ModelAttribute("productModel") ProductModel productModel, Model model ) {
		model.addAttribute("proCategory",proCategory);
		
		if (proCategory.contentEquals("Electronics")) {
			model.addAttribute("isElectronics",true);
			model.addAttribute("product-search2", true);
			return "customerSuccess";
		}
		if (proCategory.contentEquals("Clothing")) {
			model.addAttribute("isClothing",true);
			model.addAttribute("product-search2", true);
			return "customerSuccess";
		}
		if (proCategory.contentEquals("Groceries")) {
			model.addAttribute("isGroceries",true);
			model.addAttribute("product-search2", true);
			return "customerSuccess";
		}
		
		return "customerSuccess";
	}
	
	@RequestMapping(value="product-search2")
	public String searchProduct(@RequestParam("proType") String proType,@ModelAttribute("productModel") ProductModel productModel, Model model ) {
		
		List<ProductModel> searchProducts = productService.getProducts(proType);
		if (!searchProducts.isEmpty()) {
			model.addAttribute("searchProductsList", searchProducts);
			model.addAttribute("searchList", true);
			return "customerSuccess";
		}
		model.addAttribute("searchListempty", true);
		return "customerSuccess";
		
		
	}
	
	

}