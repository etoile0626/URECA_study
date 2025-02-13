package a0213;

import java.util.*;

// kmp
public class Main_bj_1786_찾기_정답 {
	static char[] T, P;
	static int[] F;

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		T=sc.nextLine().toCharArray();
		P=sc.nextLine().toCharArray();
		F=new int[P.length];

		for(int t=1, p=0; t<P.length; t++){

			while(p>0 && P[t]!=P[p]) p=F[p-1];

			if(P[t]==P[p]) F[t]= ++p;
		} // for

//		System.out.println(Arrays.toString(F));

		List<Integer> ans=new ArrayList<Integer>();

		for(int t=0, p=0; t<T.length; t++){

//			System.out.printf("t : %d, p : %d, T[t] : %c, P[p] : %c\n", t, p, T[t], P[p]);

			while(p>0 && T[t]!=P[p]) p=F[p-1];

			if(T[t]==P[p]){
				if(p==P.length-1){
					ans.add(t-p+1);
					p=F[p];
				} else ++p;
			} // if

		} // for

		for(int p:ans) System.out.print(p+" ");
		sc.close();
	}

}

/*
 * KMP
 * ABCDABD
 *  ABCDABD ---> 0 0 ---> B와 A가 불일치면, 한칸 이동 후 0번지부터 다시 비교.
 * ABCDABD
 *   ABCDABD ---> 0 0 0 ---> C와 A가 불일치면, 한칸 이동 후 0번지부터 다시 비교.
 * ABCDABD
 *    ABCDABD ---> 0 0 0 0 ---> D와 A가 불일치면, 한칸 이동 후 0번지부터 다시 비교.
 * ABCDABD
 *     ABCDABD ---> 0 0 0 0 1 ---> A와 A가 일치면, 1번지 비교.
 * ABCDABD
 *     ABCDABD ---> 0 0 0 0 1 2 ---> B와 B가 일치면, 2번지 비교.
 * ABCDABD
 *     ABCDABD ---> 0 0 0 0 1 2 ---> D와 C가 불일치면, 2칸 이동하여 D와 A를 비교.
 * ABCDABD
 *       ABCDABD ---> 0 0 0 0 1 2  ---> D와 A가 불일치면, 한칸 이동 후 0번지부터 다시 비교.
 */
