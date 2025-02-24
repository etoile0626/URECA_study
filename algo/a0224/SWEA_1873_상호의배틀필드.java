package a0224;

import java.util.Scanner;

// 시뮬레이션
public class SWEA_1873_상호의배틀필드 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();
		for(int tc = 1; tc <= testCase; tc++) {

			int sizeX = scan.nextInt();
			int sizeY = scan.nextInt();
			char [][] arr = new char [sizeX][sizeY];
			for(int a=0; a<arr.length; a++) {
				arr[a] = scan.next().toCharArray();
			} // for

			char [] arrCmd = scan.next().toCharArray();
			int x = 0, y = 0;
			char cmd = '0';

			for(int a=0; a<arr.length; a++) {
				for(int b=0; b<arr[a].length; b++) {
					if(arr[a][b] == '^' || arr[a][b] == 'v'
						|| arr[a][b] == '<' || arr[a][b] == '>') {
						x = a; y = b;
						cmd = arr[a][b];
						System.out.printf("a : %d, b : %d, cmd : %c\n", a, b, cmd);
					} // if
				} // for
			} // for - find start x/y

			for(int a=0; a<arrCmd.length; a++) {
				if(arrCmd[a] == 'S') {
					if(arr[x][y] == '^') {
						for(int c=1; c<sizeX; c++) {
							if(x - c < 0 || arr[x-c][y] == '#') {
								break;
							} else if(arr[x-c][y] == '*') {
								arr[x-c][y] = '.';
								break;
							}
						} // for
					} else if(arr[x][y] == 'v') {
						for(int c=1; c<sizeX; c++) {
							if(x + c >= sizeX || arr[x+c][y] == '#') {
								break;
							} else if(arr[x+c][y] == '*') {
								arr[x+c][y] = '.';
								break;
							}
						} // for
					} else if(arr[x][y] == '>') {
						for(int c=1; c<sizeY; c++) {
							if(y + c >= sizeY || arr[x][y+c] == '#') {
								break;
							} else if(arr[x][y+c] == '*') {
								arr[x][y+c] = '.';
								break;
							}
						} // for
					} else if(arr[x][y] == '<') {
						for(int c=1; c<sizeY; c++) {
							if(y - c < 0 || arr[x][y-c] == '#') {
								break;
							} else if(arr[x][y-c] == '*') {
								arr[x][y-c] = '.';
								break;
							}
						} // for
					}
				} // if(arrCmd[a] == 'S')
				else if(arrCmd[a] == 'U') {
					if(x - 1 >= 0 && arr[x-1][y] == '.') {
						arr[x-1][y] = '^'; arr[x][y] = '.'; x = x - 1;
					} else {
						arr[x][y] = '^';
					}
				} // if(arrCmd[a] == 'U')
				else if(arrCmd[a] == 'D') {
					if(x + 1 < sizeX && arr[x+1][y] == '.') {
						arr[x+1][y] = 'v'; arr[x][y] = '.'; x = x + 1;
					} else {
						arr[x][y] = 'v';
					}
				} // if(arrCmd[a] == 'D')
				else if(arrCmd[a] == 'R') {
					if(y + 1 < sizeY && arr[x][y+1] == '.') {
						arr[x][y+1] = '>'; arr[x][y] = '.'; y = y + 1;
					} else {
						arr[x][y] = '>';
					}
				} // if(arrCmd[a] == 'R')
				else if(arrCmd[a] == 'L') {
					if(y - 1 >= 0 && arr[x][y-1] == '.') {
						arr[x][y-1] = '<'; arr[x][y] = '.'; y = y - 1;
					} else {
						arr[x][y] = '<';
					}
				} // if(arrCmd[a] == 'L')
			} // for(int a=0; a<arrCmd.length; a++)

			System.out.print("#"+tc+" ");
			for(int a=0; a<arr.length; a++) {
				for(int b=0; b<arr[a].length; b++) {
					System.out.print(arr[a][b]);
				} // for
				System.out.println();
			} // for

		} //for tc

		scan.close();
	} // main

} // class

/*
1
3 7
***....
*-..#**
#<.****
23
SURSSSSUSLSRSSSURRDSRDS
*/
