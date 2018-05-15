
public class Collision {
	
	
	public static boolean CheckCollision(Objects a,Objects b)
	{
		int x,y,w,h,r,x1,y1,w1,h1,r1;
		w = a.getW();
		h = a.getH();
		x = a.getX()+w/2;
		y = a.getY()+h/2;
		r = w/2; // j1�� ������

		w1 = b.getW();
		h1 = b.getH();
		x1 = b.getX()+w1/2;
		y1 = b.getY()+h1/2;
		r1 = w1/2; // j2�� ������

		if (Math.pow((x-x1),2)+Math.pow((y-y1),2) <= Math.pow((r+r1),2)) { // �� �� ������ �Ÿ��� �� ���� ���������� �۰ų� ������ �浹
			return true;
		}
		return false;
	}
}
