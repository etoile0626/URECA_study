package ch15;

public class TreeMapObj implements Comparable<TreeMapObj>{ //이부분이랑
	
	public Integer key;
	
	public TreeMapObj(Integer key) {
		this.key = key;
	}
	
	@Override
	public int compareTo(TreeMapObj injectObj) {		//이거 없으면 TreeMapTest에서 오류남
		return this.key.compareTo(injectObj.key);	//key 변수를 중심으로 정렬처리, Integer 타입에 있는compareTo 메소드 활용한거임 저거 없으면 if문으로 굴려야함
	}
	
	@Override
	public String toString() {
		return key.toString();
	}
}
