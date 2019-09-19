//********************************************************************
//  Sorting.java       Author: Lewis/Loftus
//
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************

public class Sorting
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void selectionSort (Comparable[] list)
   {
      int min;
      Comparable temp;

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0)
               min = scan;

         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }

   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the insertion
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void insertionSort (Comparable[] list)
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
/**  mergeSort
     Precondition: Interval a[begin] through a[end] of a have elements.
     Postcondition: The values in the interval have
     been rearranged so that a[begin] <= a[begin+1] <= ... <= a[end].
    */
    public static void mergeSort(Comparable[] a, int begin, int end)
    {
        if ((end - begin) >= 1)
        {
            int splitPoint = split(a, begin, end);
            mergeSort(a, begin, splitPoint);
            mergeSort(a, splitPoint + 1, end);
            join(a, begin, splitPoint, end);
        }//else sorting one (or fewer) elements so do nothing.
    }

    private static int split(Comparable[] a, int begin, int end)
    { 
        return ((begin + end)/2);
    }

    private static void join(Comparable[] a, int begin, int splitPoint, int end)
    {
        Comparable[] temp;
        int intervalSize = (end - begin + 1);
        temp = new Comparable[intervalSize];
        int nextLeft = begin; //index for first chunk
        int nextRight = splitPoint + 1; //index for second chunk
        int i = 0; //index for temp

        //Merge till one side is exhausted:
        while ((nextLeft <= splitPoint) && (nextRight <= end))
        {
            if (a[nextLeft].compareTo(a[nextRight])< 0) //if a[nL] < a[nR]
            {
                temp[i] = a[nextLeft];
                i++; nextLeft++;
            }

            else
            {
                temp[i] = a[nextRight];
                i++; nextRight++;
            }
        }

        while (nextLeft <= splitPoint)//Copy rest of left chunk, if any.
        {
            temp[i] = a[nextLeft];
            i++; nextLeft++;
        }

        while (nextRight <= end) //Copy rest of right chunk, if any.
        {
            temp[i] = a[nextRight];
            i++; nextRight++;
        }

        for (i = 0; i < intervalSize; i++)
            a[begin + i] = temp[i];
    }

}
