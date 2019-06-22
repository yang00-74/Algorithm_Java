package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 * calculate the single triangle area and then count them ;
 * 
 * @author Administrator
 * 
 */
public class CalculateArea {

	public static void main(String[] args) {

		CalculateArea c = new CalculateArea();

		Point a = c.new Point(0, 0);
		Point b = c.new Point(4, 4);
		Point d = c.new Point(4, 0);
		Point e = c.new Point(0, 4);
		Point f = c.new Point(2, 5);

		List<CalculateArea.Point> list = new ArrayList<>();

		list.add(a);
		list.add(b);
		list.add(d);
		list.add(e);
		list.add(f);

		System.out.println("Ãæ»ýÊÇ£º" + c.calculatePolygonArea(list));

		for (Point p : list) {
			System.out.println("x:" + p.x + " y:" + p.y);
		}

	}

	// The method is used to calculate the single triangle;
	public int calculateArea(Point a, Point b, Point c) {

		int area = ((b.x - a.x) * (c.y - a.y) - (c.x - a.x)
				* (b.y - a.y)) / 2;

		return area;

	}

	// The method is using one point as the origin ,and then select closed two
	// point make up a
	// triangle,calculate each triangle and count them as the polygon`s area ;
	public int calculatePolygonArea(List<CalculateArea.Point> list) {

		// overwrite the comparator rule,sort the point to ensure the calculate
		// is orderly
		Collections.sort(list, new Comparator<CalculateArea.Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				int i = o1.x - o2.x;
				return i;
			}

		});
		
		int size = list.size();
		int area = 0;
		if (size >= 3) {
			for (int i = 1; i < size - 1; i++) {
				Point a = list.get(0);
				Point b = list.get(i);
				Point c = list.get(i + 1);

				area += calculateArea(a, b, c);
			}
			return area;
		}
		return 0;
	}

	// The class is used to create point ;
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private CalculateArea getOuterType() {
			return CalculateArea.this;
		}
	}

}
