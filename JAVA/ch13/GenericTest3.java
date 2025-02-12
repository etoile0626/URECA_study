package ch13;

public class GenericTest3 {

	public static void main(String[] args) {

		ExtendsType<Person> ext1 = new ExtendsType<>();
//		ExtendsType<Integer> ext2 = new ExtendsType<>(); // error
//		ExtendsType<String> ext3 = new ExtendsType<>(); // error
		ExtendsType<Male> ext4 = new ExtendsType<>();
		ExtendsType<FeMale> ext5 = new ExtendsType<>();

	}

}
