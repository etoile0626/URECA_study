package ch13;

public class AllType<T> {

	private T member;

	public AllType() {}

	public AllType(T member) {
		this.member = member;
	}

	public T getMember() {
		return this.member;
	}

	public void setMember(T member) {
		this.member = member;
	}

}
