package ch09;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int d = 0; 
		char [][] map;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};	//상하좌우의 x y 좌표값
		int nx, ny;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int h = sc.nextInt();
			int w = sc.nextInt();	//맵크기
			map = new char[h][w];
			int x = 0;
			int y = 0; //현재 전차 위치
			
			for(int i =0; i<h; i++) {
				String temp = sc.next();
				for(int j =0; j<w;j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j] == '^' || map[i][j] =='v' || map[i][j] == '<' || map[i][j] =='>') {
						if(map[i][j] =='^') {
							d=0;
						}else if(map[i][j] =='v') {
							d=1;
						}else if(map[i][j] =='<') {
							d=2;
						}else if(map[i][j] =='>') {
							d=3;
						}
						x=i;
						y=j;
					}
				}
			}
			int N = sc.nextInt();
			String command = sc.next();
			
			for(int i =0; i<N; i++) {
				char com = command.charAt(i);
				
				if (com == 'U') {					//위로 가기
					map[x][y] = '^';				//방향 변경
					nx = x+dx[d];		
					ny = y+dy[d];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {	//맵을 벗어나면
						continue;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = map[x][y];
						map[x][y] = '.';			//이동할 곳이 평지면(이동 가능하면 이동 후 이전위치 평지로)
					}
				}else if (com == 'D') {				//아래로 가기
					map[x][y] = 'v';				//방향 변경
					nx = x+dx[d];		
					ny = y+dy[d];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {	//맵을 벗어나면
						continue;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = map[x][y];
						map[x][y] = '.';			//이동할 곳이 평지면(이동 가능하면 이동 후 이전위치 평지로)
					}
				}else if (com == 'L') {				//왼쪽으로 가기
					map[x][y] = '<';				//방향 변경
					nx = x+dx[d];		
					ny = y+dy[d];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {	//맵을 벗어나면
						continue;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = map[x][y];
						map[x][y] = '.';			//이동할 곳이 평지면(이동 가능하면 이동 후 이전위치 평지로)
					}
				}else if (com == 'R') {				//오른쪽으로 가기
					map[x][y] = '>';				//방향 변경
					nx = x+dx[d];		
					ny = y+dy[d];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {	//맵을 벗어나면
						continue;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = map[x][y];
						map[x][y] = '.';			//이동할 곳이 평지면(이동 가능하면 이동 후 이전위치 평지로)
					}
				}else if (com == 'S') {				//대포
					int c = 1;
					while(true) {
						nx = x+(dx[d]*c);
						ny = y+(dy[d]*c); //현재 바라보는 방향(d)에 맞게 포탄 위치 조정
						if(nx < 0 || nx >= h || ny < 0 || ny >= w) {	//맵을 벗어나면
							break;
						}
						if (map[nx][ny]=='#') {						//강철을 만나면
							break;
						}
						else if(map[nx][ny]=='*') {					//벽돌을 만나면
							map[nx][ny]='.';
							break;										//들판으로
						}
						c++;
					}
				}
			}
			
			System.out.printf("#%d ", test_case);
			for(int i =0; i<h; i++) {
				for(int j =0; j<w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
