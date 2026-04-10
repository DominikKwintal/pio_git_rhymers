package edu.kis.vh.nursery;
/**
 * Klasa reprezentująca wyliczankę w oparciu o kolejkę FIFO.
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();
    /**
     * Wyciąga element z wyliczanki zgodnie z zasadą FIFO.
     * @return wartość z kolejki.
     */
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
