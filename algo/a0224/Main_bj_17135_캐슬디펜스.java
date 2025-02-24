package a0224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class EnemyClass implements Comparable<EnemyClass> {

	Integer rowNum;//좌표
	Integer colNum;//좌표
	Integer distance;//궁수와의 거리
	boolean deadYN;//사망 여부
	public EnemyClass(int rowNum, int colNum) {
		this.rowNum = rowNum;
		this.colNum = colNum;
	}

	@Override
	public int compareTo(EnemyClass o) {
		if (distance.equals(o.distance)) {//공격 거리가 같다면,
			return this.colNum.compareTo(o.colNum);//컬럼이 죄측인지 여부 검사.
		} else {
			return this.distance.compareTo(o.distance);//공격 거리 가까운 것이 우선 적용이지만,
		}
	}

	@Override
	public String toString() {
		return "["+rowNum+", "+colNum+", "+deadYN+"]";
	}

}//class

//1.입력, 2.궁수위치선정+궁수공격+적이동 반복하며, 최대값구하기.
public class Main_bj_17135_캐슬디펜스 {

	static int rowCnt;
	static int colCnt;
	static int attackRange;
	static int maxDeadMan;
	static int [][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		rowCnt = scan.nextInt();
		colCnt = scan.nextInt();
		attackRange = scan.nextInt();
		map = new int [rowCnt][colCnt];
		for(int a=0; a<map.length; a++) {
			for(int b=0; b<map[a].length; b++) {
				map[a][b] = scan.nextInt();
			}
		} // 입력 완료.

		archerSelect(0, new int[3], 0, 0);

		System.out.println(maxDeadMan);
		scan.close();
	}//main

	public static void archerSelect(
			int archerCnt, int[] allArchers, int archerPoint, int selectInt) {
		if (archerCnt == 3) {//궁수 조합 완료.
			gameTurn(allArchers);
			return;
		}
		for (int i = selectInt; i < colCnt; i++) {
			allArchers[archerPoint] = i;
			archerSelect(archerCnt + 1, allArchers, archerPoint + 1, i + 1);
		}
	} // archerSelect

	/* 게임 진행 */
	public static void gameTurn(int[] allArchers) {
		//System.out.println(Arrays.toString(allArchers));
		List<EnemyClass> allEnemy = new ArrayList<>();
		for(int a=0; a<rowCnt; a++) {
			for(int b=0; b<colCnt; b++) {
				if (map[a][b] == 1) {
					EnemyClass tmpEnemyClass = new EnemyClass(a, b);
					allEnemy.add(tmpEnemyClass);
				}
			}
		}//모든 적 정보 저장.

		int deadMan = 0;
		boolean gameNotEndFlag = true;

		while (gameNotEndFlag) {//게임 턴 진행.
			for (int a = 0; a < allArchers.length; a++) {//모든 궁수가,
				PriorityQueue<EnemyClass> targetedEnemies = new PriorityQueue<>();
				int archer = allArchers[a];
				for (int b = 0; b < allEnemy.size(); b++) {//모든 적에게 대해,
					EnemyClass enemy = allEnemy.get(b);
					enemy.distance
						= Math.abs(archer - enemy.colNum)
							+ Math.abs(rowCnt - enemy.rowNum);
					if (enemy.distance <= attackRange) {//공격 가능 거리 검사.
						targetedEnemies.offer(enemy);//공격 가능 적.
					}
				}//for - allEnemy.size
				if (!targetedEnemies.isEmpty()) {
					targetedEnemies.poll().deadYN = true;//가장 앞의 하나만 사망 처리.
				}
			} // for - allArchers.length

			for (int e = 0; e < allEnemy.size(); e++) {
				EnemyClass enemy = allEnemy.get(e);
				if (enemy.deadYN) {//사망인 경우,
					allEnemy.remove(e--);//사망 처리.//적군 수 감소.
					deadMan++;//사망자 수 증가.
				} else if (enemy.rowNum == rowCnt - 1) {//배열 끝에 도달한 경우,
					allEnemy.remove(e--);//제외 처리.//적군 수 감소.
				} else {
					enemy.rowNum++;//적군 한 칸 전진.
				}
			} // for - allEnemy.size

			if (allEnemy.size() == 0) gameNotEndFlag = false;
		  //적군이 모두 제외된 경우,//게임 종료 처리.
		}//while - 게임 턴 종료.

		maxDeadMan = Math.max(maxDeadMan, deadMan);
	} // gameTurn

} // class
