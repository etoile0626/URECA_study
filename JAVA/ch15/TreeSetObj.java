package ch15;

public class TreeSetObj implements Comparable<TreeSetObj>{
	
	Integer iNum;
	public TreeSetObj(int iNum){
		this.iNum = iNum;
	}
	
	@Override
	public String toString() {
		return iNum.toString();
	}
	
	@Override
	public int compareTo(TreeSetObj injectObj) {
		
		//return this.iNum.compareTo(injectObj.iNum);//인티저 값을 비교하는 경우
		if(this.iNum > injectObj.iNum) {
			return 1;
		}else if(this.iNum < injectObj.iNum) {
			return -1;
		}
		return 0;
	}
}
