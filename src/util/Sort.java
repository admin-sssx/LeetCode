package util;

public class Sort {
    int size ;
    int arr[] = new int[size];

    public static void maoPao(int arr[]){
        Srand srand = new Srand();
        System.out.println("----------------source data-------------------");
        srand.showArr(arr);
        System.out.println("----------------maopao start-------------------");
        for (int i = 0; i <arr.length-1 ; i++) {

            for (int j = 0; j < arr.length-i-1; j++) {

                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            srand.showArr(arr);

        }
        System.out.println("----------------maopao end-------------------");

    }

    public static void quickSort(int arr[]){
        Srand srand = new Srand();
        System.out.println("----------------source data-------------------");
        srand.showArr(arr);
        System.out.println("----------------quick start-------------------");
    }
}
