package com.example.produit;

import com.example.produit.model.Produit;
import com.example.produit.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class ProduitApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	//Test pour la création d'un produit
	@Test
	public void testCreateProduit(){
		Produit prod= new Produit("Mac Mini",2200.500, new Date(2022,03,15));
		produitRepository.save(prod);
	}

	//Test pour trouver un produit dans la bd
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(3L).get();
		System.out.println(p);
	}

	//Test pour update un produit
	@Test
	public void testUpdateProduit(){
		Produit p = produitRepository.findById(3L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);
	}

	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(3L);
	}

	@Test
	public void testFindAllProduits(){
		List<Produit> prods= produitRepository.findAll();
		for (Produit p:prods)
			System.out.println(p);
	}


}
