package joaogouveia89.github.io.testedeperformance.threads;

import java.util.Random;

import joaogouveia89.github.io.testedeperformance.model.enums.Algorithm;

import static joaogouveia89.github.io.testedeperformance.app.Constants.Threads.MAX_ELEMENTS;

public class BubbleSortThread extends Thread {
    private int elements;
    private int[] list;
    private ThreadHasFinished threadHasFinished;
    private long timeInit, timeFinished;

    public BubbleSortThread(int elements, ThreadHasFinished threadHasFinished) {
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

    private void bubbleSort() {
        int temp;
        for(int i = 0; i < elements; i++) {
            for(int j = (i + 1); j < elements; j++) {
                if(list[j] < list[i]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();
        timeInit = System.currentTimeMillis();
        bubbleSort();
        timeFinished = System.currentTimeMillis();
        threadHasFinished.onThreadFinished(Algorithm.BUBBLE_SORT.getId(),timeFinished - timeInit);
    }
}
