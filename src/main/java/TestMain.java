public class TestMain {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,1,3, 7};
            quickSort(array, 0, array.length-1);

            for(int i:array) {
                System.out.println(i);
        }
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int privot = array[l];
        int left = l, right = r;

        while (left < right) {
            while (left < right && array[right] >= privot) {
                right--;
            }

            if (left < right) {
                array[left] = array[right];
                left++;
            }

            while (left < right && array[left] <= privot) {
                left++;
            }

            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = privot;

        quickSort(array, l, (l+r) / 2);
        quickSort(array, (l+r) / 2 + 1, r);
    }


}
