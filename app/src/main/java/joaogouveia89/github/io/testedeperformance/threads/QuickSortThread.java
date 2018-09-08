package joaogouveia89.github.io.testedeperformance.threads;

import java.util.Random;

import joaogouveia89.github.io.testedeperformance.model.enums.Algorithm;

import static joaogouveia89.github.io.testedeperformance.app.Constants.Threads.MAX_ELEMENTS;

public class QuickSortThread extends Thread {
    private int elements;
    private int[] list;
    private ThreadHasFinished threadHasFinished;
    private long timeInit, timeFinished;

    public QuickSortThread(int elements, ThreadHasFinished threadHasFinished) {
        this.elements = elements;
        this.threadHasFinished = threadHasFinished;
    }

    public void pupulateList(){
        list = new int[MAX_ELEMENTS];
        Random random = new Random();

        for (int i =0; i< list.length; i++)
        {
            list[i] = random.nextInt(9000)+1;
        }
    }

    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];

        // index of smaller element
        int i = (low-1);
        for (int j = low; j <= high-1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private void qSort(int arr[], int l, int h)
    {
        int[] stack = new int[h-l+1];

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;
        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];

            int p = partition(arr, l, h);

            if (p-1 > l)
            {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p+1 < h)
            {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    @Override
    public void run() {
        super.run();
        timeInit = System.currentTimeMillis();
        qSort(this.list, 0, elements-1);
        timeFinished = System.currentTimeMillis();
        threadHasFinished.onThreadFinished(Algorithm.QUICK_SORT.getId(),timeFinished - timeInit);
    }
}
