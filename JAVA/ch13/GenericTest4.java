package ch13;

public class GenericTest4 {

	public static void main(String[] args) {

		KeyValType<Integer, String> test = new KeyValType<>();

		test.setKey(777);
		test.setValue("행운의 수");
		System.out.println(test.toString());

	}

}
