/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :11:46:02 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunctionalInterfacesDemo {

	public static void main(String[] args) {

		// 1️⃣ Predicate<T>
		Predicate<String> isLongName = name -> name.length() > 5;
		System.out.println("Is 'Jonathan' a long name? " + isLongName.test("Jonathan"));
		System.out.println("Is 'Ava' a long name? " + isLongName.test("Ava"));

		Predicate<String> isValidEmail =
				email -> email.contains("@") && email.endsWith(".com");

				System.out.println("\nIs 'test@gmail.com' valid? "
						+ isValidEmail.test("test@gmail.com"));

				// 2️⃣ Function<T, R>
				Function<Integer, Double> convertToDollar =
						rupees -> rupees / 83.0;

						System.out.println("\n₹8300 in dollars = $"
								+ convertToDollar.apply(8300));

						Function<Double, Double> applyDiscount =
								amount -> amount * 0.9;

								System.out.println("After 10% discount: ₹"
										+ applyDiscount.apply(10000.0));

								// 3️⃣ Consumer<T>
								Consumer<String> sendNotification =
										message -> System.out.println("📢 Notification sent: " + message);

										System.out.println();
										sendNotification.accept("Your order has been shipped!");

										Consumer<Customer> printCustomer =
												c -> System.out.println("Customer: "
														+ c.getName() + ", Age: " + c.getAge());

												printCustomer.accept(new Customer("Ravi", 30));

												// 4️⃣ Supplier<T>
												Supplier<String> otpGenerator = () -> {
													int otp = new Random().nextInt(900000) + 100000;
													return "Your OTP is: " + otp;
												};

												System.out.println("\n" + otpGenerator.get());

												// 5️⃣ BiFunction<T,U,R>
												BiFunction<Integer, Integer, Integer> add =
														(a, b) -> a + b;

														System.out.println("\nSum of 15 and 25 = "
																+ add.apply(15, 25));

														BiFunction<Double, Integer, Double> totalBill =
																(price, qty) -> price * qty;

																System.out.println("Total Bill = ₹"
																		+ totalBill.apply(499.99, 3));

																// 6️⃣ BiPredicate<T,U>
																BiPredicate<String, String> startsWith =
																		(word, prefix) -> word.startsWith(prefix);

																		System.out.println("\nDoes 'Programming' start with 'Pro'? "
																				+ startsWith.test("Programming", "Pro"));

																		// 7️⃣ BiConsumer<T,U>
																		BiConsumer<String, Integer> displayItem =
																				(item, qty) -> System.out.println("Item: "
																						+ item + ", Quantity: " + qty);

																				displayItem.accept("Books", 5);
	}
}