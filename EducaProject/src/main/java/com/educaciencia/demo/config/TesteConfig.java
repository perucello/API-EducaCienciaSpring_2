package com.educaciencia.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaciencia.demo.entities.Category;
import com.educaciencia.demo.entities.Order;
import com.educaciencia.demo.entities.OrderItem;
import com.educaciencia.demo.entities.Payment;
import com.educaciencia.demo.entities.Product;
import com.educaciencia.demo.entities.User;
import com.educaciencia.demo.entities.enums.OrderStatus;
import com.educaciencia.demo.repositories.CategoryRepository;
import com.educaciencia.demo.repositories.OrderItemRepository;
import com.educaciencia.demo.repositories.OrderRepository;
import com.educaciencia.demo.repositories.ProductRepository;
import com.educaciencia.demo.repositories.UserRepository;

@Configuration
@Profile("test") //nome igual ao do Profile para rodar teste no perfil de teste
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Executar quando o Programa for iniciado - implementando classe CommandLine
		//instanciando Objetos e Salvando no Banco de Dados

//Salvar category - categorias
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
				
		//informando qual categoria é de qual produto e Associando os Objetos Categoria/Produto
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
//Salvar as Associações informadas em memoria
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
//Salvar User - usuario
		User u1 = new User(null, "TesteNome1", "teste1@gmail.com", "999999999", "1234");
		User u2 = new User(null, "TesteNome2", "teste2@gmail.com", "888888888", "1234");	
		User u3 = new User(null, "TesteNome3", "teste3@gmail.com", "999999999", "1234");
		User u4 = new User(null, "TesteNome4", "teste4@gmail.com", "888888888", "1234");
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		
//Salvar Order - pedido
		Order o1 = new Order(null, Instant.parse("2020-05-18T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2020-05-19T03:42:10Z"), OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2020-05-19T15:21:22Z"), OrderStatus.WAITTING_PAYMENT, u1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
//Para salvar no BD
		//userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));	
		//orderRepository.saveAll(Arrays.asList(o1, o2, o3));

//salvar ordem item
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
				
		Payment pay1 = new Payment(null, Instant.parse("2020-05-18T20:53:07Z"), o1);
		//para salvar 1-1 nao chama objeto - usa memoria
		o1.setPayment(pay1);
		//salva novamente o pedido - agora com pagamento
		orderRepository.save(o1);
					
		
		
	}
}
