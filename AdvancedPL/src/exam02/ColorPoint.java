package exam02;

import java.awt.Color;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ColorPoint {
	private final Point point;
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		if (color == null)
			throw new NullPointerException();
		point = new Point(x, y);
		this.color = color;
	}

	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint) o;
		return cp.point.equals(point) && cp.color.equals(color);
	}
	
	@Override
	public int hashCode() {
		return point.hashCode() + color.hashCode();
	}

	public Set<ColorPoint> blueSet(Set<ColorPoint> original) {
		Set<ColorPoint> blueSet = new AbstractSet<ColorPoint>() {
			public Set<ColorPoint> entrySet() {
				for(ColorPoint cp : original)
					if(!cp.color.equals(Color.BLUE))
						original.remove(cp);
				return original;
			}
			
			public Iterator<ColorPoint> iterator() {
				return new Iterator<ColorPoint>() {
					private Iterator<ColorPoint> i = entrySet().iterator();

					public boolean hasNext() {
						return i.hasNext();
					}

					public ColorPoint next() {
						return i.next();
					}
				};
			}

			public int size() {
				// TODO Auto-generated method stub
				return entrySet().size();
			}

		};
		return blueSet;
	}

	public static void main(String[] args) {
		Set<ColorPoint> cpSet = new HashSet<>();
		ColorPoint[] cps = new ColorPoint[5];
		cps[0] = new ColorPoint(1, 3, Color.RED);
		cps[1] = new ColorPoint(1, 3, Color.BLUE);
		cps[2] = new ColorPoint(2, 3, Color.BLUE);
		cps[3] = new ColorPoint(1, 4, Color.BLUE);
		cps[4] = new ColorPoint(2, 4, Color.BLUE);

		for(ColorPoint cp : cps)
			cpSet.add(cp);

		ColorPoint cp = new ColorPoint(1, 2, Color.BLACK);
		Set<ColorPoint> blueSet = cp.blueSet(cpSet);
		
		for (ColorPoint blue : blueSet) {
			System.out.println(blue.color);
			System.out.println(blueSet.size());
		}
	}
}
