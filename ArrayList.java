public class ArrayList<T> implements List<T> {
   
    protected T[] arr;
    protected int size;

    public ArrayList(){
        arr = (T[]) new Object[10];
        size = 0;
    }

    private void grow_array(){
        int newArraySize = arr.length*2;
        T[] new_arr = (T[]) new Object[newArraySize];
        System.arraycopy(arr, 0, new_arr, 0, arr.length);
        arr = new_arr;
    }

    public void add(T item){
        if(size == arr.length){
            grow_array();
        }
        arr[size++] = item;
    }

    public void add(int position, T item){

        if(size == arr.length){
            grow_array();
        }
        for(int i = size-1; i > position; i--){
            arr[i+1] = arr[i];
        }
        arr[position] = item;
        size++;
    }

    public T get(int position){
        return arr[position];
    }

    public T remove(int position){

        T temp = arr[position];

        for(int i = position; i < size-1; i++){ 

            arr[i] = arr[i+1];
        }
        --size;
        return temp;

    }

    public int size(){
        return size;

    }
}






