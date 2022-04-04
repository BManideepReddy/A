package com.algo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algo.model.LoginModel;
import com.algo.model.ProductModel;
import com.algo.model.SellerRegistrationForm;
import com.algo.service.ProductService;
import com.algo.service.SellerService;
import com.algo.validator.AddProductFormValidator;
import com.algo.validator.SellerRegistrationFormvalidator;

@Controller
public class SellerController {
	@Autowired
	private SellerRegistrationFormvalidator sellerRegistrationFormvalidator;
	@Autowired
	private AddProductFormValidator addProductFormValidator;
	@Autowired
	HttpSession session;

	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/seller-register")
	public String sellerRegistrationForm(Model model) {
		model.addAttribute("sellerRegistration", new SellerRegistrationForm());
		return "sellerRegistrationForm";
	}

	@RequestMapping(value = "/seller-register", method = RequestMethod.POST)
	public String sellerRegistrationFormtoDB(
			@ModelAttribute("sellerRegistration") SellerRegistrationForm sellerRegistration, BindingResult errors,
			Model model) {
		sellerRegistrationFormvalidator.validate(sellerRegistration, errors);
		if (errors.hasErrors())
			return "sellerRegistrationForm";
		sellerService.saveSeller(sellerRegistration);
		model.addAttribute("isSellerCreated", true);
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("sellerCreatedMessage", "Seller Account Created Successfully");
		return "sellerlogin";
	}

	@RequestMapping(value = "/seller-login")
	public String sellerLogin(@ModelAttribute("loginModel") LoginModel loginModel) {
		return "sellerlogin";
	}

	@RequestMapping(value = "/seller-login-validate", method = RequestMethod.POST)
	public String userLoginValidate(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		SellerRegistrationForm seller = sellerService.getSellerCredentials(loginModel);
		if (seller != null) {
			if (sellerService.validateSellerCredentials(loginModel)) {
				session.setAttribute("userName", loginModel.getUserId());
				model.addAttribute("isValidUser", true);
				model.addAttribute("validUser", " Logged in successfully");
				return "sellerSuccess";
			}
			model.addAttribute("inValidUser", true);
			model.addAttribute("inValidUser", " you have Entered Invalid Credentials");
			return "sellerLogin";
		}
		model.addAttribute("inValidUser", true);
		model.addAttribute("userName", loginModel.getUserId());
		model.addAttribute("invalidUser", " Invalid Credentials");
		return "sellerlogin";
	}

	@RequestMapping(value = "/seller-logout")
	public String sellerLogout() {
		return "redirect:/seller-login";
	}

	@RequestMapping(value = "/addproduct-service")
	public String proAddService(@ModelAttribute("productModel") ProductModel productModel, Model model) {
		model.addAttribute("isAddProductService", true);
		return "sellerSuccess";
	}

	@RequestMapping(value = "/addProduct-service", method = RequestMethod.POST)
	public String postAddProductServiceClick(@ModelAttribute("productModel") ProductModel productModel, Model model,
			BindingResult errors) {
		addProductFormValidator.validate(productModel, errors);
		if (!errors.hasErrors()) {
			productService.saveProduct(productModel);
			model.addAttribute("isAdded", true);
			model.addAttribute("AddedMessage", "Successfully Added");
			model.addAttribute("isAddProductService", true);
			model.addAttribute("productModel", new ProductModel());
			return "sellerSuccess";
		}
		model.addAttribute("isAddProductService", true);
		return "sellerSuccess";
	}
	@RequestMapping(value="/myproducts")
	public String myProducts(Model model) {
		String sellerName = (String) session.getAttribute("userName");
		List<ProductModel> myProducts = productService.getAllSellerProducts(sellerName);
		if (!myProducts.isEmpty()) {
			model.addAttribute("myProductsList", myProducts);
			model.addAttribute("ismyProductsList", true);
			return "sellerSuccess";
		}
		model.addAttribute("myProductsListEmpty", true);
		return "sellerSuccess";
	}

	@RequestMapping(value = "/view-all-products")
	public String allProducts(Model model) {
		List<ProductModel> allProducts = productService.getAllProduct();
		if (!allProducts.isEmpty()) {
			model.addAttribute("allProductsList", allProducts);
			model.addAttribute("isAllProductsList", true);
			return "sellerSuccess";
		}
		model.addAttribute("allProductListEmpty", true);
		return "sellerSuccess";
	}
	
	
	
	
	

	@RequestMapping(value="/product-search00")
	public String productSearch(@ModelAttribute("productModel") ProductModel productModel,Model model) {
		model.addAttribute("productsearch", true);
		return "sellerSuccess";
	}
	@RequestMapping(value="/product-search11")
	public String productsearch1(@RequestParam("proCategory") String proCategory,@ModelAttribute("productModel") ProductModel productModel, Model model ) {
		model.addAttribute("proCategory",proCategory);
		
		if (proCategory.contentEquals("Electronics")) {
			model.addAttribute("isElectronics",true);
			model.addAttribute("product-search22", true);
			return "sellerSuccess";
		}
		if (proCategory.contentEquals("Clothing")) {
			model.addAttribute("isClothing",true);
			model.addAttribute("product-search22", true);
			return "sellerSuccess";
		}
		if (proCategory.contentEquals("Groceries")) {
			model.addAttribute("isGroceries",true);
			model.addAttribute("product-search22", true);
			return "sellerSuccess";
		}
		
		return "sellerSuccess";
	}
	
	@RequestMapping(value="product-search22")
	public String searchProduct(@RequestParam("proType") String proType,@ModelAttribute("productModel") ProductModel productModel, Model model ) {
		
		List<ProductModel> searchProducts = productService.getProducts(proType);
		if (!searchProducts.isEmpty()) {
			model.addAttribute("searchProductsList", searchProducts);
			model.addAttribute("searchList", true);
			return "sellerSuccess";
		}
		model.addAttribute("searchListempty", true);
		return "sellerSuccess";
		
		
	}
	

	
	

}