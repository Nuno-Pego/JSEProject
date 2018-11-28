package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductService {
	
	private static final ProductRepository PRODUCTREPOSITORY = ProductRepository.getInstance();
	
	public static void createProduct(int discount, int iva, double pvp) {
		Product newProduct = new Product(discount, iva, pvp);
		PRODUCTREPOSITORY.save(newProduct);
	}
	
	public static void createProduct (ArrayList<Long> ShelfsIDs, int discount, int iva, double pvp) {
		Product newProduct = new Product(discount, iva, pvp);
		PRODUCTREPOSITORY.save(newProduct);
	}
	
	public static Product getProductById(Long id) {
		Product searchProduct = PRODUCTREPOSITORY.findById(id);
		return searchProduct;
	}
	
	public static void editProduct (Product editProduct) {
		PRODUCTREPOSITORY.save(editProduct);
	}
	
	public static boolean isEmpty() {
		return PRODUCTREPOSITORY.emptyData();
	}
	
	public static Iterator<Product> getAllProducts(){
		return PRODUCTREPOSITORY.findAll();
	}	

	public static Iterator<Long> getAllProductsIDs(){
		return PRODUCTREPOSITORY.getAllIDs();
	}
	
	public static int lengthProducts() {
		return PRODUCTREPOSITORY.lengthData();
	}
	
	public static void removeProduct(long id) {
		PRODUCTREPOSITORY.removeById(id);
	}
}
