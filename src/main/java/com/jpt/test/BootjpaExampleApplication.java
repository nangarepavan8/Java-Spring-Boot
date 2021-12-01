package com.jpt.test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpt.test.dao.UserReposiratory;
import com.jpt.test.entities.User;

@SpringBootApplication
public class BootjpaExampleApplication {

//	private static User save;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaExampleApplication.class, args);

		UserReposiratory userReposiratory = context.getBean(UserReposiratory.class);

		User user = new User();
		/*
		 * // user.setId(1); autoincrement so no need
		 * user.setName("Pavan Sambhaji Nangare-Patil"); user.setCity("Pune");
		 * user.setStatus("Im a JAVA Developer ..!!");
		 * 
		 * User user1 = userReposiratory.save(user);
		 * 
		 * System.out.println(user1);
		 * 
		 */

		// create Object of user
		/*
		 * User user1 = new User(); user1.setName("sai"); user1.setCity("Shirdi");
		 * user1.setStatus(" worlds good ");
		 * 
		 * User user2 = new User(); user2.setName("Shiv"); user2.setCity("Kedarnath");
		 * user2.setStatus(" Bum Bum Bhole  ..! ");
		 * 
		 * // User resultUser = userReposiratory.save(user2); // pass two users at a
		 * time // use list.of
		 * 
		 * List<User> users = List.of(user1, user2); // (control + 2) + L Iterable<User>
		 * result = userReposiratory.saveAll(users); // save multiple objects
		 * 
		 * 
		 * result.forEach(User -> { System.out.println(User); });
		 * 
		 * // System.out.println(" Saved User" + resultUser);
		 * System.out.println("done");
		 */
		/*
		 * // update the user of id 4
		 * 
		 * Optional<User> optional = userReposiratory.findById(4); User users1 =
		 * optional.get();
		 * 
		 * System.out.println(users1);
		 * 
		 * users1.setName("Ganesh" );
		 * 
		 * User result = userReposiratory.save(users1); System.out.println(result);
		 */

		/*
		 * // find all
		 * 
		 * Iterable<User> itrator = userReposiratory.findAll();
		 * 
		 * itrator.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) {
		 * 
		 * System.out.println(t);
		 * 
		 * } });
		 */
		/*
		 * // find all using lamba Iterable<User> itrator = userReposiratory.findAll();
		 * 
		 * itrator.forEach(User-> { System.out.println(User); });
		 */

		/*
		 * // Delete the content
		 * 
		 * userReposiratory.deleteById(4); System.out.println("Deleted");
		 * 
		 */

//		find by 

		List<User> users = userReposiratory.findByName("shiv");

		users.forEach(a -> {
			System.out.println(a);
		});
	}

}
