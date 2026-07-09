/**
 * Utility class providing common searching algorithms.
 */
public class SearchAlgorithms {
    
    /**
     * Performs a linear search on an integer array.
     * @param elements the array to search
     * @param target the element to find
     * @return index of the target, or -1 if not found
     */
    public static int linearSearch(int[] elements, int target) {
        if (elements == null || elements.length == 0) return -1;
        
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == target) {
                return index; // Found element
            }
        }
        return -1;
    }
    
    /**
     * Performs a binary search on a sorted integer array.
     * @param sortedElements the sorted array to search
     * @param target the element to find
     * @return index of the target, or -1 if not found
     */
    public static int binarySearch(int[] sortedElements, int target) {
        if (sortedElements == null || sortedElements.length == 0) return -1;
        
        int startIndex = 0;
        int endIndex = sortedElements.length - 1;
        
        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            
            if (sortedElements[middleIndex] == target) {
                return middleIndex;
            } else if (sortedElements[middleIndex] < target) {
                startIndex = middleIndex + 1; // Target must be in the right half
            } else {
                endIndex = middleIndex - 1;   // Target must be in the left half
            }
        }
        return -1;
    }
}
