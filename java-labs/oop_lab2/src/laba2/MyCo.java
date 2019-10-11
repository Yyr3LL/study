package laba2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class MyCo implements Iterable<Integer>, Serializable {

		private int[] data;
		private int size = 0;
		
		public MyCo() {
			data = new int[0];
		}
		
		public String toString() {
			return data.toString();
		}
		
		public void add(int num) {
			data = Arrays.copyOf(data, data.length+1);
			data[size++] = num;
		}
		
		public void clear() {
			data = new int[0];
		}
		
		public boolean remove(int num) {
			int[] newData = new int[size-1];
			int j = 0;
			for (int i = 0; i < size; i ++)
				if (data[i] != num)
					newData[j++] = data[i];
			size --;
			data = newData;
			return true;
		}
		
		public int[] toArray() {
			return data;
		}
		
		public int size() {
			return size;
		}
		
		public boolean contains(int num) {
			for (int i = 0; i < size; i ++)
				if (data[i] == num)
					return true;
			return false;
		}
		
		public boolean containsAll(MyCo si) {
			int[] arr = si.toArray();
			return Arrays.asList(data).containsAll(Arrays.asList(arr));
		}
		
		public class InnerIterator implements Iterator<Integer> {
			int index;
			
			public InnerIterator() {
				index = 0;
			}
			
			public boolean hasNext() {
				return index < size;
			}
			
			public Integer next() {
				return data[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		public Iterator<Integer> iterator() {
			return new InnerIterator();
		}
}

