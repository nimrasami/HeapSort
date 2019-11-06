public class HeapSort {

    //Heap array
    public static void main(String args[]) {
        int array[] = {6, 12, 34, 29, 28, 11, 23, 7, 0, 33, 30, 45};
        int var = array.length;

        HeapS list = new HeapS();
        list.heapMax(array);

        System.out.println("Sorted array is: ");
        heapPrint(array);
    }
    
    //Print heap
    public static void heapPrint(int array[]) {
        int num = array.length;
        for (int x = 0; x < num; ++x) {
            System.out.print(array[x] + " ");
        }
        System.out.println();
    }
}

class HeapS {

    //Perculateup method 
    public void perculateUp(int ar[], int x, int root) {
        int parent = root; 
        int leftc = 2 * root + 1; 
        int rightc = 2 * root + 2; 

        if (rightc < x && ar[rightc] > ar[parent]) {
            parent = rightc;
        }
        
        if (leftc < x && ar[leftc] > ar[parent]) {
            parent = leftc;
        }

        if (parent != root) {
            int numb = ar[root];
            ar[root] = ar[parent];
            ar[parent] = numb;
            
            perculateUp(ar, x, parent);
        }
    }
    //Heap max
    public void heapMax(int arr[]) {
        int num = arr.length;
        
        for (int x = num / 2 - 1; x >= 0; x--) {
            perculateUp(arr, num, x);
        }

        for (int x = num - 1; x >= 0; x--) {

            int temp = arr[0];
            arr[0] = arr[x];
            arr[x] = temp;

            perculateUp(arr, x, 0);
        }
    }

}

