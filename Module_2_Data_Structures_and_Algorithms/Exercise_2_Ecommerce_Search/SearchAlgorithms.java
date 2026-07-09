public class SearchAlgorithms {
    public static int linearSearch(int[] elements, int target) {
        if (elements == null || elements.length == 0) return -1;
        
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == target) {
                return index;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] sortedElements, int target) {
        if (sortedElements == null || sortedElements.length == 0) return -1;
        
        int startIndex = 0;
        int endIndex = sortedElements.length - 1;
        
        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            
            if (sortedElements[middleIndex] == target) {
                return middleIndex;
            } else if (sortedElements[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
