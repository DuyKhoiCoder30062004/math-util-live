import java.util.Scanner;
public class Main
{
  public static void main (String[]args)
  {
	//ha; sa; tF0F!ng quan, ha;i quy.
	//ha;i quy: DF0a;ng ha;i quy ca;'a Y theo X lC  DF0a;ng tha:3ng y=ax+b tha;a mC#n
	//Sigma ca;'a ( (trung bC,nh Y | x-xi) - (a* xi + b) )^2 (MIN)
	// cC!ch tC,m a vC  b 
	// a= [Trung bC,nh XY - Trung bC,nh X * Trung bC,nh Y] / sigma bC,nh phF0F!ng ca;'a nX ( ta:%t ca:# ma:+u tha;- ca;'a X tF0F!ng a;)ng va;i sa; lC n tha;- ca;'a X)
	// b = Trung bC,nh Y - a* Trung bC,nh X
	// ha; sa; tF0F!ng quan : Correlation coefficient : Rxy = [trung bC,nh XY - Trung bC,nh X * Trung bC,nh Y ] / [sigma nX * sigma nY] 
	//Rxy = [Trung bC,nh XY - Trung bC,nh X * Trung bC,nh Y] / [sigma nX * sigma nY]
	/*
	   1 USECASE:
	   Da; dC y lF0a;!i dao a; xF0a;ng cF! khC- vC  sa; ngC y sa;- da;%ng DF0a;#c cho ba;i:
	   chia;u dC y (DF!n va;: mm)  {2.6, 2.8, 3}
	   X (DF!n va;: sa; ngC y sa;- da;%ng) {2, 3, 5} 
	   Ba:#ng:
	   --------------------------------------
	   |Chia;u dC y(mm) | X(Sa; ngC y sa;- da;%ng ) |
	   --------------------------------------
	   |              |  2     3      5      |
	   /--------------------------------------/
	   |2.6           |       1      2      |
	   |2.8           | 1     2             |
	   |3             | 3     2             |
	   --------------------------------------
	   => TC,m phF0F!ng trC,nh ha;i quy ca;'a Y theo X 
	   --------------------------------------
	   |XY|7.8     13    5.6   8.4   6   9
	   |nXY  | 1      2      1     2    3   2  


	   Tia:?n hC nh gia:#i bC i toC!n:
	   Trung bC,nh XY: E(XY) / nXY = (7.8*1 + 13*2 + 5.6 * 1 + 8.4 * 2 + 6 * 3 + 9 * 2 ) / Sum(nXY)

	   Theo gia:# thia:?t, ta cC3 ba:#ng ca;'a X :
	   | X | 2   3  5                         |
	   | --|----------------------------------- |
	   | nX | 4   5  2                         |
	   -----------------------------------------
	   Trung bC,nh X: E(X) / nX = (2*4 + 3*5 + 5*2) / sum(nX) 
	   Sigma bC,nh phF0F!ng ca;'a nX = 1.09 | sigma nX = [ sum[(xi - E(X))] ] / [sum (nX) ] 
	   Theo gia:# thia:?t, ta cC3 ba:#ng ca;'a Y :
	   | y | 2.6  2.8  3                         |
	   | --|----------------------------------- |
	   | nY | 3    3    5                         |
	   --------------------------------------------
	   Trung bC,nh Y: E(Y) / nY = (2.6*3 + 2.8*3 + 3*5) / sum(nY)
	   Sigma bC,nh phF0F!ng ca;'a nY = 1.09 | sigma nY = [ sum[(yi - E(Y))] ] / [sum (nY) ]

	 */
	double EXi[] = new double[3];
	double EYi[] = new double[3];
	double nXi[] = new double[3];
	double nYi[] = new double[3];
	double EXYi[] = new double[6];
	double nXYi[] = new double[6];
	  EXi[0] = 2;
	  EXi[1] = 3;
	  EXi[2] = 5;
	  EYi[0] = 2.6;
	  EYi[1] = 2.8;
	  EYi[2] = 3;
	  nXi[0] = 4;
	  nXi[1] = 5;
	  nXi[2] = 2;
	  nYi[0] = 3;
	  nYi[1] = 3;
	  nYi[2] = 5;
	  EXYi[0] = 7.8;
	  EXYi[1] = 13;
	  EXYi[2] = 5.6;
	  EXYi[3] = 8.4;
	  EXYi[4] = 6;
	  EXYi[5] = 9;
	  nXYi[0] = 1;
	  nXYi[1] = 2;
	  nXYi[2] = 1;
	  nXYi[3] = 2;
	  nXYi[4] = 3;
	  nXYi[5] = 2;

Scanner nhap = new Scanner(System.in);	//System.in lC  1 instance ca;'a class: "InputStream"
	int choice;

	

	
	
	//tC-nh EX - EY

	/*
	   switch (expression) {
	   case value1:
	   // code block to be executed if expression matches value1
	   break;
	   case value2:
	   // code block to be executed if expression matches value2
	   break;
	   // more cases can be added as needed
	   default:
	   // code block to be executed if expression doesn't match any case
	   }
	 */

	do
	  {
	       double sum_nX = 0;
	       double sum_nY = 0;
	        double cov_X = 0;
		      double sigma_X = 0;
		      double cov_Y = 0;
double sigma_Y = 0;
	        double sum_nXY = 0;
	        double cov_XY = 0;
	double sigma_XY = 0;
	  System.out.println ("Xin vui lòng chọn công việc của bạn:");
      System.out.println ("1. Expectation of X");
      System.out.println ("2. Expectation of Y");
      System.out.println ("3. Expectation of XY");
      System.out.println ("4. Covariance of X");
      System.out.println ("5. Covariance of Y");
      System.out.println ("6. Covariance of XY");
      System.out.println ("7. Exit");
	  choice = nhap.nextInt();
		switch (choice)
		  {
		  case 1:
		      	double EX = 0;
	double EX1 = 0;
			for (int i = 0; i < nXi.length; i++)
			  {
				sum_nX += nXi[i];
				EX += EXi[i] * nXi[i];

			  }
			EX1 += (EX / sum_nX);
			System.out.println ("Expectation ca;'a X lC : " + EX1);
			break;
		  case 2:
		      double EY = 0;
	double EY1 = 0;
			for (int i = 0; i < nYi.length; i++)
			  {
				sum_nY += nYi[i];
				EY += EYi[i] * nYi[i];

			  }
			EY1 += (EY / sum_nY);
			System.out.println ("Expectation ca;'a Y lC : " + EY1);
			break;
		  case 3:
		      	double E_XY = 0;
	double E_XY1 = 0;
			//tC-nh E(XY) 
			for (int i = 0; i < nXYi.length; i++)
			  {
				sum_nXY += nXYi[i];
				E_XY += EXYi[i] * nXYi[i];

			  }
			E_XY1 += (E_XY / sum_nXY);
			System.out.println ("Expectation ca;'a XY lC : " + E_XY1);
			break;
		  case 4:
		     
		     	 EX = 0;
	EX1 = 0;
			//calculate Covariance OF X
			for (int i = 0; i < EXi.length; i++)
			  {
				sigma_X += (EXi[i] - EX1) * (EXi[i] - EX1) * nXi[i];
			  }
			cov_X = (sigma_X / sum_nX);
			System.out.println ("Covariance bC,nh phF0F!ng ca;'a X lC : " +
								cov_X);
			break;
		  case 5:
		      	
            EY = 0;
	EY1 = 0;
			//calculate Covariance of Y
			for (int i = 0; i < EYi.length; i++)
			  {
				sigma_Y += (EYi[i] - EY1) * (EYi[i] - EY1) * nYi[i];
			  }
			cov_Y = (sigma_Y / sum_nY);
			System.out.println ("Covariance bC,nh phF0F!ng ca;'a Y lC : " +
								cov_Y);
			break;
		  case 6:
		     	 E_XY = 0;
	E_XY1 = 0;
	
			//calculate Covariance of XY
			for (int i = 0; i < EXYi.length; i++)
			  {
				sigma_XY += (EXYi[i] - E_XY1) * (EXYi[i] - E_XY1) * nXYi[i];
			  }
			cov_XY = (sigma_XY / sum_nXY);
			System.out.println ("Covariance bC,nh phF0F!ng ca;'a XY lC : " +
								cov_XY);
			break;
			case 7:
			    System.out.println("Now the program will exit here!");
			    System.exit(0);
			    break;
		  default:
			System.out.println ("Re-enter the program!");
			System.exit (0);
		  }
	  }while(choice != 7);
  }
}
