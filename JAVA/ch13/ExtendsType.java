package ch13;

public class ExtendsType<T extends Person> {

	private T member;

	public T getMember() {
		return member;
	}

	public void setMember(T member) {
		this.member = member;
	}

}
