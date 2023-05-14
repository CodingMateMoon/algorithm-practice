package basic;

class CountIntersection {

    public static boolean checkIntersection(int arr1[], int arr2[]) {
        int denominator = arr1[0] * arr2[1] - arr1[1] * arr2[0];
        if (denominator == 0)
            return false;

        if ((arr1[1] * arr2[2] - arr1[2] * arr2[1]) % denominator == 0 && (arr1[2] * arr2[0] - arr1[0] * arr2[2]) % denominator == 0) {
            return true;
        }
        return false;
    }

    public static Point createPoint(int arr1[], int arr2[]) {
        int denominator = arr1[0] * arr2[1] - arr1[1] * arr2[0];


        int x = (arr1[1] * arr2[2] - arr1[2] * arr2[1]) / denominator;
        int y = (arr1[2] * arr2[0] - arr1[0] * arr2[2]) / denominator;
        return new Point(x, y);
    }
}
