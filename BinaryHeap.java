public class BinaryHeap {
	
	private int[] array;
	private int size;
	
	BinaryHeap() {
		this.array = new int[10];
		this.size = 0;
	}
	
	void add(int priority) {
		if (this.size == this.array.length) {
			doubleSizeOfHeap();
		}
		this.array[this.size++] = priority;
		int i = this.size - 1;
		while (this.array[i] < this.array[parent(i)] && i > 0) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	int remove() {
		int temp = this.array[0];
		this.array[0] = this.array[--size];
		bubbleDown(0);
		return temp;
	}
	
	int parent (int index) {
		return (index - 1) / 2;
	}
	
	void swap(int i, int j) {
		int temp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = temp;
	}
	
	void doubleSizeOfHeap() {
		int[] newArray = new int[this.size * 2];
		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}
	
	void bubbleDown(int index) {
		int child = index;
		if (leftChild(index) < this.size) {
			child = leftChild(index);
		}
		if (rightChild(index) < this.size && this.array[rightChild(index)] < this.array[index]) {
			child = rightChild(index);
		}
		if (this.array[index] > this.array[child]) {
			swap(index, child);
			bubbleDown(child);
		}
	}
	
	int leftChild (int index) {
		return (index * 2) + 1;
	}
	
	int rightChild (int index) {
		return (index * 2) + 2;
	}
	
}
